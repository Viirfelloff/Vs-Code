import pygame
import random
import math

# Initialize Pygame
pygame.init()

# Screen settings
WIDTH, HEIGHT = 800, 600
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Adventure Game: Defeat the Boss")

# Load images
player_img = pygame.image.load("player-removebg-preview.png")
player_img = pygame.transform.scale(player_img, (50, 50))
enemy_img = pygame.image.load("enemy-removebg-preview.png")
enemy_img = pygame.transform.scale(enemy_img, (40, 40))
boss_img = pygame.image.load("Screenshot_2025-03-27_181901-removebg-preview.png")
boss_img = pygame.transform.scale(boss_img, (100, 100))

# Colors
WHITE = (255, 255, 255)
RED = (255, 0, 0)
GREEN = (0, 255, 0)

# Game variables
player = pygame.Rect(100, 100, 50, 50)
player_speed = 4
player_health = 5

enemies = [pygame.Rect(random.randint(100, 700), random.randint(100, 500), 40, 40) for _ in range(3)]
enemy_speed = 2

boss = pygame.Rect(600, 250, 100, 100)
boss_health = 10
boss_speed = 1.5

# Game loop
running = True
attacking = False
attack_timer = 0

clock = pygame.time.Clock()


def move_enemy(enemy, target):
    """Moves enemy towards the player"""
    dx, dy = target.x - enemy.x, target.y - enemy.y
    dist = math.sqrt(dx ** 2 + dy ** 2)
    if dist != 0:
        dx, dy = dx / dist, dy / dist
        enemy.x += dx * enemy_speed
        enemy.y += dy * enemy_speed


def move_boss(target):
    """Boss moves slower but is more powerful"""
    global boss
    dx, dy = target.x - boss.x, target.y - boss.y
    dist = math.sqrt(dx ** 2 + dy ** 2)
    if dist != 0:
        dx, dy = dx / dist, dy / dist
        boss.x += dx * boss_speed
        boss.y += dy * boss_speed


while running:
    screen.fill((50, 50, 50))  # Background color

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Player Movement
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]: player.x -= player_speed
    if keys[pygame.K_RIGHT]: player.x += player_speed
    if keys[pygame.K_UP]: player.y -= player_speed
    if keys[pygame.K_DOWN]: player.y += player_speed

    # Attack Mechanic
    if keys[pygame.K_SPACE] and not attacking:
        attacking = True
        attack_timer = 10  # Attack lasts for a short duration

    if attack_timer > 0:
        attack_timer -= 1
    else:
        attacking = False

    # Move enemies
    for enemy in enemies:
        move_enemy(enemy, player)

    move_boss(player)  # Move the boss

    # Collision Detection (Player & Enemy)
    for enemy in enemies[:]:  # Copy list to avoid modifying while iterating
        if player.colliderect(enemy):
            player_health -= 1
            enemies.remove(enemy)  # Enemy disappears after hit

    # Collision Detection (Player & Boss)
    if player.colliderect(boss):
        player_health -= 2  # Boss deals more damage

    # Attack Logic
    if attacking:
        attack_range = pygame.Rect(player.x - 10, player.y - 10, 70, 70)
        for enemy in enemies[:]:  # Check enemies within attack range
            if attack_range.colliderect(enemy):
                enemies.remove(enemy)  # Remove hit enemy

        if attack_range.colliderect(boss):
            boss_health -= 1  # Reduce boss health

    # Draw player
    screen.blit(player_img, (player.x, player.y))

    # Draw enemies
    for enemy in enemies:
        screen.blit(enemy_img, (enemy.x, enemy.y))

    # Draw boss
    screen.blit(boss_img, (boss.x, boss.y))

    # Draw health bars
    pygame.draw.rect(screen, RED, (10, 10, 100, 10))
    pygame.draw.rect(screen, GREEN, (10, 10, player_health * 20, 10))

    pygame.draw.rect(screen, RED, (650, 10, 100, 10))
    pygame.draw.rect(screen, GREEN, (650, 10, boss_health * 10, 10))

    # Check for game over
    if player_health <= 0:
        print("You Died! Game Over!")
        running = False

    if boss_health <= 0:
        print("You Defeated the Boss! You Win!")
        running = False

    pygame.display.flip()
    clock.tick(60)

pygame.quit()
