from idlelib.query import Query
import random
import IndivTypeTest
from time import sleep
def pregame():
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
    def initAssassin():
        chance = random.randint(0, 20)
        class assassin:
            def __init__(self, hlth, atk, defen, magic, crit):
                self.hlth = hlth
                self.atk = atk
                self.defen = defen
                self.magic = magic
                self.crit = crit
                def attack():
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
                def defense():
                    assDamageTaken = 0;
                    if (assDamageTaken > 0):
                        assDamageTaken += -self.defen
                        self.hlth += -assDamageTaken
                    if (self.hlth == 0):
                        print("You are Dead.....")
    def initMage():
        class mage:
            chance2 = random.randint(0,20)
            def __init__(self, hlth, atk, defen, magic, crit):
                self.hlth = hlth
                self.atk = atk
                self.defen = defen
                self.magic = magic
                self.crit = crit
                def attack():
                    self.crit = mage.chance2
                    magDamageDealt = 0
                    magDamageDealt += self.atk
                    if (self.crit == 3):
                        magDamageDealt += 5
                    else:
                        magDamageDealt += 0
                    input = input("Use Magic? Type Y or N. ")
                    if input == "Y":
                        self.magic = magic * hlth
                        magDamageDealt += self.magic
                    else:
                        self.magic = magic
                def defense():
                    magDamageTaken = 0;
                    if (magDamageTaken > 0):
                        magDamageTaken += -self.defen
                        self.hlth += -magDamageTaken
                    if (self.hlth == 0):
                        print("You are Dead.....")
    def initSentinel():
        class sentinel:
            chance3 = random.randint(0,20)
            def __init__(self, hlth, atk, defen, magic, crit):
                self.hlth = hlth
                self.atk = atk
                self.defen = defen
                self.magic = magic
                self.crit = crit
                def attack():
                    self.crit = sentinel.chance2
                    sentDamageDealt = 0
                    sentDamageDealt += self.atk
                    if (self.crit == 3):
                        sentDamageDealt += 5
                    else:
                        sentDamageDealt += 0
                    input = input("Use Magic? Type Y or N. ")
                    if input == "Y":
                        self.magic = magic * hlth
                        sentDamageDealt += self.magic
                    else:
                        self.magic = magic
                def defense():
                    sentDamageTaken = 0;
                    if (sentDamageTaken > 0):
                        sentDamageTaken += -self.defen
                        self.hlth += -sentDamageTaken
                    if (self.hlth == 0):
                        IndivTypeTest.IndivType("You are Dead.....")
    if input3 == "1":
        initAssassin()
        IndivTypeTest.IndivType("Nice, you chose the assassin!")









pregame()

