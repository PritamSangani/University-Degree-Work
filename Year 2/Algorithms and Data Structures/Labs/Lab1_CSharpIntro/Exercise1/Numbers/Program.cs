using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            /*int num1, num2, num, count, finalSum;
            num = 0;
            string input;
            Console.WriteLine("Enter 1st Number: ");
            input = Console.ReadLine();
            num1 = Convert.ToInt32(input);
            Console.WriteLine("Enter 2nd Number: ");
            input = Console.ReadLine();
            num2 = Convert.ToInt32(input);
            Console.WriteLine("Sum is: {0} and power is: {1}", sum(num1, num2), power(num1, num2));
            //{0} takes 1st argument and substitutes into string
            */
            int num=0, finalSum=0, count=0;
            string input;



            do
            {
                finalSum += num;
                Console.WriteLine("Enter next number: ");
                input = Console.ReadLine();
                num = Convert.ToInt32(input);
                count++;
            } while (num != -999);
            Console.WriteLine("Average of all numbers entered is: {0}", average(finalSum, (count-1)));
            Console.ReadKey(); //waits for a key to press before ending
        }

        static int sum(int x, int y)
        {
            return x + y;
        }

        static int power(int x, int y) // x to the power of y
        {
            int result = 1;
            if (y != 0) result = 0;
            for(int i = 1; i < y; i++)
            {
                result += x * x;
            }
            return result;
        }

        static float average(int sum, int n)
        {
            float average = 0f;
            average = (float)sum / (float)n;
            return average;
        }
        
        
    }
}
