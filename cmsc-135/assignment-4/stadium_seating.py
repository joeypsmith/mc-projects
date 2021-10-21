#CMSC-135 Assignment 4: Stadium Seating
#Programmer: Joseph Smith
#Date: 3/2/2021

#Cost of each seat
A_COST = 20
B_COST = 15
C_COST = 10

#Number of each seat
aSeats = int(input("Enter count of A seats: "))
bSeats = int(input("Enter count of B seats: "))
cSeats = int(input("Enter count of C seats: "))

#Calculate income
aIncome = float(aSeats * A_COST)
bIncome = float(bSeats * B_COST)
cIncome = float(cSeats * C_COST)

def ShowIncome(a, b, c):
    #Print income
    print("Income from class A seats: $" + format(a, '.2f'))
    print("Income from class B seats: $" + format(b, '.2f'))
    print("Income from class C seats: $" + format(c, '.2f'))

    #Calculate and print total income
    totalIncome = aIncome + bIncome + cIncome
    print("Total income: $" + format(totalIncome, '.2f'))

ShowIncome(aIncome, bIncome, cIncome)
input("Press enter")



