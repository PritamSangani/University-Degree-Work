// ForLoop.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;


int main()
{
	int n;

	cout << "Enter a number: ";
	cin >> n;
	cin.get();
	for (int i = 1; i <= n; i++)
	{
		cout << i;
	}

	cin.get();
}

