// InputName.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

int main()
{
	string name;
	cout << "Enter your name: ";
	getline(cin, name);
	cout << "Hello " << name << ", how are you?";

	cin.get();
}

