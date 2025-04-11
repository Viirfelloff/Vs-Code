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
spikecolx = spikex
spikecoly = spikey
global spikeDrawn
spikeDrawn = False
global control1
control1 = False
global control2
control2 = False
# Function to draw and move the spike
def drawSpike(x,y):
    if spikeDrawn == False:
        global spikex  # Make spikex a global variable to modify it
        spikecol = pygame.Rect(x, y, 20,30)
        x -= 7
        if x < -50:  # Reset the spike when it's off-screen
            x = 900
        if spikecol.colliderect(playerCol):
            global running
            running = False
        display.blit(spike, (x, y))
    spike_positions = [

    ]
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
    drawSpike(spikex, spikey)
    pygame.display.update()
