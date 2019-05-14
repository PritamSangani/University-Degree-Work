using GlobalTradingDataApp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkListGen
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkListGen<int> testList1 = new LinkListGen<int>();
            LinkListGen<int> testList2 = new LinkListGen<int>();
            LinkListGen<Country> countryList = new LinkListGen<Country>();

            Country c1 = new Country("Apple","","");
            Country c3 = new Country("Cat", "", "");
            Country c2 = new Country("Ball","","");

            countryList.InsertInOrder(c1);
            countryList.InsertInOrder(c3);
            countryList.InsertInOrder(c2);
            for (int i = 0; i < 5; i++)
            {
                testList1.InsertInOrder(i);
            }

            for (int i = 10; i < 15; i++)
            {
                testList2.InsertInOrder(i);
            }
            testList2.InsertInOrder(20);
            testList2.InsertInOrder(18);

            Console.WriteLine("list1: " + testList1.DisplayList());
            Console.WriteLine("list2: " + testList2.DisplayList());

            Console.WriteLine(testList1.IsPresentItem(4));
            Console.WriteLine(testList1.IsPresentItem(10));
            testList1.RemoveItem(4);

            testList1.AppendItem(5);
            testList1.AppendItem(6);
            Console.WriteLine("List1: " + testList1.DisplayList());
            testList1.Concat(testList2);
            Console.WriteLine("List1: " + testList1.DisplayList());
            testList1.Copy(testList2);
            Console.WriteLine("List1: " + testList1.DisplayList());
            testList1.Sort();

            Console.WriteLine("List1: " + testList1.DisplayList());

            Console.WriteLine("0----------------------------------------");
            Console.WriteLine(countryList.DisplayList());

            Console.ReadKey();
        }
    }
}
