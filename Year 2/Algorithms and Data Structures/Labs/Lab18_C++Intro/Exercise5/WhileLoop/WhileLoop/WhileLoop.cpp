// WhileLoop.cpp : Defines the entry point for the console application.
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

	int i = 1;
	while (i <= n)
	{
		cout << i;
		i++;
	}

	cin.get();
}

