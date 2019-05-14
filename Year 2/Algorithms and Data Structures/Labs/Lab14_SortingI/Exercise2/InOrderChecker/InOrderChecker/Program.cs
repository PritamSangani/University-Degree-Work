using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InOrderChecker
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = { 0, 1, 2, 3 };
            int[] array1 = { 5, 4, 3, 2 };
            
            Console.WriteLine(InOrder(array));
            Console.WriteLine(InOrder(array1));
            Console.ReadLine();
        }

        public static Boolean InOrder(int[] arr)
        {
            for(int i = 0; i < arr.Length-1; i++)
            {
                if (arr[i] >= arr[i + 1])
                    return false;
            }
            return true;
        }
    }
}
