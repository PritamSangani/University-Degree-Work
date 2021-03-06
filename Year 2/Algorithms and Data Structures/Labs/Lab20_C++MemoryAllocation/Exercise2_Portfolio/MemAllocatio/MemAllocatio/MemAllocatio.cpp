// MemAllocatio.cpp : Defines the entry point for the console application.
// C++ program to illustrate dynamic allocation
// and deallocation of memory using new and delete

#include "stdafx.h"
#include <iostream>
using namespace std;

float *sum_of_numbers(int n)
{
	float* sum = new float (0.0);
	int m[200000];

	for (int i = 0; i < n; i++)
		*sum = *sum + i;

	return sum;
}

int main()
{
	int a = 25;
	int* p;

	p = new int;
	if (!p)
		cout << "allocation of memory failed\n";
	else
	{
		p = &a;
		cout << "Value of p: " << *p << endl;
	}

	float *r = new float(85.31);

	r = sum_of_numbers(75);

	cout << "Value of r: " << *r << endl;

	const int n = 500;
	int d[n];
	float q[10];

	if (!p)
		cout << "allocation of memory failed\n";
	else
	{
		for (int i = 0; i < n; i++)
			q[i] = i + 1;

		cout << "Value store in block of memory: ";
		for (int i = 0; i < n; i++)
			cout << q[i] << " ";
	}

	delete r;

	system("PAUSE");

	return 0;
}

