def indivLetterType(String):
    String = list(String)
    ran = True
    Stringnum = len(String)
    number = 0
    for x in Stringnum:
        print(String[number])
        number += 1
        if number > Stringnum:
            break

indivLetterType("So basically this is a test to see if this works.")