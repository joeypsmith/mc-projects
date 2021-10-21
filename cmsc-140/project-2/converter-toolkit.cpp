/*
Project: Project 2
Class: CMSC140-23506 CRN
Instructor: Grigoriy Grinberg
Project:<2>
Description: Two mains systems of measuring, metric and imperial.
			This program detects your country from input,
			and converts temperature, distance,
			or weight depending on the countries 
			said measuring system.
Due Date : 10/18/2020
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your name here: Joseph Smith
*/
/* List of Input for the program:
	1. countryName;
	2. selection;
	3. temperature;
	4. distance;
	5. weight;

 * List of Output from the program:
	1. tempF;
	2. weightP;
	3. distanceM;
	4. countryName;

*/

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main() {
	
	string countryName;

	int selection;

	double temperature;
	double tempF;
	double weight;
	double weightP;
	double distance;
	double distanceM;

	cout << "Enter a country name: ";
	getline(cin, countryName);
	
	cout << endl << "Converter Toolkit"
		<< endl << "-----------------"
		<< endl << "1. Temperature Converter"
		<< endl << "2. Distance Converter"
		<< endl << "3. Weight Converter"
		<< endl << "4. Quit";
	
	cout << endl << "Enter your choice: ";
	cin >> selection;

	switch (selection) {
	case 1: cout << "Please enter a temperature in Celsius (such as 24): ";
		cin >> temperature;
		tempF = (9 / 5) * temperature + 32;
		cout << endl << "It is " << (int)tempF << " in Fahrenheit." << endl;
		break;

	case 2: cout << "Please enter a distance in Kilometers (such as 18.54): ";
		cin >> distance;
		if (distance >= 0) {
			distanceM = distance * 0.6;
			cout << "It is " << setprecision(2) << fixed << distanceM << " in Miles." << endl;
			break;
		}
		else {
			cout << "!!! PROGRAM DOES NOT CONVERT NEGATIVE DISTANCE !!!" << endl;
			break;
		}
	case 3: cout << "Please enter a weight in Kilograms (such as 5.2): ";
		cin >> weight;
		if (weight >= 0) {
			weightP = weight * 2.2;
			cout << "It is " << setprecision(1) << fixed << weightP << " in Pounds." << endl;
			break;
		}
		else {
			cout << "!!! PROGRAM DOES NOT CONVERT NEGATIVE WEIGHT !!!" << endl;
			break;
		}
	case 4: cout << "Quitting program.";
		break;
	default: cout << "Invalid selection. Try again.";
		break;
	}

	cout << endl << countryName << " sounds fun!" << endl
		<< endl <<
		"Thank you for testing my program!" << endl 
		<< "PROGRAMMER: Joseph Smith" << endl
		<< "CMSC140 PROJECT 2" << endl
		<< "Due Date: 10/18/2020";
	return 0;
}