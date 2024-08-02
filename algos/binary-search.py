#!/usr/bin/env python3

def binary_search(list, item):
    low = 0
    high = len(list) - 1

    while low <= high:
        mid = (low + high) // 2 # Get the middle of the array using the floor divisor.
        guess = list[mid] # Guess if the middle of the array is the correct option.
        if guess == item:
            return mid # If the middle is the correct option, return its index.
        if guess > item:
            high = mid - 1 # If the middle is greater than the guess, then we will set the high value to the middle index minus one.
        else:
            low = mid + 1 # If the middle is lower than the guess, we will set our lower bound to the low index plus one.

    return None 

def main():
    items = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150]
    result = binary_search(items, 60) # Should return 5 because 60 is the 5th index in the array.
    print(result)

main()