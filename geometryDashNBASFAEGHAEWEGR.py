from time import sleep

import pygame
from pygame import K_SPACE
import keyboard
import math

pygame.init()

# Window setup
length = 900
width = 500
display = pygame.display.set_mode((length, width))
pygame.display.set_caption("Geometry Dash Jump Test")
clock = pygame.time.Clock()
global running
running = True
global score
score =  0
# Load images
try:
    spike = pygame.image.load("spike_again-removebg-preview.png")
    spike = pygame.transform.scale(spike, (50, 50))
    back = pygame.image.load("geo.jpg")
    player = pygame.image.load("gomeetry ahs.png")
    player = pygame.transform.scale(player, (75, 75))
    spike2 = pygame.image.load("spike2.png")
    spike2 = pygame.transform.scale(spike2, (50,50))
    spike3 = pygame.image.load("spike3.png")
    spike3 = pygame.transform.scale(spike3, (50,50))
    back = pygame.transform.scale(back, (length, width))
except pygame.error as e:
    print(f"Error loading images: {e}")
    pygame.quit()
    exit()


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
spike2x = spikex + 40
spike2y = 310
spike3x = spike2x + 40
spike3y = 310
global spikeDrawn
spikeDrawn = False
global spike2Drawn
spike2Drawn = False
global spike3Drawn
spike3Drawn = False
global movespikeamt
movespikeamt = 7
global spikesDrawn
spikesDrawn = 0
global increment
increment = 8
global timesjumped
timesjumped = 0
def drawSpikes():
    global spikex, spike2x, movespikeamt #draw and move first spike
    global spikesDrawn
    global score
    spikecol = pygame.Rect(spikex + increment, spikey + 20, 20, 30)
    pygame.draw.rect(display, (255, 255, 255), spikecol)
    spikex -= movespikeamt
    if spikex < -50:
        spikex = 900
        score += 1
        spikesDrawn += 1
    if spikecol.colliderect(playerCol):
        global running
        running = False
        print("Score: " + str(score))
    display.blit(spike, (spikex, spikey))
def drawSpikes2():
    global spike2x# Draw and move second spike
    global spikesDrawn
    global score
    spike2x = spikex + 40
    spike2col = pygame.Rect(spike2x + 9, spike2y + 20, 20, 30)
    pygame.draw.rect(display, (255, 255, 255), spike2col)
    if spike2col.colliderect(playerCol):
        global running
        running = False
        print("Score: " + str(score))
    display.blit(spike2, (spike2x, spike2y))
global spikesdrawn
def drawSpikes3():
    global spikex, spike2x, spike3x  # draw and move third spike
    global spikesDrawn
    global score
    spike3x = spike2x + 40
    spike3col = pygame.Rect(spike3x + 10, spike3y + 20, 20, 30)
    pygame.draw.rect(display, (255, 255, 255), spike3col)
    if spike3col.colliderect(playerCol):
        global running
        running = False
        print("Score: " + str(score))
    display.blit(spike3, (spike3x, spike3y))
def moveSpike():
    global spikeDrawn
    global spike2Drawn
    global spike3Drawn
    global spikesDrawn
    if spikeDrawn == False:
        drawSpikes()
        if spikesDrawn >= 5:
            drawSpikes2()
            if spikesDrawn >= 10:
                drawSpikes3()
    if spikex <= 0 or spike2x <= 0 or spike3x <= 0:
        spikeDrawn = False
        spike3Drawn = False
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
        timesjumped += 1
    if timesjumped == 10:
        increment -= 0.05
    # Draw everything
    display.blit(back, (0, 0))
    display.blit(player, (playerx, playery))
    playerCol = pygame.Rect(playerx, playery, 75,75)
    moveSpike()
    jump_strength += 0.002
    movespikeamt += 0.002
    pygame.display.update()
