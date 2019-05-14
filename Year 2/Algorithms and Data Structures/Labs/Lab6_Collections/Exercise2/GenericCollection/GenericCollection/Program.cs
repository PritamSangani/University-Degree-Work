using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GenericCollection
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkedList<int> myList = new LinkedList<int>();

            myList.AddFirst(1);
            myList.AddLast(2);
            myList.AddLast(3);
            myList.AddLast(4);
            myList.AddLast(5);

            myList.Remove(5);

            foreach(int element in myList)
            {
                Console.WriteLine(element);
            }
            Console.ReadKey();
        }
    }
}
