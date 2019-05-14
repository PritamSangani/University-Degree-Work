using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace BasicCollection
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList numbers = new ArrayList();
            numbers.Add("First");
            numbers.Add("Second");
            numbers.Add("Third");
            numbers.Add("Fourth");

            foreach(String element in numbers)
            {
                Console.WriteLine(element);
            }

            numbers.Sort();

            foreach (String element in numbers)
            {
                Console.WriteLine(element);
            }
            Console.ReadKey();
        }
    }
}
