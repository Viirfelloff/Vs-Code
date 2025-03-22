import pygame
from pygame.locals import *
from sys import exit
import random
pygame.init()
x1 = 300
y1= 300
coin_collected = False
xex = random.randint(50,400)
yex = random.randint(50,400)
xex1 = random.randint(50,400)
yex1 = random.randint(50,400)
x = random.randint(10,600)
y = random.randint(10,600)
x2 = random.randint(10,600)
y2 = random.randint(10,600)
x3 = random.randint(10,600)
y3 = random.randint(10,600)
x4 = random.randint(10,600)
y4 = random.randint(10,600)
x5 = random.randint(10,600)
y5 = random.randint(10,600)
x6 = random.randint(10,600)
y6 = random.randint(10,600)
enemy = pygame.image.load("enemy.png")
enemy1 = pygame.image.load("enemy1.png")
img = pygame.image.load("player.png")
img2 = pygame.image.load("coin.png")
img3 = pygame.image.load("coin2.png")
img4 = pygame.image.load("coin3.png")
img5 = pygame.image.load("coin4.png")
img6 = pygame.image.load("coin5.png")
img7 = pygame.image.load("coin6.png")
time = 850
clock = pygame.time.Clock()
score = 0
transparent = (0,0,0,0)
# infinite loop
while time > 0:
    clock.tick(60)
    enemyxv = x1 - xex
    enemyyv = y1 - yex
    xex += enemyxv / 120
    yex += enemyyv / 120
    enemy_collision = pygame.Rect(xex,yex,20,20)
    player_collision = pygame.Rect(x1, y1, 20, 20)
    coin1collision = pygame.Rect(x,y,20,20)
    coin2collision = pygame.Rect(x2,y2,20,20)
    coin3collision = pygame.Rect(x3,y3,20,20)
    coin4collision = pygame.Rect(x4, y4, 20, 20)
    coin5collision = pygame.Rect(x5, y5, 20, 20)
    coin6collision = pygame.Rect(x6, y6, 20, 20)
    if player_collision.colliderect(coin1collision):
        score += 1
        img2.fill(transparent)
        x -= 600
        y -= 600
        coin_collected = True
    if player_collision.colliderect(coin2collision):
        score += 1
        img3.fill(transparent)
        x2 -= 600
        y2 -= 600
        coin_collected = True
    if player_collision.colliderect(coin3collision):
        score += 1
        img4.fill(transparent)
        x3 -= 600
        y3 -= 600
        coin_collected = True
    if player_collision.colliderect(coin4collision):
        score += 1
        img5.fill(transparent)
        x4 -= 600
        y4 -= 600
        coin_collected = True
    if player_collision.colliderect(coin5collision):
        score += 1
        img6.fill(transparent)
        x5 -= 600
        y5 -= 600
        coin_collected = True
    if player_collision.colliderect(coin6collision):
        score += 1
        img7.fill(transparent)
        x6 -= 600
        y6 -= 600
        coin_collected = True
    if player_collision.colliderect(enemy_collision):
        time = 0
    time -= 1
    pygame.init()
    window = pygame.display.set_mode((600,600))
    window.fill((0,175,0))
    window.blit(img,pygame.Rect(x1,y1,100,100))
    window.blit(img2,pygame.Rect(x,y,100,100))
    window.blit(img3,pygame.Rect(x2,y2,100,100))
    window.blit(img4, pygame.Rect(x3, y3, 100, 100))
    window.blit(img5, pygame.Rect(x4, y4, 100, 100))
    window.blit(img6, pygame.Rect(x5, y5, 100, 100))
    window.blit(img7, pygame.Rect(x6, y6, 100, 100))
    window.blit(enemy,pygame.Rect(xex,yex,100,100))
    if time < 600:
        window.blit(enemy1,pygame.Rect(xex1,yex1,100,100))
        enemyxv1 = x1 - xex1
        enemyyv1 = y1 - yex1
        xex1 += enemyxv1 / 80
        yex1 += enemyyv1 / 80
        enemy1_collision = pygame.Rect(xex1, yex1, 20, 20)
        if player_collision.colliderect(enemy1_collision):
            time = 0
    pygame.display.update()
    for event in pygame.event.get():
        if event.type == QUIT:
            exit()
        if event.type == KEYDOWN:
            if event.key == K_RIGHT:
                x1 = x1 + 12
            if event.key == K_LEFT:
                x1 = x1 - 12
            if event.key == K_UP:
                y1 = y1 - 12
            if event.key == K_DOWN:
                y1 = y1 + 12
        pygame.display.flip()
if time == 0:
    print(score)
