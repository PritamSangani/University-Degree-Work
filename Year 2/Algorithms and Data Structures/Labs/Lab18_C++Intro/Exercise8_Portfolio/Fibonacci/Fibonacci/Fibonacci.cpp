// Fibonacci.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int Fibonacci(int n);
int main()
{
	int n;
	cout << "Enter a number: ";
	cin >> n;
	cin.get();
	for (int i = 1; i < n + 1; i++)
	{
		cout << Fibonacci(i) << "  ";
	}

	cin.get();
}

int Fibonacci(int n)
{
	if (n < 2)
	{
		return n;
	}
	else
	{
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}

