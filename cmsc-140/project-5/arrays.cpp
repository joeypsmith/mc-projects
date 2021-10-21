#include<iostream>
using namespace std;

// Global constants 
const int ROWS = 3;  // The number of rows in the array
const int COLS = 3;  // The number of columns in the array
const int MIN = 1;  // The value of the smallest number
const int MAX = 9;  // The value of the largest number

//Programmer Details
const string PROGRAMMER_NAME = "Joseph Smith";
const string DUE_DATE = "12/6/2020";
const int PROJECT_NUMBER = 5;

char tryAgain;

// Function prototypes
bool isMagicSquare(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
bool checkRange(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size, int min, int max);
bool checkUnique(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
bool checkRowSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
bool checkColSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
bool checkDiagSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
void fillArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
void showArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
void ProgrammerDetails(string, string, int);

int main()
{

	/* Define a Lo Shu Magic Square using 3 parallel arrays corresponding         to each row of the grid */
	do {
		int magicArrayRow1[COLS] = {}, magicArrayRow2[COLS] = {}, magicArrayRow3[COLS] = {};
		fillArray(magicArrayRow1, magicArrayRow2, magicArrayRow3, COLS);
		showArray(magicArrayRow1, magicArrayRow2, magicArrayRow3, COLS);
		checkRange(magicArrayRow1, magicArrayRow2, magicArrayRow3, COLS, MIN, MAX);
		if (isMagicSquare(magicArrayRow1, magicArrayRow2, magicArrayRow3, COLS) == true) {
			cout << endl << "This is a Lo Shu magic square.";
		}
		else {
			cout << endl << "This is not a Lo Shu magic square.";
		}
		cout << endl << "Do you want to try again?";
		cin >> tryAgain;
	} while (tryAgain != 'n');
	ProgrammerDetails(PROGRAMMER_NAME, DUE_DATE, PROJECT_NUMBER);
	
}
// Function definitions go here
void fillArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) {
	for (int i = 0; i < size; i++) {
		cout << "Enter the number for row 0 " << "and column " << i << " :";
		cin >> arrayRow1[i];	
	}
	
	for (int i = 0; i < size; i++) {
		cout << "Enter the number for row 1 " << "and column " << i << " :";
		cin >> arrayRow2[i];
	}

	for (int i = 0; i < size; i++) {
		cout << "Enter the number for row 2 " << "and column " << i << " :";
		cin >> arrayRow3[i];
	}
}

void showArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) {
	for (int i = 0; i < size; i++) {
		cout << arrayRow1[i] << " ";
	}
	cout << endl;
	for (int i = 0; i < size; i++) {
		cout << arrayRow2[i] << " ";
	}
	cout << endl;
	for (int i = 0; i < size; i++) {
		cout << arrayRow3[i] << " ";
	}
}

bool isMagicSquare(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) {
	if (checkRowSum(arrayRow1, arrayRow2, arrayRow3, size) == true &&
		checkColSum(arrayRow1, arrayRow2, arrayRow3, size) == true &&
		checkDiagSum(arrayRow1, arrayRow2, arrayRow3, size) == true) {
		return true;
	}
	else {
		return false;
	}
}

bool checkRange(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size, int min, int max) {
	for(int i = 0; i < size; i++) {
		if (arrayRow1[i] < min || arrayRow1[i] > max) {
			return false;
		} else if (arrayRow2[i] < min || arrayRow2[i] > max) {
			return false;
		} else if (arrayRow3[i] < min || arrayRow3[i] > max) {
			return false;
		}
		else {
			return true;
		}
	}
}
bool checkUnique(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) {
	for (int i = 0; i < size; i++) {
		for (int j = 1; j < size + 1; j++) {
			if (arrayRow1[i] == arrayRow1[j]) {
				return false;
			}
			else if(arrayRow2[i] == arrayRow2[j]){
				return false;
			}
			else if (arrayRow3[i] == arrayRow3[j]) {
				return false;
			}
			else {
				return true;
			}
		}
	}
}

bool checkRowSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) {
	int sum1 = 0, sum2 = 0, sum3 = 0;
	for (int i = 0; i < size; i++) {
		sum1 += arrayRow1[i];
		sum2 += arrayRow2[i];
		sum3 += arrayRow3[i];
	}
	if (sum1 == sum2 && sum2 == sum3) {
		return true;
	}
	else {
		return false;
	}
}

bool checkColSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) {
	int sum1 = 0, sum2 = 0, sum3 = 0;
	sum1 = arrayRow1[0] + arrayRow2[0] + arrayRow3[0];
	sum2 = arrayRow1[1] + arrayRow2[1] + arrayRow3[1];
	sum3 = arrayRow1[2] + arrayRow2[2] + arrayRow3[2];
	

	if (sum1 == sum2 && sum2 == sum3) {
		return true;
	}
	else {
		return false;
	}
}

bool checkDiagSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) {
	int sum1 = 0, sum2 = 0;
	sum1 = arrayRow1[0] + arrayRow2[1] + arrayRow3[2];
	sum2 = arrayRow1[2] + arrayRow2[1] + arrayRow3[0];
	if (sum1 == sum2) {
		return true;
	}
	else {
		return false;
	}
}

void ProgrammerDetails(string name, string date, int project) {
	cout << endl <<
		"Name: " << name << endl
		<< "Project #: " << project << endl
		<< "Due Date: " << date;
}