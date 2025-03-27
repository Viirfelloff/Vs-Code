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
        obstacle1 = pygame.image.load("bomb.png")
        obstacle1 = pygame.transform.scale(obstacle1, (110, 110))
        obstacle2 = pygame.image.load("bomb2.png")
        obstacle2 = pygame.transform.scale(obstacle2, (110, 110))
        obstacle3 = pygame.image.load("bomb3.png")
        obstacle3 = pygame.transform.scale(obstacle3, (110, 110))
        obstacle4 = pygame.image.load("bomb4.png")
        obstacle4 = pygame.transform.scale(obstacle4, (110, 110))
        obstacle5 = pygame.image.load("bomb5.png")
        obstacle5 = pygame.transform.scale(obstacle5, (110, 110))
        obstacle6 = pygame.image.load("bomb6.png")
        obstacle6 = pygame.transform.scale(obstacle6, (110, 110))
        # DEFINE OBSTACLE IMAGES HERE
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
    x6, y6 = 200,200
    x7, y7 = 205, 20
    # haha no gravity = 0.01


    # Clock for frame rate control
    clock = pygame.time.Clock()
    time = 800
    score = 0
    # Game loop
    last_x1, last_y1 = x1, y1
    global running
    running = True
    while running:
        clock.tick(60)  # Control frame rate
        time -= 1  # Decrease time
        if time <= 0:
            print()
            print("Time Has Run out!")
            print("Score: " + str(score))
            running = False
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
        # drawing objects
        # collision boxes
        playerCollision = pygame.Rect(x1, y1, 75, 75)
        coinCollision = pygame.Rect(x, y, 50, 50)
        # right up
        # DRAW OBSTACLE COLLISIONS HERE
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
        if score >= 5:
            display.blit(obstacle1, (x2, y2))
            obstacle1Col = pygame.Rect(x2, y2, 90, 90)
            if playerCollision.colliderect(obstacle1Col):
                print()
                print("Game Over! You Died!")
                print()
                print("Score: " + str(score))
                running = False
                break
            if score >= 10:
                display.blit(obstacle2, (x3, y3))
                obstacle2Col = pygame.Rect(x3, y3, 90, 90)
                if playerCollision.colliderect(obstacle2Col):
                    print()
                    print("Game Over! You Died!")
                    print()
                    print("Score: " + str(score))
                    running = False
                    break
                if score >= 15:
                    display.blit(obstacle3, (x4,y4))
                    obstacle3Col = pygame.Rect(x4, y4, 90, 90)
                    if playerCollision.colliderect(obstacle3Col):
                        print()
                        print("Game Over! You Died!")
                        print()
                        print("Score: " + str(score))
                        running = False
                        break
                    if score >= 20:
                        display.blit(obstacle4, (x5, y5))
                        obstacle4Col = pygame.Rect(x5, y5, 90, 90)
                        display.blit(obstacle5, (x6, y6))
                        obstacle5Col = pygame.Rect(x6, y6, 90, 90)
                        display.blit(obstacle6, (x7, y7))
                        obstacle6Col = pygame.Rect(x7, y7, 90, 90)
                        if playerCollision.colliderect(obstacle4Col) or playerCollision.colliderect(obstacle5Col) or playerCollision.colliderect(obstacle6Col):
                            print()
                            print("Game Over! You Died!")
                            print()
                            print("Score: " + str(score))
                            running = False
                            break
        pygame.display.update() # Update display
IndivTypeTest.IndivType("Welcome to a Coin Game! Try to collect as many coins as possible, before the time runs out! Avoid the bombs!")
lvl1()