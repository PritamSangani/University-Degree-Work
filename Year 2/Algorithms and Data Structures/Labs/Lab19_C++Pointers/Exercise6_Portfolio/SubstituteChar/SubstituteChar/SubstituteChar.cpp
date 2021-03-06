// SubstituteChar.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

void substitute(char toReplace, char newChar, char* string)
{
	
	while (*string != '\0')
	{
		if (*string == toReplace)
		{
			*string = newChar;
		}
		string++;
	}
}

int main()
{
	char string[] = "Hello, My name is Pritam.";

	cout << string << endl;

	substitute('l', 'm', string);

	cout << "After char substitution" << endl;
	cout << string << endl;

	cin.get();

    return 0;	
}
