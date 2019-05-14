using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AVLTrees
{
    class Program
    {
        static void Main(string[] args)
        {
            /*BSTree<int> tree = new BSTree<int>();

            tree.InsertItem(6);
            tree.InsertItem(10);
            tree.InsertItem(4);
            tree.InsertItem(12);
            tree.InsertItem(5);
            tree.InsertItem(11);
            tree.InsertItem(13);

            Console.WriteLine(tree.Height());
            Console.WriteLine(tree.Count());
            Console.WriteLine(tree.Contains(9));
            Console.WriteLine(tree.Contains(15));
            Console.WriteLine(tree.Count());
            tree.RemoveItem(13);
            Console.WriteLine("--------------------------------");
            Console.WriteLine(tree.Count());
            tree.RemoveItem(5);
            Console.WriteLine("--------------------------------");
            Console.WriteLine(tree.Count());
            tree.RemoveItem(9);
            Console.WriteLine("--------------------------------");
            Console.WriteLine(tree.Count());

            Console.ReadLine();*/

            AVLTree<int> tree = new AVLTree<int>();
            String buffer = "";
            String buffer1 = "";
            tree.InsertItem(15);
            tree.InsertItem(25);          
            tree.InsertItem(16);
            tree.InsertItem(10);
            tree.InsertItem(20);
            tree.InsertItem(23);
            tree.InsertItem(17);
            //Height should be 3 for SUCCESS
            Console.WriteLine(tree.Height());
            tree.InOrder(ref buffer);
            Console.WriteLine(buffer);
            tree.RemoveItem(25);
            Console.WriteLine(tree.Height());
            tree.InOrder(ref buffer1);
            Console.WriteLine(buffer1);
            Console.ReadLine();
        }
    }
}
