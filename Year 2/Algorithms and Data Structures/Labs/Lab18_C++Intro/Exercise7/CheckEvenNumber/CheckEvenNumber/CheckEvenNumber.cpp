// CheckEvenNumber.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;


int main()
{
	int i;

	cout << "Enter a number: ";
	cin >> i;
	cin.get();
	if (i % 2 == 0)
	{
		cout << "True";
	}
	else 
	{
		cout << "False";
	}
	cin.get();
}

