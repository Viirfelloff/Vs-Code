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
    IndivTypeTest.IndivType("Now for some backstory:")
    print()
    def initChars():
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
                def defense():
                    assDamageTaken = 0;
                    if (assDamageTaken > 0):
                        assDamageTaken += -self.defen
                        self.hlth += -assDamageTaken
                    if (self.hlth == 0):
                        print("You are Dead.....")

        class mage:
            def __init__(self, hlth, atk, defen, magic, crit):
                self.hlth = hlth
                self.atk = atk
                self.defen = defen
                self.magic = magic
                self.crit = crit







pregame()

