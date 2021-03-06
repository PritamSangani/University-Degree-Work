// DiscountExercise1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

const double DISCOUNT = 0.15;

void printPrice(double price) 
{
	cout << "The Price of the Goods is " << price << endl;
}

void applyDiscount(double *price)
{
	*price = *price * (1 - (DISCOUNT));
}


int main()
{
	const double WIDGET_PRICE = 12.0;
	double quantity = 5;
	double orderPrice = quantity * WIDGET_PRICE;

	printPrice(orderPrice);
	applyDiscount(&orderPrice);

	cout << "After Discount " << endl;
	printPrice(orderPrice);

	cin.get();

    return 0;
}

