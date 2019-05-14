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

            BinTree<int> binTree = new BinTree<int>(tree);
            string outBuffer = "";

            binTree.InOrder(ref outBuffer);
            Console.WriteLine("InOrder >>> " + outBuffer);
            outBuffer = "";
            binTree.PreOrder(ref outBuffer);
            Console.WriteLine("PreOrder >>> " + outBuffer);
            outBuffer = "";
            binTree.PostOrder(ref outBuffer);
            Console.WriteLine("PostOrder >>> " + outBuffer);
            Console.ReadLine();
        }
    }
}
