import time

def IndivType(message):
    message = " " + message
    delay = 0.04 # seconds
    for char in message:
        print(char, end='', flush=True)  # Print each character without a newline
        time.sleep(delay)  # Wait for the specified delay before printing the next character
    print()