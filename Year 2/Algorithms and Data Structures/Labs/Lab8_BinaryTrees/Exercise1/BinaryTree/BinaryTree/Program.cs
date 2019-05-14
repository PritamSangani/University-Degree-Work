using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BinaryTree
{
    class Program
    {
        static void Main(string[] args)
        {
            Node<int> tree = new Node<int>(6);
            tree.Left = new Node<int>(2);
            tree.Left.Right = new Node<int>(5);

            Console.ReadLine();
        }
    }
}
