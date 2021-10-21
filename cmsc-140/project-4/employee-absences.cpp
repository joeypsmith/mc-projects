#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;

//OFSTREAM FILE
ofstream outFile;

//PROTOTYPE FUNCTIONS
double AverageAbsent(int, int);
int NumOfEmployees();
int TotDaysAbsent(int);

//CONSTANTS
const string PROGRAMMER_NAME = "Joseph Smith";
const string DUE_DATE = "11/22/2020";
const int ASSIGNMENT_NUMBER = 4;

int main() {
	//Initizalize total employees and total days missed
	int totalEmployees, totalDays;
	double avgDays;
	//Output information header
	cout << "Calculate the average number of days a company's employees are absent." << endl;
	//Gather total number of employees from NumOfEmployees function
	totalEmployees = NumOfEmployees();
	//Open employeeAbsences file for writing
	outFile.open("employeeAbsences.txt");
	//Gather total number of days from TotDaysAbsent function
	totalDays = TotDaysAbsent(totalEmployees);
	//Gather average days absent from AverageAbsent function
	avgDays = AverageAbsent(totalEmployees, totalDays);
	//Write total employees, days, and average number of days absent onto file
	outFile << "\n\nThe " << totalEmployees << " employees were absent a total of " << totalDays << " days.";
	outFile << "\nThe average number of days absent is " << avgDays << " days.";
	outFile << "\n\nProgrammer: " << PROGRAMMER_NAME;
	outFile << "\nAssignment Number: " << ASSIGNMENT_NUMBER;
	outFile << "\nDue Date: " << DUE_DATE;
	//Close file
	outFile.close();
}

double AverageAbsent(int numOfEmployees, int totDaysAbsent) {
	double avgDays = 0;
	//Divide total days by number of employees to find average days absent
	avgDays = static_cast<double>(totDaysAbsent) / static_cast<double>(numOfEmployees);
	//Return average days
	return avgDays;
}

int NumOfEmployees() {
	//Initialize temporary variable containing number of employees
	int numOfEmployees = 0;
	//Loop asking for number of employees until requirements met
	while (numOfEmployees < 1) {
		cout << "\nPlease enter the number of employees in the company: ";
		cin >> numOfEmployees;
		if (numOfEmployees < 1) {
			cout << "Invalid number of employees !! Must be 1 or more.";
		}
	}
	//Return number of employees
	return numOfEmployees;
}

int TotDaysAbsent(int numOfEmployees) {
	int employeeID;
	int numOfDaysMissed;
	int totalDaysAbsent = 0;
	// Write header onto file
	outFile << "employee id\tdays absent";
	outFile << "\n===========\t===========";
	//Loop employeeID and days missed input for how many employees entered
	for (int e = 0; e < numOfEmployees; e++) {
		//Ask for employee information
		cout << "Please enter employee ID: ";
		cin >> employeeID;
		cout << "Please enter the number of days this employee was absent: ";
		cin >> numOfDaysMissed;
		totalDaysAbsent += numOfDaysMissed;
		//Write data to file
		outFile << "\n   " << employeeID << "\t\t    " << numOfDaysMissed;
	}
	//Return value total days absent
	return totalDaysAbsent;
}