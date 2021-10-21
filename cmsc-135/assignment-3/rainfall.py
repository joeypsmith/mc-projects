#Joseph Smith
#Assignment 3 - RAINFALL - CMSC 135

#Variables, years, months, rainfall, avg rainfall
years = int(input("Enter number of years:"))
months = years * 12
rainfall = 0
avg = 0

#Loop through each year
for i in range(1, years+1):
    print("For year",i,":")
    #Loop through each month
    for k in range(0, 12):
        rainfall += float(input("Enter the rainfall amount for the month:"))

#Calculate average rainfall monthly
avg = rainfall / months

#Print # of months, total rainfall, average rainfall monthly
print("For",months,"months")
print("Total rainfall:","{:.2f}".format(rainfall))
print("Average monthly rainfall:","{:.2f}".format(avg),"inches")
input()
    
