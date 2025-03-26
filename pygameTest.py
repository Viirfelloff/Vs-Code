import pygame
from pygame.locals import *
import sys

# Initialize pygame
pygame.init()
pygame.display.set_caption("Coin Game")

# Load images
try:
    player = pygame.image.load("player.png")
    player = pygame.transform.scale(player, (100,100))
    coin = pygame.image.load("coin.png")
    coin = pygame.transform.scale(coin, (50,50))
except pygame.error as e:
    print(f"Error loading images: {e}")
    pygame.quit()
    exit()
# Initialize positions
x1, y1 = 200, 200
x, y = 450, 450
length, width = 500, 500
gravity = 0.01

# Set up display
display = pygame.display.set_mode((length, width))

# Clock for frame rate control
clock = pygame.time.Clock()
time = 1000000
# Game loop
running = True
while running:
    clock.tick(60)  # Control frame rate
    time -= 1  # Decrease time

    if time <= 0:
        running = False  # Stop game when time runs out
        print()
        print("Time Has Run out!")
        break
    display.fill((0, 175, 0))  # Clear screen
    display.blit(player, (x1, y1))  # Draw player
    display.blit(coin, (x, y))  # Draw coin

    # Handle events
    for event in pygame.event.get():
        if event.type == QUIT:
            running = False
            break

    # Get key states for smooth movement
    keys = pygame.key.get_pressed()
    if keys[K_LEFT]:  # Move left
        x1 -= 5
    if keys[K_RIGHT]:  # Move right
        x1 += 5
    if keys[K_UP]:  # Move up
        y1 -= 5
    if keys[K_DOWN]:  # Move down
        y1 += 5
    if x1 < 0:
        x1 = 0
    if y1 < 0:
        y1 = 0
    if x1 > 400:
        x1 = 400
    if y1 > 400:
        y1 = 400
    sys.stdout.write(f"\rPosition: {x1}, {y1}  ")
    sys.stdout.flush()
    pygame.display.update() # Update display
# Quit pygame properly
pygame.quit()
