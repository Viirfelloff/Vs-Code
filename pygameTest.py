import pygame
from pygame.locals import *

# Initialize pygame
pygame.init()
pygame.display.set_caption("Coin Game")

# Load images
try:
    player = pygame.image.load("player.png")
    coin = pygame.image.load("coin.png")
except pygame.error as e:
    print(f"Error loading images: {e}")
    pygame.quit()
    exit()

# Initialize positions
x1, y1 = 200, 200
x, y = 450, 450
length, width = 500, 500

# Set up display
display = pygame.display.set_mode((length, width))

# Clock for frame rate control
clock = pygame.time.Clock()
time = 850

# Game loop
running = True
while running:
    clock.tick(60)  # Control frame rate
    time -= 1  # Decrease time

    if time <= 0:
        running = False  # Stop game when time runs out
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
    if keys[K_a]:  # Move left
        x1 -= 5
    if keys[K_d]:  # Move right
        x1 += 5
    if keys[K_w]:  # Move up
        y1 -= 5
    if keys[K_s]:  # Move down
        y1 += 5

    pygame.display.update()  # Update display

# Quit pygame properly
pygame.quit()
