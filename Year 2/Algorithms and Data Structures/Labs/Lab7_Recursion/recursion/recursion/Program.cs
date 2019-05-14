using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace recursion
{
    class Program
    {
        static void Main(string[] args)
        {
            printNumbers(5);
            Console.WriteLine("------------------------------------------------>>>");
            Console.WriteLine("gNS >>> " + getNumberString(10));
            Console.WriteLine("------------------------------------------------>>>");
            range(10, 5);
            Console.WriteLine("------------------------------------------------>>>");
            Console.WriteLine("* >>> " + multiply(3, 4));
            Console.WriteLine("------------------------------------------------>>>");
            Console.WriteLine("^ >>> " + power(3, 0));
            Console.WriteLine("------------------------------------------------>>>");
            Console.WriteLine("eg >>> " + calculation(5, 7, 8, 3));
            Console.ReadLine();
        }

        static void printNumbers(int n)
        {
            if (n > 0)
            {
                Console.WriteLine(" n = {0} ", n);
                printNumbers(n - 1);
            }
            /*Code waits to be run as soon a printNumbers() function has completed*/
            Console.WriteLine("\n Recursion Unfolding --- n = {0} ", n);
        }

        static string getNumberString(int n)
        {
            if(n == 0)
            {
                return "0";
            }
            else
            {
                return n + " " + getNumberString(n - 1);
            }

        }

        static void range(int start, int stop)
        {
            /* Displays numbers between start and stop - start <= stop */
            if(start == stop)
            {
                /* Stopping condition - what needs to be done here */
                Console.WriteLine(" n = {0} ", stop);
            }
            else
            {
                if(start > stop)
                {
                    range(start - 1, stop);
                    Console.WriteLine(" n = {0} ", start);
                }
                else
                {
                    /* recursive call and print start */
                    Console.WriteLine(" n = {0} ", start);
                    range(start + 1, stop);
                }
                
            }
        }

        static int multiply(int x, int y)
        {
            if(y == 1)
            {
                return x;
            }
            else if(y == 0 || x == 0)
            {
                return 0;
            }
            else
            {
                return x + multiply(x, dec(y));
            }
        }

        static int power(int x, int y)
        {
            if(y == 0)
            {
                return 1;
            }
            else
            {
                return x * power(x, dec(y));
            }
        }
        //EXTENTION INTERVIEW TYPE QUESTION
        static int calculation(int a, int b, int c, int d)
        {
            if (a == 0)
            {
                return 0;
            }
            else
            {
                return multiply(a, (multiply(b, c) + d));
            }           
        }
        //PREDICATE FUNCTIONS
        static int inc(int x)
        {
            return x + 1;
        }
        static int dec(int x)
        {
            return x - 1;
        }
    }
}
