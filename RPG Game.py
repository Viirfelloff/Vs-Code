from contextlib import nullcontext
from dataclasses import InitVar
from idlelib.query import Query
#TODO: ADD SPEED FEATURE
import random
import IndivTypeTest
from time import sleep
def pregame():
    IndivTypeTest.IndivType("Notice - for any inputs, DO NOT USE SPACES!")
    IndivTypeTest.IndivType("Welcome To RPG Game! Follow the Instructions below.")
    name = input(" To start, what is your name?")
    IndivTypeTest.IndivType("Welcome," + name + "!")
    game()
def game():
    IndivTypeTest.IndivType("The game has now started!")
    sleep(1)
    IndivTypeTest.IndivType("Now for some backstory: you are stranded on an island, with nowhere to go.\n" + "Now, you must choose: do you want to be\n" +
                            "a mage, sentinel, or assassin? Assassins are quick and deal damage, sentinels\n" + "have lots of defense, and mages have good magic and crit chances.")
    input3 = input("Choose 1, 2, or 3 for mage, sentinel, or assassin.")
    chance = random.randint(0, 20)
    class assassin:
        def __init__(self, hlth, atk, defen, magic, crit):
            self.hlth = hlth
            self.atk = atk
            self.defen = defen
            self.magic = magic
            self.crit = crit
            def attack(self):
                self.crit = chance
                assDamageDealt = 0
                assDamageDealt += self.atk
                if (self.crit == 3):
                    assDamageDealt += 5
                else:
                    assDamageDealt += 0
                input = input("Use Magic? Type Y or N. ")
                if input == "Y":
                    self.magic = magic * hlth
                    assDamageDealt += self.magic
                else:
                    self.magic = magic
            def defense(self):
                assDamageTaken = 0;
                if (assDamageTaken > 0):
                    assDamageTaken += -self.defen
                    self.hlth += -assDamageTaken
                if (self.hlth <= 0):
                    IndivTypeTest.IndivType("You are Dead.....")
                    pregame()
    class mage:
        chance2 = random.randint(0,20)
        def __init__(self, hlth, atk, defen, magic, crit):
            self.hlth = hlth
            self.atk = atk
            self.defen = defen
            self.magic = magic
            self.crit = crit
            def attack(self):
                self.crit = mage.chance2
                magicLeft = 5
                DamageDealt = 0
                DamageDealt += self.atk
                if (self.crit == 3):
                    DamageDealt += 5
                else:
                    DamageDealt += 0
                    input = input("Use Magic? Type Y or N. ")
                if input == "Y":
                    self.magic = magic * hlth
                    DamageDealt += self.magic
                    magicLeft += -1
                elif (magicLeft == 0):
                    IndivTypeTest.IndivType("No magic left!")
                else:
                    IndivTypeTest.IndivType("You choose not to use magic.")
            def defense(self):
                DamageTaken = 0;
                if (DamageTaken > 0):
                    DamageTaken += -self.defen
                    self.hlth += -DamageTaken
                if (self.hlth == 0):
                    IndivTypeTest.IndivType("You are Dead.....")
                    pregame()
    class sentinel:
        chance3 = random.randint(0,20)
        def __init__(self, hlth, atk, defen, magic, crit):
            self.hlth = hlth
            self.atk = atk
            self.defen = defen
            self.magic = magic
            self.crit = crit
            def attack(self):
                self.crit = sentinel.chance2
                DamageDealt = 0
                DamageDealt += self.atk
                if (self.crit == 3):
                    DamageDealt += 5
                else:
                    DamageDealt += 0
                input = input("Use Magic? Type Y or N. ")
                if input == "Y":
                    self.magic = magic * hlth
                    DamageDealt += self.magic
                else:
                    self.magic = magic
            def defense(self):
                DamageTaken = 0;
                if (DamageTaken > 0):
                    DamageTaken += -self.defen
                    self.hlth += -DamageTaken
                if (self.hlth == 0):
                    IndivTypeTest.IndivType("You are Dead.....")
                    pregame()
    if input3 == "1":
        IndivTypeTest.IndivType("Nice, you chose the mage!")
        playerClass = "mage"
        player = mage(100, 8, 4, 0.06, 10)
    elif input3 == "2":
        IndivTypeTest.IndivType("Nice, you chose the sentinel!")
        playerClass = "sentinel"
        player = sentinel(100, 7, 7, 0.03, 8)
    elif input3 == "3":
        IndivTypeTest.IndivType("Nice, you chose the assassin!")
        playerClass = "assassin"
        player = assassin(100, 10, 5, 0.01, 7 )
    IndivTypeTest.IndivType("You walk forward, and see a forest. Beside the forest, you see an oasis. Where do you go?")
    input4 = input("Type 1 for the forest, and 2 for the Oasis.")
    if input4 == "1":
        IndivTypeTest.IndivType("You die from a tiger. Try again!")
        pregame()
    elif input4 == "2":
        IndivTypeTest.IndivType("You go to the Oasis. You see water. Do you drink it?")
    input5 = input("1 for Yes, 2 for No.")
    if input5 == "1":
        IndivTypeTest.IndivType("A mage jumps out of the bush! Do you fight or run?")
    elif input5 == "2":
        IndivTypeTest.IndivType("You choose not to. Now, you sit down and rest, but a mage jumps out of a bush nearby! Do you fight or run?")
    input6 = input("1 for fight, 2 for run. There is a chance you may not get away.")
    if input6 == "2":
        randomNum = random.randint(1,5)
        if randomNum == 2:
            IndivTypeTest.IndivType("You got away!")
        else:
            IndivTypeTest.IndivType("You couldn't escape...Now, you must fight!")
            IndivTypeTest.IndivType("You chose to fight! Remember, you are a " + playerClass + ".")
            IndivTypeTest.IndivType("You can choose to use magic 5 times, only. Your attributes are as follows: \n")
            IndivTypeTest.IndivType("Health: " + str(player.hlth) + ", " + "Attack: " + str(player.atk) + ", " + "Defense: " + str(player.defen) + ", " + "\n")
            IndivTypeTest.IndivType("Magic Multiplier: " + str(player.magic) + ", " + "Critical Hit DMG: " + str(player.crit))
    if input6 == "1":
        IndivTypeTest.IndivType("You couldn't escape...Now, you must fight!")
        IndivTypeTest.IndivType("You chose to fight! Remember, you are a " + playerClass + ".")
        IndivTypeTest.IndivType("You can choose to use magic 5 times, only. Your attributes are as follows: \n")
        IndivTypeTest.IndivType("Health: " + str(player.hlth) + ", " + "Attack: " + str(player.atk) + ", " + "Defense: " + str(player.defen) + ", " + "\n")
        IndivTypeTest.IndivType("Magic Multiplier: " + str(player.magic) + ", " + "Critical Hit DMG: " + str(player.crit))












pregame()

