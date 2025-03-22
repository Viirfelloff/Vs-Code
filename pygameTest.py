import pygame
from pygame.locals import *

pygame.init()
pygame.display.set_caption("Coin Game")

# Load images
player = pygame.image.load("player.png")
coin = pygame.image.load("coin.png")

# Initialize positions
x1, y1 = 200, 200
x, y = 450, 450

# Set up display
display = pygame.display.set_mode((500, 500))

# Clock for frame rate control
clock = pygame.time.Clock()

running = True
while running:
    # Fill screen to clear previous frame
    display.fill((0, 175, 0))

    # Draw images at updated positions
    display.blit(player, (x1, y1))
    display.blit(coin, (x, y))

    # Handle events
    for event in pygame.event.get():
        if event.type == QUIT:
            running = False
        if event.type == KEYDOWN:
            if event.key == K_RIGHT:
                x1 += 30
            if event.key == K_LEFT:
                x1 -= 30
            if event.key == K_UP:
                y1 -= 30
            if event.key == K_DOWN:
                y1 += 30

    # Update display
    pygame.display.update()

    # Control frame rate
    clock.tick(30)

# Quit pygame properly
pygame.quit()
