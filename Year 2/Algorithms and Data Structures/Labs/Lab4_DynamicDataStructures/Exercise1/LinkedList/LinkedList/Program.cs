using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedList
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkList testList = new LinkList();

            for(int i = 0; i < 5; i++)
            {
                testList.AddItem(i);
            }
        
            Console.WriteLine("Items in the list: " + testList.DisplayItems());
            Console.WriteLine("Number of items in the list: " + testList.NumberOfItems());
            

            Console.ReadKey();
        }
    }
}
