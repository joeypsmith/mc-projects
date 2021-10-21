#Magic Dates Assignment

#Input variables
month = int(input("Enter the month in numeric form: "))
day = int(input("Enter the day of the month: "))
year = int(input("Enter the year in two digit format: "))

#Print full date
fullDate = "The date is " + str(month) + "/" + str(day) + "/" + str(year)
print(fullDate)

#Check if date is magic date
if((month * day) == year):
    print("This is a magic date.")
else:
    print("This is not a magic date.")

#End program with enter press
input("Press enter")
exit()

