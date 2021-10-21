#CMSC-135 Assignment 8 - Date Printer
#   This assignment reads a string from the user containing a date in the form of mm/dd/yyyy.
#   Then, the program prints the date in the format month day, year.
#Programmer: Joseph Smith
#Date: 5/6/2021

#Variables
inputDate = ""
printDate = ""

#Months list
months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]

#Main function
def main():
    #Asks for user input in correct format
    inputDate = input("Enter a date in the format mm/dd/yyyy: ")

    #Converts date
    printDate = convertDate(inputDate)

    #Print new date
    print(printDate)


#Convert date function
def convertDate(date):
    #Gather information. Month is set to integer for indexing month strings.
    month = int(date[0:2])-1
    day = date[3:5]
    year = date[6:10]

    #Set return string. Add month as index to months string list
    returnDate = months[month]+" "+day+", "+year

    #Return string
    return returnDate


#Call main function and add exit button
main()
input("press enter")

