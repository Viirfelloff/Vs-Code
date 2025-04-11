from time import sleep

import pygame
from pygame import K_SPACE
import keyboard

pygame.init()

# Window setup
length = 900
width = 500
display = pygame.display.set_mode((length, width))
pygame.display.set_caption("Geometry Dash Jump Test")
clock = pygame.time.Clock()
global running
running = True

# Load images
try:
    spike = pygame.image.load("spike_again-removebg-preview.png")
    spike = pygame.transform.scale(spike, (50, 50))
    back = pygame.image.load("geo.jpg")
    player = pygame.image.load("gomeetry ahs.png")
    player = pygame.transform.scale(player, (75, 75))
    spike2 = pygame.image.load("spike2.png")
    spike2 = pygame.transform.scale(spike2, (50,50))
    back = pygame.transform.scale(back, (length, width))
except pygame.error as e:
    print(f"Error loading images: {e}")
    pygame.quit()
    exit()


# 🔊 Music functions
def playMusic(track):
    pygame.mixer.init()
    pygame.mixer.stop()
    pygame.mixer.music.load(track)
    pygame.mixer.music.play(-1)  # Loop forever


def playSound(track2):
    pygame.mixer.init()
    sound = pygame.mixer.Sound(track2)
    sound.play()


# Start music
playMusic("klutter.mp3")

# Physics vars
playerx = 100
playery = 283 # Start on the ground
velocity_y = 0
gravity = 1
jump_strength = -17
on_ground = True
spikex = 900
spikey = 310
spike2x = 940
spike2y = 310
spikecolx = spikex
spikecoly = spikey
spikecol2x = spike2x
spikecol2y = spike2y
global spikeDrawn
spikeDrawn = False
global spike2Drawn
spike2Drawn = False
global movespikeamt
movespikeamt = 7
global spikesDrawn
spikesDrawn = 0

# Function to draw and move the spike

def drawSpikes():
    global spikex, spike2x, movespikeamt #draw and move first spike
    global spikesDrawn
    spikecol = pygame.Rect(spikex, spikey, 20, 30)
    spikex -= movespikeamt
    if spikex < -50:
        spikex = 900
        spikesDrawn += 1
    if spikecol.colliderect(playerCol):
        global running
        running = False
    display.blit(spike, (spikex, spikey))  # <<< This was missing!
def drawSpikes2():
    global spike2x# Draw and move second spike
    global movespikeamt
    global spikesDrawn
    spike2col = pygame.Rect(spike2x, spike2y, 20, 30)
    spike2x = spikex + 40
    if spike2x < -50:
        spike2x = 920
        spikesDrawn += 1
    if spike2col.colliderect(playerCol):
        global running
        running = False
    display.blit(spike2, (spike2x, spike2y))
    pygame.display.update()
global spikesdrawn
def moveSpike():
    global spikeDrawn
    global spike2Drawn
    global spikesDrawn
    if spikeDrawn == False:
        drawSpikes()
        if spikesDrawn >= 5:
            drawSpikes2()
    if spikex <= 0 or spike2x <= 0:
        spikeDrawn = False
        spike2Drawn = False
# Main game loop
while running:
    clock.tick(60)

    # Gravity and movement
    velocity_y += gravity
    playery += velocity_y

    # Ground collision
    if playery >= 283:
        playery = 283
        velocity_y = 0
        on_ground = True

    # Event handling
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Jump input
    keys = pygame.key.get_pressed()
    if keys[K_SPACE] and on_ground:
        velocity_y = jump_strength
        on_ground = False  # optional sound effect

    # Draw everything
    display.blit(back, (0, 0))
    display.blit(player, (playerx, playery))
    playerCol = pygame.Rect(playerx, playery, 75,75)
    moveSpike()
    jump_strength += 0.001
    movespikeamt += 0.001
    pygame.display.update()
