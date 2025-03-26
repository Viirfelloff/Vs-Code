from time import sleep
import pygame
from pygame.locals import *
import sys
import random
import time

import IndivTypeTest

# Initialize pygame
# TODO: add animation mechanic looping thru frames.
pygame.init()
pygame.display.set_caption("Coin Game")
length, width = 500, 500
display = pygame.display.set_mode((length, width))
# Load images
def lvl1():
    try:
        player = pygame.image.load("player.png")
        player = pygame.transform.scale(player, (75,75))
        coin = pygame.image.load("coin.png")
        coin = pygame.transform.scale(coin, (50,50))
        obstacle1 = pygame.image.load("sadf.png")
        obstacle1 = pygame.transform.scale(obstacle1, (100,100))
        obstacle2 = pygame.image.load("2341.png")
        obstacle2 = pygame.transform.scale(obstacle2,(100,100))
        obstacle3 = pygame.image.load("asdf2.png")
        obstacle3 = pygame.transform.scale(obstacle3, (100,100))
        obstacle4 = pygame.image.load("sdf3.png")
        obstacle4 = pygame.transform.scale(obstacle4,(100,100))
        # time to make obstacles!
    except pygame.error as e:
        print(f"Error loading images: {e}")
        pygame.quit()
        exit()
    # Initialize positions
    #placeholders
    x1, y1 = 200, 200
    x2, y2 = 70,290 # left down
    x3, y3 = 70,55 # left up
    x4,y4 = 325,335 # right down
    x5,y5 = 325,50 # right up
    x, y = 450, 450
    # haha no gravity = 0.01


    # Clock for frame rate control
    clock = pygame.time.Clock()
    time = 800
    score = 0
    # Game loop
    last_x1, last_y1 = x1, y1
    running = True
    while running:
        clock.tick(60)  # Control frame rate
        time -= 1  # Decrease time
        if time <= 0:
            running = False  # Stop game when time runs out
            print()
            print("Time Has Run out!")
            print("Score: " + str(score))
            break
        display.fill((0, 175, 0))  # Clear screen
        display.blit(player, (x1, y1))  # Draw player
        display.blit(coin, (x, y))  # Draw coin
        # Handle events
        for event in pygame.event.get():
            if event.type == QUIT:
                running = False
                pre = False
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
        # drawing objects
        display.blit(obstacle1, (x2, y2))
        display.blit(obstacle2, (x3, y3))
        display.blit(obstacle3, (x4, y4))
        display.blit(obstacle4, (x5, y5))
        # collision boxes
        obstacle1Col = pygame.Rect(x2,y2,50,50) #same size as obstacle
        obstacle2Col = pygame.Rect(x3,y3,50,50)
        obstacle3Col = pygame.Rect(x4,y4,50,50)
        obstacle4Col = pygame.Rect(x5,y5,50,50)
        playerCollision = pygame.Rect(x1, y1, 75, 75)
        coinCollision = pygame.Rect(x, y, 50, 50)
        if x1 != last_x1 or y1 != last_y1:
            sys.stdout.write(f"\rPosition: {x1}, {y1}  ")  # Overwrite the same line
            sys.stdout.flush()
            last_x1, last_y1 = x1, y1  # Update previous position
        if playerCollision.colliderect(coinCollision):
            score += 1
            x = random.randint(0,400)
            y = random.randint(0,400)
            diffx = x1 - x
            diffy = y1 - y
            if diffx < 10 and diffx > 0:
                x += 60
            if diffx > -10 and diffx < 0:
                x += -60
            if diffy < 10 and diffy > 0:
                y += 60
            if diffy > -10 and diffy < 0:
                y += -60
        #2nd collison detection checker
        if playerCollision.colliderect(obstacle1Col) or playerCollision.colliderect(obstacle2Col) or playerCollision.colliderect(obstacle3Col) or playerCollision.colliderect(obstacle4Col):
            print()
            print("You died!")
            print("Score: " + str(score))
            break
        pygame.display.update() # Update display
IndivTypeTest.IndivType("Welcome to a Coin Game! Try to collect as many coins as possible, before the time runs out! Avoid the bombs!")
lvl1()