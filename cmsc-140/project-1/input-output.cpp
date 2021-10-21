/*
Project: JSMITH_PROJECT1.cpp
Class: CMSC140 CRN23506
Instructor: Grigoriy Grinberg
Project:<1>
Description: Project 1
Due Date : 10/04/2020
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your name here: Joseph Smith
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
	//Variables
	const string robotName = "Nao";
	string visitorName;
	int age;
	//constants
	const int DAYS_PER_MONTH = 30;
	const int MONTHS_PER_YEAR = 12;
	const int MINUTES_PER_HOUR = 60;
	const int SECONDS_PER_MINUTE = 60;
	const int HOURS_PER_DAY = 24;
	const int ONE_DOG_YEAR = 7;
	const int ONE_FISH_YEAR = 10;
	//Project Information
	const string PROGRAMMER_NAME = "Joseph Smith";
	const int ASSIGNMENT_NUMBER = 1;
	const string DUE_DATE = "10/4/2020";
	//whole numbers for calculation
	int wholeNumber;
	int secondWholeNumber;
	//results of arithmetic
	int additionResult;
	int divisionResult;
	//whole numbers converted to doubles for precise division
	double doubleWholeNumber;
	double secondDoubleWholeNumber;
	double doubleDivisionResult;
	//Introduction
	cout << "Hello, welcome to Montgomery College! My name is " << robotName << ". May I have your name?" << endl;
	//Name input, age input
	getline(cin, visitorName);
	cout << "Nice to have you with us today, " << visitorName << endl;
	cout << "Let me impress you with a small game." << endl
		<< "Give me the age of an important person or pet to you." << endl
		<< "Please give me only a number: " << endl;
	cin >> age;
	cout << endl;
	cout << "You have entered " << age << "." << endl;
	// Age calculations, months, days, hours, etc.
	long unsigned int daysPerYear = DAYS_PER_MONTH * MONTHS_PER_YEAR;
	long unsigned int hoursPerYear = HOURS_PER_DAY * daysPerYear;
	long unsigned int minutesPerYear = MINUTES_PER_HOUR * hoursPerYear;
	long unsigned int secondsPerYear = SECONDS_PER_MINUTE * minutesPerYear;
	//Age calculations output
	if (age > 0) {
		cout << " If this is for a person, the age can be expressed as: " << endl
			<< " " << age << " years" << endl
			<< " or about " << age * MONTHS_PER_YEAR << " months" << endl
			<< " or about " << age * daysPerYear << " days" << endl
			<< " or about " << age * hoursPerYear << " hours" << endl
			<< " or about " << age * minutesPerYear << " minutes" << endl
			<< " or about " << age * secondsPerYear << " seconds" << endl
			<< " If this is for a dog, it is " << ONE_DOG_YEAR * age << " years old in human age." << endl
			<< " If this is for a gold fish, it is " << ONE_FISH_YEAR * age << " years old in human age." << endl;
		cout << endl;
	}
	else {
		cout << "Invalid age.";
		return 0;
	}
	//Second Game
	cout << "Let's play another game, " << visitorName << ". Give me a whole number." << endl;
	cin >> wholeNumber;
	cout << "Very well. Give me another whole number." << endl;
	cin >> secondWholeNumber;
	//Calculate addition of both numbers
	additionResult = wholeNumber + secondWholeNumber;
	cout << "Using the operator '+' in C++, the result of " << wholeNumber << " + " << secondWholeNumber << " is " << additionResult << endl;
	//Calculate division of both numbers
	divisionResult = wholeNumber / secondWholeNumber;
	cout << "Using the operator '/', the result of " << wholeNumber << " / " << secondWholeNumber << " is " << divisionResult << endl;
	// Convert the integers to doubles
	doubleWholeNumber = static_cast<double>(wholeNumber);
	secondDoubleWholeNumber = static_cast<double>(secondWholeNumber);
	doubleDivisionResult = doubleWholeNumber / secondDoubleWholeNumber;
	// Calculate division of new double numbers
	cout << "However, the result of " << doubleWholeNumber << " / " << secondDoubleWholeNumber << " is about " << doubleDivisionResult << "." << endl;
	cout << endl;
	// Outro
	cout << "Thank you for testing my program!" << endl << "PROGRAMMER: " << PROGRAMMER_NAME << endl << "CMSC140 COMMON PROJECT: " << ASSIGNMENT_NUMBER << endl << "DUE DATE: " << DUE_DATE << endl;
}
