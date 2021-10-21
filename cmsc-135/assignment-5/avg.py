#CMSC 135 Programming Assignment 5_1
#Programmer: Joseph Smith

import sys

#Declare variables
sum = 0
num = 0
avg = 0

#Open numbers file and set to object 'f'
f = open(sys.path[0]+"/numbers.txt")

#Loop through each line in file
for i in f:
    #Add to sum and increment number of lines in file
    sum += int(i)
    num += 1
        
#Calculate average
avg = sum / num

#Print average
print("Average:",avg)

#End program with user input
input("press enter")