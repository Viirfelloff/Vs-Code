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
                            "a mage, sentinel, assassin, or healer? Assassins are quick and deal damage, sentinels\n" + "have lots of defense, mages have good magic and crit chances, and healers have lots of health.")
    input3 = input(" Choose 1, 2, 3, or 4 for mage, sentinel, assassin, or healer.")
    class assassin:
        def __init__(self, hlth, atk, defen, magic, crit):
            chance = random.randint(0, 20)
            self.hlth = hlth
            self.atk = atk
            self.defen = defen
            self.magic = magic
            self.crit = crit
            def attack(self):
                self.crit = assassin.chance
                DamageDealt = 0
                magicLeft = 5
                DamageDealt += self.atk
                IndivTypeTest.IndivType("Damage Dealt: " + str(DamageDealt))
                if (self.crit == 3):
                    DamageDealt += self.crit
                    IndivTypeTest.IndivType("Critical Hit! Added Damage: " + str(self.crit))
                else:
                    DamageDealt += 0
                input10 = input("Use Magic? Type Y or N. ")
                if input == "Y":
                    self.magic = magic * hlth
                    DamageDealt += self.magic
                    IndivTypeTest.IndivType(
                        "Magic Damage Added! Added Damage: " + str(self.magic) + ". " + "Uses remaining: " + str(
                            magicLeft))
                elif (magicLeft == 0):
                    IndivTypeTest.IndivType("No magic left!")
                else:
                    IndivTypeTest.IndivType("You choose not to use magic.")
                return DamageDealt
            def defense(self):
                DamageTaken = 0;
                if (DamageTaken > 0):
                    DamageTaken += -self.defen
                    self.hlth += -DamageTaken
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
            IndivTypeTest.IndivType("Damage Dealt: " + str(DamageDealt))
            if (self.crit == 3):
                DamageDealt += self.crit
                IndivTypeTest.IndivType("Critical Hit! Added Damage: " + str(self.crit))
            else:
                DamageDealt += 0
            input10 = input("Use Magic? Type Y or N. ")
            if input == "Y":
                self.magic = self.magic * self.hlth
                DamageDealt += self.magic
                IndivTypeTest.IndivType("Magic Damage Added! Added Damage: " + str(self.magic) + ". " + "Uses remaining: " + str(magicLeft))
                magicLeft += -1
            elif (magicLeft == 0):
                IndivTypeTest.IndivType("No magic left!")
            else:
                IndivTypeTest.IndivType("You choose not to use magic.")
            return DamageDealt
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
                self.crit = sentinel.chance3
                DamageDealt = 0
                magicLeft = 5
                DamageDealt += self.atk
                IndivTypeTest.IndivType("Damage Dealt: " + str(DamageDealt))
                if (self.crit == 3):
                    DamageDealt += 5
                    IndivTypeTest.IndivType("Critical Hit! Added Damage: " + str(self.crit))
                else:
                    DamageDealt += 0
                input = input("Use Magic? Type Y or N. ")
                if input == "Y":
                    self.magic = magic * hlth
                    DamageDealt += self.magic
                    IndivTypeTest.IndivType(
                        "Magic Damage Added! Added Damage: " + str(self.magic) + ". " + "Uses remaining: " + str(
                            magicLeft))
                elif (magicLeft == 0):
                    IndivTypeTest.IndivType("No magic left!")
                else:
                    IndivTypeTest.IndivType("You choose not to use magic.")
                return DamageDealt
            def defense(self):
                DamageTaken = 0;
                if (DamageTaken > 0):
                    DamageTaken += -self.defen
                    self.hlth += -DamageTaken
                if (self.hlth == 0):
                    IndivTypeTest.IndivType("You are Dead.....")
                    pregame()
    class healer:
        chance4 = random.randint(0,20)
        def __init__(self, hlth, atk, defen, magic, crit):
            self.hlth = hlth
            self.atk = atk
            self.defen = defen
            self.magic = magic
            self.crit = crit
            def attack(self):
                self.crit = healer.chance4
                DamageDealt = 0
                magicLeft = 5
                DamageDealt += self.atk
                IndivTypeTest.IndivType("Damage Dealt: " + str(DamageDealt))
                if (self.crit == 3):
                    DamageDealt += 5
                    IndivTypeTest.IndivType("Critical Hit! Added Damage: " + str(self.crit))
                else:
                    DamageDealt += 0
                input = input("Use Magic? Type Y or N. ")
                if input == "Y":
                    self.magic = magic * hlth
                    DamageDealt += self.magic
                    IndivTypeTest.IndivType(
                        "Magic Damage Added! Added Damage: " + str(self.magic) + ". " + "Uses remaining: " + str(
                            magicLeft))
                elif (magicLeft == 0):
                    IndivTypeTest.IndivType("No magic left!")
                else:
                    IndivTypeTest.IndivType("You choose not to use magic.")
                return DamageDealt
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
    elif input3 == "4":
        IndivTypeTest.IndivType("Nice, you chose the healer!")
        playerClass = "healer"
        player = healer(120, 4, 7, 0.03, 4)
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
    enemy1 = mage(90, 5, 4, 0.04, 10)
    IndivTypeTest.IndivType("You are now fighting a nerfed mage! \n Enemy Stats: Health: " + str(enemy1.hlth) + ", " + "Attack: " + str(enemy1.atk))
    IndivTypeTest.IndivType("Defense: " + str(enemy1.defen) + "\n" + ", " + "Magic: " + str(enemy1.magic) + ", " + "Crit: " + str(enemy1.crit) + ".")
    IndivTypeTest.IndivType("Commence Battle!")
    battleActive = True
    while battleActive:
        input7 = input("Your turn! Press A to attack, and B to run (10% chance of escaping).")
        if input7 == "B":
            randomNum2 = random.randint(1,10)
            if randomNum2 == 7:
                battleActive = False
        elif input7 == "A":
            player.attack()
            enemy1.hlth += -player.DamageDealt













pregame()

