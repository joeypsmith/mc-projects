/*
 * Class: CMSC140 CRN-23506
 * Instructor: Dr. Grinberg
 * Project 3
 * Computer/Platform/Compiler:
 * Description: Write a program that calculates the occupancy rate and total hotel income for one night.
				Display the information as well as some other information.
 * Due Date: 11/8/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Joseph Smith

*/
#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main() {
	//String Variables
	string location;
	//Integer Variables
	int totalFloors;
	int totalRooms = 0;
	int tempRooms;
	int occupiedRooms = 0;
	int totalUnoccupiedRooms;
	int singleRooms;
	int doubleRooms;
	int kingRooms;
	int suiteRooms;
	int totalSingleRooms = 0;
	int totalDoubleRooms = 0;
	int totalKingRooms = 0;
	int totalSuiteRooms = 0;
	int hotelIncome;
	//Constant Integer Variables
	const int MIN_FLOORS = 1;
	const int MAX_FLOORS = 5;
	const int MIN_ROOMS = 1;
	const int MAX_ROOMS = 30;
	const int SINGLE_RATE = 60;
	const int DOUBLE_RATE = 75;
	const int KING_RATE = 100;
	const int SUITE_RATE = 150;
	const int OCCUPANCY_RATE_GOAL = 60;
	//Constant Progammer Variables
	const string PROGRAMMER_NAME = "Joseph Smith";
	const string DUE_DATE = "11/8/2020";
	const int ASSIGNMENT_NUMBER = 3;
	//Double Variables
	double occupancyRate;
	//Least Floor and Room Variables
	int leastFloor = MAX_FLOORS;
	int leastFloorRooms = MAX_ROOMS;


	//Bluemont Hotel header
	for (int i = 1; i <= 50; i++)
		cout << "=";
	cout << "\n\t\tBlueMont Hotel\n";
	for (int i = 1; i <= 50; i++)
		cout << "=";
	//Location input
	cout << "\nEnter the location of this hotel chain: ";
	getline(cin, location);
	//Total floors input loop
	do {
		cout << "\nEnter total number of floors in the hotel: ";
		cin >> totalFloors;
		if (totalFloors < MIN_FLOORS || totalFloors > MAX_FLOORS) {
			cout << "\nNumber of floors should be between 1 and 5 !! Please try again.";
		}
	} while (totalFloors < MIN_FLOORS || totalFloors > MAX_FLOORS);
	//Amount of rooms and occupied rooms on each floor loop
	int x = 1;
	while (x <= totalFloors) {
		cout << "\nEnter total number of rooms on Floor " << x << ": ";
		cin >> tempRooms;
		if (tempRooms >= MIN_ROOMS && tempRooms <= MAX_ROOMS) {
			if (tempRooms <= leastFloorRooms) {
				leastFloor = x;
				leastFloorRooms = tempRooms;
			}
			do {
				cout << "How many SINGLE rooms are occupied on Floor " << x << ": ";
				cin >> singleRooms;
				cout << "How many DOUBLE rooms are occupied on Floor " << x << ": ";
				cin >> doubleRooms;
				cout << "How many KING rooms are occupied on Floor " << x << ": ";
				cin >> kingRooms;
				cout << "How many SUITE rooms are occupied on Floor " << x << ": ";
				cin >> suiteRooms;
				if ((singleRooms + doubleRooms + kingRooms + suiteRooms) < 0 ||
					(singleRooms + doubleRooms + kingRooms + suiteRooms) > tempRooms) {
					cout << "\nNumber of occupied rooms exceeds amount of rooms on Floor " << x << " !! Please try again.\n";
				}
			} while ((singleRooms + doubleRooms + kingRooms + suiteRooms) < 0 ||
				(singleRooms + doubleRooms + kingRooms + suiteRooms) > tempRooms);
			totalSingleRooms += singleRooms;
			totalDoubleRooms += doubleRooms;
			totalKingRooms += kingRooms;
			totalSuiteRooms += suiteRooms;
			occupiedRooms += (singleRooms + doubleRooms + kingRooms + suiteRooms);
			x++;
			totalRooms += tempRooms;
		}
		else {
			cout << "\nNumber of rooms should be between 1 and 30 !! Please try again.";
		}

	}

	//Hotel calculations output
	//Header
	for (int i = 1; i <= 100; i++)
		cout << "=";
	cout << "\n\t\t\t\tBlueMont Hotel located in " << location << ".\n";
	cout << "\n\t\t\t\t TODAY'S ROOM RATES ($/NIGHT)\n\n";
	cout << "   \t\tSINGLE ROOM\tDOUBLE ROOM\tKING ROOM\tSUITE ROOM\n";
	cout << "\t\t    $60\t\t    $75\t\t  $100\t\t   $150\n";
	for (int i = 1; i <= 100; i++)
		cout << "=";
	//Income, occupancy rate
	hotelIncome = ((totalSingleRooms * SINGLE_RATE) + (totalDoubleRooms * DOUBLE_RATE) + (totalKingRooms * KING_RATE) + (totalSuiteRooms * SUITE_RATE));
	totalUnoccupiedRooms = totalRooms - occupiedRooms;
	occupancyRate = (static_cast<double>(occupiedRooms) / static_cast<double>(totalRooms)) * 100;
	//Hotel income and room count output
	cout << setw(10) << "\n\t\t               Hotel Income:\t\t$" << hotelIncome;
	cout << setw(10) << "\n\t\t           Total # of Rooms:\t\t" << totalRooms;
	cout << setw(10) << "\n\t\t  Total # of Occupied Rooms:\t\t" << occupiedRooms;
	cout << setw(10) << "\n\t\tTotal # of UnOccupied Rooms:\t\t" << totalUnoccupiedRooms;
	cout << setw(10) << "\n\t\t             Occupancy Rate:\t\t" << occupancyRate << "%";
	cout << endl << "\n\tFloor: " << leastFloor << " with " << leastFloorRooms << " rooms, has the least number of rooms in the hotel.";
	if (occupancyRate < OCCUPANCY_RATE_GOAL) {
		cout << "\n\tNeed to improve occupancy rate !! ";
	}
	//Outro message
	cout << "\n\nThank you for testing my program!" << endl
		<< "PROGRAMMER: " << PROGRAMMER_NAME << endl
		<< "CMSC140 Common Project " << ASSIGNMENT_NUMBER << endl
		<< "Due Date: " << DUE_DATE << endl;
}