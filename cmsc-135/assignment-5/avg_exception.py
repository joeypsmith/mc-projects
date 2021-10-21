#CMSC 135 Programming Assignment 5_2
#Programmer: Joseph Smith

import sys

#Declare variables
sum = 0
num = 0
avg = 0

#Try to open numbers file and set to object 'f'
try:
    f = open(sys.path[0]+"/numbers.txt")
    #Try to read each line if integer
    try:
        #Loop through each line in file
        for i in f:
            #Add to sum and increment number of lines in file
            sum += int(i)
            num += 1

        #Calculate average
        avg = sum / num

        #Print average
        print("Average:",avg)

    #If line is not integer, print error message
    except ValueError:
        print("Non-numeric data found in the file.")

#If file cannot be opened, print error mesage
except IOError:
    print("An error occured while trying to read the file.")

#End program with user input
input("press enter")