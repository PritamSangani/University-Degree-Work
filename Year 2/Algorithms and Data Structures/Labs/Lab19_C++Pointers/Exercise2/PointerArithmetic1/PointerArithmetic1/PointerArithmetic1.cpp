// PointerArithmetic1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <cstdlib>
#include <time.h>

using namespace std;

//Uppercase a letter with char casting
char upperCase(char ch)
{
	return (char)toupper(ch);
}


int main()
{
	char quote[] = "Don't be too proud of this technological terror you've constructed. The ability to destroy a planet is insignificant next to the power of the Force.";

	int i = 0;

	while (quote[i])
	{
		cout << upperCase(quote[i++]);
	}

	cin.get();
		

    return 0;
}

