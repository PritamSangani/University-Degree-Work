using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntegerStack
{
    class Program
    {
        static void Main(string[] args)
        {
            //EXERCISE 2

        /*
            System.Console.WriteLine("Exercise 2 >>> ");
            IntStack myStack = new IntStack();

            myStack.Push(10);
            System.Console.WriteLine(myStack.Pop());

            myStack.Push(20);
            myStack.Push(30);
            myStack.Push(40);

            System.Console.WriteLine(myStack.Pop());
            System.Console.WriteLine(myStack.Pop());
            System.Console.WriteLine(myStack.Pop());

            System.Console.ReadKey();
        */

            //EXERCISE 3
            System.Console.WriteLine("Exercise 3 >>> ");

            IntStack myStack2 = new IntStack();
            Random randNum = new Random();

            while (!myStack2.IsFull())
            {
                //generate random number between 0 and 100
                int numToPush = randNum.Next(100);
                myStack2.Push(numToPush);
            }

            while (!myStack2.IsEmpty())
            {
                myStack2.Pop();
            }



            System.Console.ReadKey();

        }
    }
}
