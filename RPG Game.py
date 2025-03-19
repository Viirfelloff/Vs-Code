from time import sleep


def pregame():
    print("Welcome To RPG Game! Follow the Instructions below.")
    name = input("To start, what is your name?")
    print("Welcome," + name + "!")
    game()
def game():
    print("The game has now started!")
    sleep(1);
    print("Now for some backstory")


pregame()

