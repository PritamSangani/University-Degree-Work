// PrintPrimeNumbers.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
	for (int i = 2; i < 100; i++)
	{
		bool flag = true;
		for (int j = 2; j <= i / 2; j++)
		{
			if (i%j == 0)
			{
				flag = false;
				break;
			}
		}
		if (flag == true) 
		{
			cout << i;
		}
	}

	cin.get();
}

