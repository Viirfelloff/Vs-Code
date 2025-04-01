from time import sleep
import pygame
from pygame.locals import *
import sys
import random
import time
import math

import IndivTypeTest
from pgame import enemy_speed

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


    # Clock for frame rate control
    clock = pygame.time.Clock()
    time = 80000000000000000
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
            diffxObst1 = x2 - x
            diffxObst2 = x3 - x
            diffxObst3 = x4 - x
            diffxObst4 = x5 - x
            diffyObst1 = y2 - y
            diffyObst2 = y3 - y
            diffyObst3 = y4 - y
            diffyObst4 = y5 - y
            if diffxObst1 < 10 and diffxObst1 > 0:
                x += 60
            if diffxObst1 > -10 and diffxObst1 < 0:
                x += -60
            if diffyObst1 < 10 and diffyObst1 > 0:
                y += 60
            if diffyObst1 > -10 and diffyObst1 < 0:
                y += -60
            if diffxObst2 < 10 and diffxObst2 > 0:
                x += 60
            if diffxObst2 > -10 and diffxObst2 < 0:
                x += -60
            if diffyObst2 < 10 and diffyObst2 > 0:
                y += 60
            if diffyObst2 > -10 and diffyObst2 < 0:
                y += -60
            if diffxObst3 < 10 and diffxObst3 > 0:
                x += 60
            if diffxObst3 > -10 and diffxObst3 < 0:
                x += -60
            if diffyObst3 < 10 and diffyObst3 > 0:
                y += 60
            if diffyObst3 > -10 and diffyObst3 < 0:
                y += -60
            if diffxObst4 < 10 and diffxObst4 > 0:
                x += 60
            if diffxObst4 > -10 and diffxObst4 < 0:
                x += -60
            if diffyObst4 < 10 and diffyObst4 > 0:
                y += 60
            if diffyObst4 > -10 and diffyObst4 < 0:
                y += -60
            x = random.randint(0,400)
            y = random.randint(0,400)
        #2nd collison detection checker
        if score >= 3:
            display.blit(obstacle1, (x2, y2))
            obstacle1Col = pygame.Rect(x2, y2, 110, 110)
            if playerCollision.colliderect(obstacle1Col):
                print()
                print("Game Over! You Died!")
                print()
                print("Score: " + str(score))
                running = False
                break
            if score >= 5:
                display.blit(obstacle2, (x3, y3))
                obstacle2Col = pygame.Rect(x3, y3, 110, 110)
                if playerCollision.colliderect(obstacle2Col):
                    print()
                    print("Game Over! You Died!")
                    print()
                    print("Score: " + str(score))
                    running = False
                    break
                if score >= 6:
                    display.blit(obstacle3, (x4,y4))
                    obstacle3Col = pygame.Rect(x4, y4, 110, 110)
                    if playerCollision.colliderect(obstacle3Col):
                        print()
                        print("Game Over! You Died!")
                        print()
                        print("Score: " + str(score))
                        running = False
                        break
                    if score >= 7:
                        display.blit(obstacle4, (x5, y5))
                        obstacle4Col = pygame.Rect(x5, y5,110,110)
                        if playerCollision.colliderect(obstacle4Col):
                            print()
                            print("Game Over! You Died!")
                            print()
                            print("Score: " + str(score))
                            running = False
                            break
                        if score >= 8:
                            distance1x = x2-x1
                            distance1y= y2-y1
                            distance2x = x3-x1
                            distance2y= y3-y1
                            distance3x = x4-x1
                            distance3y= y4-y1
                            distance4x = x5-x1
                            distance4y= y5-y1
                            distance1 = math.sqrt(distance1x * distance1x + distance1y * distance1y)
                            distance2 = math.sqrt(distance2x * distance2x + distance2y * distance2y)
                            distance3 = math.sqrt(distance3x * distance3x + distance3y * distance3y)
                            distance4 = math.sqrt(distance4x * distance4x + distance4y * distance4y)
                            enemy_speed = 2
                            if distance1 != 0 or distance2 != 0 or distance3 != 0 or distance4 != 0:
                                distance1x = distance1x / distance1
                                distance2x = distance2x / distance2
                                distance3x = distance3x / distance3
                                distance4x = distance4x / distance4
                                distance1y = distance1y / distance1
                                distance2y = distance2y / distance2
                                distance3y = distance3y / distance3
                                distance4y = distance4y / distance4
                                x2 += distance1x * enemy_speed
                                x3 += distance2x * enemy_speed
                                x4 += distance3x * enemy_speed
                                x5 += distance4x * enemy_speed
                                y2 += distance1y * enemy_speed
                                y3 += distance2y * enemy_speed
                                y4 += distance3y * enemy_speed
                                y5 += distance4y * enemy_speed
        pygame.display.update() # Update display
# IndivTypeTest.IndivType("Welcome to a Coin Game! Try to collect as many coins as possible, before the time runs out! Avoid the bombs!")
lvl1()
