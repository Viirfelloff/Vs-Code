#TODO: ADD SPEED FEATURE
#TODO: add money feature
import random
import IndivTypeTest
from time import sleep
import keyboard
def pregame():
    IndivTypeTest.IndivType("Notice - for any inputs, DO NOT USE SPACES!")
    IndivTypeTest.IndivType("Welcome To RPG Game! Follow the Instructions below.")
    name = input(" To start, what is your name?")
    IndivTypeTest.IndivType("Welcome," + name + "!")
    game()
def game():
    sleep(1)
    IndivTypeTest.IndivType("Now for some backstory: you are stranded on an island, with nowhere to go.\n" + "Now, you must choose: do you want to be\n" +
                            "a mage, sentinel, assassin, or healer? Assassins are quick and deal damage, sentinels\n" + "have lots of defense, mages have good magic and crit chances, and healers have lots of health.")
    input3 = input(" Choose 1, 2, 3, or 4 for mage, sentinel, assassin, or healer.")
    localchance = random.randint(1,20)
    class character:
        def __init__(self, hlth, atk, defen, magic, crit, magicLeft, DamageDealt, DamageTaken, defenseUsed):
            self.hlth = hlth
            self.atk = atk
            self.defen = defen
            self.magic = magic
            self.crit = crit
            self.magicLeft = magicLeft
            self.DamageDealt = DamageDealt
            self.DamageTaken = DamageTaken
            self.defenseUsed = defenseUsed
        def attack(self):
            self.DamageDealt = 0
            self.DamageDealt += self.atk
            IndivTypeTest.IndivType("Damage Dealt so far: " + str(self.DamageDealt))
            if (localchance == 3):
                self.DamageDealt += self.crit
                IndivTypeTest.IndivType("Critical Hit! Added Damage: " + str(self.crit))
            else:
                self.DamageDealt += 0
            input13 = input("Use Magic? Type 1 or 2 for Yes or No.")
            if self.magicLeft > 0 and input13 == "1":
                self.DamageDealt += self.magic
                IndivTypeTest.IndivType(
                    "Magic Damage Added! Added Damage: " + str(self.magic) + ". " + "Uses remaining: " + str(
                        self.magicLeft))
                self.magicLeft += -1
            elif (self.magicLeft == 0):
                IndivTypeTest.IndivType("No magic left!")
            elif input13 == "2":
                IndivTypeTest.IndivType("You choose not to use magic.")
            return self.DamageDealt

        def defense(self):
            if (self.DamageTaken > 0):
                if (self.defenseUsed < 6):
                    self.DamageTaken += -self.defen
                    self.defenseUsed += 1
                    IndivTypeTest.IndivType("You used one defense! Number used: " + str(self.defenseUsed))
                else:
                    IndivTypeTest.IndivType("No defense left!")
                    self.DamageTaken = self.DamageTaken
                self.hlth += -self.DamageTaken
    class mage(character):
        pass
    class sentinel(character):
        pass
    class assassin(character):
        pass
    class healer(character):
        pass
    class enemy:
        def __init__(self, hlth, atk, defen, magic, crit, magicLeft, DamageDealt, DamageTaken, defenseUsed):
            self.hlth = hlth
            self.atk = atk
            self.defen = defen
            self.magic = magic
            self.crit = crit
            self.magicLeft = magicLeft
            self.DamageDealt = DamageDealt
            self.DamageTaken = DamageTaken
            self.defenseUsed = defenseUsed
        def attack(self):
            self.DamageDealt = 0
            self.DamageDealt += self.atk
            IndivTypeTest.IndivType("Damage Dealt so far: " + str(self.DamageDealt))
            if (localchance == 3):
                self.DamageDealt += self.crit
                IndivTypeTest.IndivType("Critical Hit! Added Damage: " + str(self.crit))
            else:
                self.DamageDealt += 0
            if self.magicLeft > 0:
                self.DamageDealt += self.magic
                IndivTypeTest.IndivType(
                    "Magic Damage Added! Added Damage: " + str(self.magic) + ". " + "Uses remaining: " + str(
                        self.magicLeft))
                self.magicLeft += -1
            elif self.magicLeft == 0:
                IndivTypeTest.IndivType("No magic left!")
            return self.DamageDealt
        def defense(self):
            if (self.DamageTaken > 0):
                if (self.defenseUsed < 6):
                    self.DamageTaken += -self.defen
                    self.defenseUsed += 1
                    IndivTypeTest.IndivType("Enemy used one defense! Number used: " + str(self.defenseUsed))
                else:
                    IndivTypeTest.IndivType("No enemy defense left!")
                    self.DamageTaken = self.DamageTaken
                self.hlth += -self.DamageTaken
    if input3 == "1":
        IndivTypeTest.IndivType("Nice, you chose the mage!")
        playerClass = "mage"
        player = mage(100, 8, 4, 4, 10, 5, 0, 0, 0)
    elif input3 == "2":
        IndivTypeTest.IndivType("Nice, you chose the sentinel!")
        playerClass = "sentinel"
        player = sentinel(100, 7, 7, 2, 8,5,0,0,0)
    elif input3 == "3":
        IndivTypeTest.IndivType("Nice, you chose the assassin!")
        playerClass = "assassin"
        player = assassin(100, 10, 4, 1, 7,5,0,0,0)
    elif input3 == "4":
        IndivTypeTest.IndivType("Nice, you chose the healer!")
        playerClass = "healer"
        player = healer(110, 6, 4, 4, 4,5,0,0,0)
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
    enemy1 = enemy(90, 8, 3, 3, 10, 5, 0,0, 0)
    enemyClass = "mage"
    IndivTypeTest.IndivType("You are now fighting a nerfed mage! \n Enemy Stats: Health: " + str(enemy1.hlth) + ", " + "Attack: " + str(enemy1.atk))
    IndivTypeTest.IndivType("Defense: " + str(enemy1.defen) + "\n" + ", " + "Magic: " + str(enemy1.magic) + ", " + "Crit: " + str(enemy1.crit) + ".")
    IndivTypeTest.IndivType("Remember - your defense is active for the first 5 attacks you take - it reduces incoming damage!")
    IndivTypeTest.IndivType("Commence Battle!")
    def battleLoop():
        battleActive = True
        if battleActive:
            while battleActive:
                input7 = input("Your turn! Press A to attack, and B to run (10% chance of escaping).")
                if input7 == "B":
                    randomNum2 = random.randint(1,10)
                    if randomNum2 == 7:
                        battleActive = False
                        IndivTypeTest.IndivType("You Escaped!")
                    else:
                        IndivTypeTest.IndivType("You died because you failed to escape....")
                        sleep(2)
                        pregame()
                elif input7 == "A":
                    playerDead = False
                    player.attack()
                    enemy1.DamageTaken = player.DamageDealt
                    enemy1.defense()
                    IndivTypeTest.IndivType("You Dealt " + str(enemy1.DamageTaken) + " damage!")
                    IndivTypeTest.IndivType("Enemy Health: " + str(enemy1.hlth) + ".")
                    if enemy1.hlth <= 0:
                        enemy1.hlth = 0
                        battleActive = False
                        break
                    IndivTypeTest.IndivType("Enemy's Turn! They attack!")
                    enemy1.attack()
                    player.DamageTaken = enemy1.DamageDealt
                    player.defense()
                    IndivTypeTest.IndivType("The enemy dealt " + str(player.DamageTaken) + " damage!")
                    IndivTypeTest.IndivType("Your Health: " + str(player.hlth) + ".")
                    if player.hlth <= 0:
                        player.hlth = 0
                        IndivTypeTest.IndivType("You died.....")
                        playerDead = True
                        battleActive = False
                        break
        if playerDead and battleActive == False:
            IndivTypeTest.IndivType("Unfortunately, you died.")
            sleep(3)
            pregame()
        if battleActive == False and playerDead == False:
            IndivTypeTest.IndivType("You defeated the " + str(enemyClass) + "!")
    battleLoop()
    IndivTypeTest.IndivType("You now receive an upgrade: do you want higher attack, defense, or full health?")
    input14 = input("Type 1 for the attack, 2 for the defense, or 3 for full health.")
    if input14 == "1":
        player.atk += 2
        IndivTypeTest.IndivType("Your new attack is now " + str(player.atk) + ".")
    elif input14 == "2":
        player.defen += 1
        IndivTypeTest.IndivType("Your new defense is now " + str(player.defen) + ".")
    elif input14 == "3":
        player.hlth = 100
        IndivTypeTest.IndivType("Your new health is now " + str(player.hlth) + ".")
    IndivTypeTest.IndivType("Would you like to see your current stats?")
    input15 = input("Type 1 for yes or 2 for no.")
    if input15 == "1":
        IndivTypeTest.IndivType("These are your stats:")
        IndivTypeTest.IndivType(
            "Health: " + str(player.hlth) + ", " + "Attack: " + str(player.atk) + ", " + "Defense: " + str(
                player.defen) + ", " + "\n")
        IndivTypeTest.IndivType(
            "Magic: " + str(player.magic) + ", " + "Critical Hit DMG: " + str(player.crit))
    else:
        IndivTypeTest.IndivType("You chose not to see your stats.")
    IndivTypeTest.IndivType("Let's continue!")
    IndivTypeTest.IndivType("Note: now, if you want to change your character, press 'y'.")
    input100 = input("Press 'y' to change characters.")
    changeUsed = False
    if input100 == "y" and changeUsed == False:
        changeUsed = True
    else:
        IndivTypeTest.IndivType("You chose to remain a " + playerClass + ".")
    if changeUsed == True:
        input20 = input("What character would you like to switch to? 1 = mage, 2 = sentinel, 3 = assassin, 4 = healer. This will reset upgrades.")
        if input20 == "1":
            IndivTypeTest.IndivType("Nice, you chose the mage!")
            playerClass = "mage"
            player = mage(100, 8, 4, 4, 10, 5, 0, 0,0)
        elif input20 == "2":
            IndivTypeTest.IndivType("Nice, you chose the sentinel!")
            playerClass = "sentinel"
            player = sentinel(100, 7, 7, 2, 8, 5, 0, 0,0)
        elif input20 == "3":
            IndivTypeTest.IndivType("Nice, you chose the assassin!")
            playerClass = "assassin"
            player = assassin(100, 10, 4, 1, 7, 5, 0, 0,0)
        elif input20 == "4":
            IndivTypeTest.IndivType("Nice, you chose the healer!")
            playerClass = "healer"
            player = healer(110, 6, 4, 4, 4, 5, 0, 0,0)
        IndivTypeTest.IndivType("You have now used your one character change.")
        IndivTypeTest.IndivType("Your new stats:")
        IndivTypeTest.IndivType(
            "Health: " + str(player.hlth) + ", " + "Attack: " + str(player.atk) + ", " + "Defense: " + str(
                player.defen) + ", " + "\n")
        IndivTypeTest.IndivType(
            "Magic Multiplier: " + str(player.magic) + ", " + "Critical Hit DMG: " + str(player.crit))
    IndivTypeTest.IndivType("You're really tired now. You continue on from the Oasis.")
    IndivTypeTest.IndivType("Do you rest, or keep going?")
    input23 = input("1 for Yes, 2 for No.")
    if input23 == "1":
        IndivTypeTest.IndivType("Smart Choice! You gain 10 health!")
        player.hlth += 10
        IndivTypeTest.IndivType("New health: " + str(player.hlth) + ".")
    elif input23 == "2":
        IndivTypeTest.IndivType("You go on, but get too tired....You lose 5 health.")
        player.hlth -= 5
        IndivTypeTest.IndivType("New health " + str(player.hlth) + ".")
    sleep(1)
    IndivTypeTest.IndivType("Before long, you find a village! Do you enter?")
    input2334 = input("1 for Yes, 2 for No.")
    def villageMenu():
        shopVisited = False
        witchVisited = False
        hosVisited = False
        IndivTypeTest.IndivType("You enter the village! It is lively, the streets bustling, the sun shining, and the children playing.")
        input2343 = input("Press 1 for the Shop, 2 for the Hospital, and 3 for the Witch's House.")
        if input2343 == "1":
            shopVisited = True
            IndivTypeTest.IndivType("You walk toward the open shop. It looks like they are selling defense boosts, attack boosts, or magic use replenishes.")
            input21canudosumfurmeeee = input("You can buy one thing - 1 for defense, 2 for attack, 3 for magic.")
            if input21canudosumfurmeeee == "1":
                player.defen += 2
                IndivTypeTest.IndivType("You bought the defense! Added defense: 2! New defense: " + str(player.defen))
            elif input21canudosumfurmeeee == "2":
                player.hlth += 5
                IndivTypeTest.IndivType("You bought the attack! Added attack: 2! New attack: " + str(player.atk))
            elif input21canudosumfurmeeee == "3":
                player.magicLeft = 5
                IndivTypeTest.IndivType("You replenished your magic! You now have 5 uses left.")
            IndivTypeTest.IndivType("You exit the shop.")
            input69 = input("Press 2 for the Hospital, and 3 for the Witch's House.")
            if input69 == "2":
                hosVisited = True
                IndivTypeTest.IndivType("You enter the hospital. Patients are lying down, and doctors tend to them.")
                IndivTypeTest.IndivType("They approach you, and ask if you want to be treated!")
                input69420 = input("Do you want to accept? 1 for yes, 2 for no.")
                if input69420 == "1":
                    IndivTypeTest.IndivType("They inject you with a lethal poision. Game over!")
                elif input69420 == "2":
                    IndivTypeTest.IndivType("You refuse their care and leave.")
                witchVisited = True
                IndivTypeTest.IndivType("Now, you go to the witch.")
                IndivTypeTest.IndivType("You walk into a witch's cove, and she offers you a potion...do you drink it?")
                inp69 = input("1 for Yes, 2 for No.")
                if inp69 == "1":
                    player.magic += 2
                    IndivTypeTest.IndivType("You get 2 more magic power! Your new magic: " + str(player.magic))
                elif inp69 == "2":
                    IndivTypeTest.IndivType("You choose not to drink it.")
            elif input69 == "3":
                witchVisited = True
                IndivTypeTest.IndivType("You walk into a witch's cove, and she offers you a potion...do you drink it?")
                inp69 = input("1 for Yes, 2 for No.")
                if inp69 == "1":
                    player.magic += 2
                    IndivTypeTest.IndivType("You get 2 more magic power! Your new magic: " + str(player.magic))
                elif inp69 == "2":
                    IndivTypeTest.IndivType("You choose not to drink it.")
                hosVisited = True
                IndivTypeTest.IndivType("Now, you go to the hospital.")
                IndivTypeTest.IndivType("You enter the hospital. Patients are lying down, and doctors tend to them.")
                IndivTypeTest.IndivType("They approach you, and ask if you want to be treated!")
                input69420 = input("Do you want to accept? 1 for yes, 2 for no.")
                if input69420 == "1":
                    IndivTypeTest.IndivType("They inject you with a lethal poision. Game over!")
                elif input69420 == "2":
                    IndivTypeTest.IndivType("You refuse their care and leave.")
        elif input2343 == "2":
            hosVisited = True
            IndivTypeTest.IndivType("You enter the hospital. Patients are lying down, and doctors tend to them.")
            IndivTypeTest.IndivType("They approach you, and ask if you want to be treated!")
            input69420 = input("Do you want to accept? 1 for yes, 2 for no.")
            if input69420 == "1":
                IndivTypeTest.IndivType("They inject you with a lethal poision. Game over!")
            elif input69420 == "2":
                IndivTypeTest.IndivType("You refuse their care and leave.")
            input693 = input("Press 1 for the Shop, and 3 for the Witch's House.")
            if input693 == "1":
                shopVisited = True
                IndivTypeTest.IndivType(
                    "You walk toward the open shop. It looks like they are selling defense boosts, attack boosts, or magic use replenishes.")
                input213 = input("You can buy one thing - 1 for defense, 2 for attack, 3 for magic.")
                if input213 == "1":
                    player.defen += 2
                    IndivTypeTest.IndivType(
                        "You bought the defense! Added defense: 2! New defense: " + str(player.defen))
                elif input213 == "2":
                    player.hlth += 5
                    IndivTypeTest.IndivType("You bought the attack! Added attack: 2! New attack: " + str(player.atk))
                elif input213 == "3":
                    player.magicLeft = 5
                    IndivTypeTest.IndivType("You replenished your magic! You now have 5 uses left.")
                IndivTypeTest.IndivType("You exit the shop.")
                witchVisited = True
                IndivTypeTest.IndivType("Now, you go to the witch.")
                IndivTypeTest.IndivType("You walk into a witch's cove, and she offers you a potion...do you drink it?")
                inp69 = input("1 for Yes, 2 for No.")
                if inp69 == "1":
                    player.magic += 2
                    IndivTypeTest.IndivType("You get 2 more magic power! Your new magic: " + str(player.magic))
                elif inp69 == "2":
                    IndivTypeTest.IndivType("You choose not to drink it.")
            elif input693 == "3":
                witchVisited = True
                IndivTypeTest.IndivType("You walk into a witch's cove, and she offers you a potion...do you drink it?")
                inp69 = input("1 for Yes, 2 for No.")
                if inp69 == "1":
                    player.magic += 2
                    IndivTypeTest.IndivType("You get 2 more magic power! Your new magic: " + str(player.magic))
                elif inp69 == "2":
                    IndivTypeTest.IndivType("You choose not to drink it.")
                shopVisited = True
                IndivTypeTest.IndivType("You go to the shop.")
                IndivTypeTest.IndivType(
                    "You walk toward the open shop. It looks like they are selling defense boosts, attack boosts, or magic use replenishes.")
                input21canudosumfurmeeee = input(
                    "You can buy one thing - 1 for defense, 2 for attack, 3 for magic.")
                if input21canudosumfurmeeee == "1":
                    player.defen += 2
                    IndivTypeTest.IndivType(
                        "You bought the defense! Added defense: 2! New defense: " + str(player.defen))
                elif input21canudosumfurmeeee == "2":
                    player.hlth += 5
                    IndivTypeTest.IndivType(
                        "You bought the attack! Added attack: 2! New attack: " + str(player.atk))
                elif input21canudosumfurmeeee == "3":
                    player.magicLeft = 5
                    IndivTypeTest.IndivType("You replenished your magic! You now have 5 uses left.")
                IndivTypeTest.IndivType("You exit the shop.")
        elif input2343 == "3":
            witchVisited = True
            IndivTypeTest.IndivType("You walk into a witch's cove, and she offers you a potion...do you drink it?")
            inp695 = input("1 for Yes, 2 for No.")
            if inp695 == "1":
                player.magic += 2
                IndivTypeTest.IndivType("You get 2 more magic power! Your new magic: " + str(player.magic))
            elif inp695 == "2":
                IndivTypeTest.IndivType("You choose not to drink it.")
            input697 = input("Press 1 for the Shop, and 2 for the Hospital.")
            if input697 == "1":
                shopVisited = True
                IndivTypeTest.IndivType(
                    "You walk toward the open shop. It looks like they are selling defense boosts, attack boosts, or magic use replenishes.")
                input213 = input("You can buy one thing - 1 for defense, 2 for attack, 3 for magic.")
                if input213 == "1":
                    player.defen += 2
                    IndivTypeTest.IndivType(
                        "You bought the defense! Added defense: 2! New defense: " + str(player.defen))
                elif input213 == "2":
                    player.hlth += 5
                    IndivTypeTest.IndivType("You bought the attack! Added attack: 2! New attack: " + str(player.atk))
                elif input213 == "3":
                    player.magicLeft = 5
                    IndivTypeTest.IndivType("You replenished your magic! You now have 5 uses left.")
                IndivTypeTest.IndivType("You exit the shop.")
                hosVisited = True
                IndivTypeTest.IndivType("Now, you go to the hospital.")
                IndivTypeTest.IndivType("You enter the hospital. Patients are lying down, and doctors tend to them.")
                IndivTypeTest.IndivType("They approach you, and ask if you want to be treated!")
                input69420 = input("Do you want to accept? 1 for yes, 2 for no.")
                if input69420 == "1":
                    IndivTypeTest.IndivType("They inject you with a lethal poision. Game over!")
                elif input69420 == "2":
                    IndivTypeTest.IndivType("You refuse their care and leave.")
            elif input697 == "2":
                hosVisited = True
                IndivTypeTest.IndivType("You enter the hospital. Patients are lying down, and doctors tend to them.")
                IndivTypeTest.IndivType("They approach you, and ask if you want to be treated!")
                input69420 = input("Do you want to accept? 1 for yes, 2 for no.")
                if input69420 == "1":
                    IndivTypeTest.IndivType("They inject you with a lethal poision. Game over!")
                elif input69420 == "2":
                    IndivTypeTest.IndivType("You refuse their care and leave.")
                IndivTypeTest.IndivType("Now, you go to the shop.")
                shopVisited = True
                IndivTypeTest.IndivType(
                    "You walk toward the open shop. It looks like they are selling defense boosts, attack boosts, or magic use replenishes.")
                input213 = input("You can buy one thing - 1 for defense, 2 for attack, 3 for magic.")
                if input213 == "1":
                    player.defen += 2
                    IndivTypeTest.IndivType(
                        "You bought the defense! Added defense: 2! New defense: " + str(player.defen))
                elif input213 == "2":
                    player.hlth += 5
                    IndivTypeTest.IndivType("You bought the attack! Added attack: 2! New attack: " + str(player.atk))
                elif input213 == "3":
                    player.magicLeft = 5
                    IndivTypeTest.IndivType("You replenished your magic! You now have 5 uses left.")
                IndivTypeTest.IndivType("You exit the shop.")
    if input2334 == "1":
        villageMenu()
        IndivTypeTest.IndivType("You leave the village.")
    elif input2334 == "2":
        IndivTypeTest.IndivType("You choose to leave the village - there were treasures and upgrades inside!")
    IndivTypeTest.IndivType("Now, you keep walking, and see a cave.")
    IndivTypeTest.IndivType("The cave is dark, with not much light, and you can hear faint sounds coming from inside...")
    sleep(3)
    input324 = input("Do you enter? 1 for Yes, 2 for No.")
    if input324 == "1":
        IndivTypeTest.IndivType("You walk in, unsure of your fate...")
    elif input324 == "2":
        IndivTypeTest.IndivType("Stop being a pussy. You go in, unsure of your fate...")
pregame()
