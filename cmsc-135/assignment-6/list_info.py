# CMSC 135 Assignment 6 - Design a program that asks the user to enter a series of 20 numbers.
#             The program should store the numbers in a list then display the following data:
#               * The lowest number in the list
#               * The highest number in the list
#               * The total of the numbers in the list
#               * The average of the numbers in the list
# Programmer : Joseph Smith
# Date : 4/11/2021

#Constant Variables
MAX_NUMBERS = 20

#Numbers List
numbers = []

#Loop through asking for user input for 20 numbers
def inputNums():
    for i in range(0, MAX_NUMBERS):
        num = float(input("Enter number "+str(i+1)+" of "+str(MAX_NUMBERS)+": "))
        #Add number to list
        numbers.append(num)

#Sorts numbers list from smallest to largest, and returns first number index
def lowestNum():
    numbers.sort()
    return float(numbers[0])

#Sorts number list from smallest to largest, and returns last number index
def highestNum():
    numbers.sort()
    return float(numbers[-1])

#Returns the sum of numbers in list
def totalNum():
    return sum(numbers)

#Returns sum divided by total numbers in list
def avgNum():
    return totalNum() / len(numbers)

#Main function, reads out all calculations
def main():
    inputNums()
    print("Low:",round(lowestNum(),2))
    print("High:",round(highestNum(),2))
    print("Total:",round(totalNum(),2))
    print("Average:",round(avgNum(),2))
    input("press enter")

#Call main function
main()