using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedListGen
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkListGen<int> testList = new LinkListGen<int>();

            for (int i = 0; i < 5; i++)
            {
                testList.AddItem(i);
            }

            testList.AddItem(3);
            testList.AddItem(5);
            testList.AddItem(5);
            testList.AddItem(5);
            testList.AddItem(3);


            Console.WriteLine("Items in the list: " + testList.DisplayList());
            Console.WriteLine("Number of items in the list: " + testList.NumberOfItems());
            Console.WriteLine("IsPresent? : " + testList.IsPresentItem(3));
            testList.RemoveItem(3);
            Console.WriteLine("Items in the list: " + testList.DisplayList());

            Console.ReadKey();
        }
    }
}
