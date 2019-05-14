using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GraphsI
{
    class Program
    {
        static void Main(string[] args)
        {
            GraphNode<char> current;  //current location
            GraphNode<char> to;
            Graph<char> myGraph = new Graph<char>();
            List<char> visited = new List<char>();
            List<char> visited1 = new List<char>();

            myGraph.AddNode('A');
            myGraph.AddNode('B');
            myGraph.AddNode('C');
            myGraph.AddNode('D');
            myGraph.AddNode('E');
            myGraph.AddNode('F');            

            myGraph.AddEdge('A', 'B');
            myGraph.AddEdge('A', 'C');
            myGraph.AddEdge('A', 'D');
            myGraph.AddEdge('B', 'C');
            myGraph.AddEdge('C', 'D');
            myGraph.AddEdge('B', 'E');
            myGraph.AddEdge('C', 'E');
            myGraph.AddEdge('C', 'F');
            myGraph.AddEdge('D', 'F');

            current = myGraph.GetNodeByID('A');
            to = myGraph.GetNodeByID('B');

            Console.WriteLine("Is myGraph empty? Answer: {0}", myGraph.IsEmptyGraph());
            Console.WriteLine("Is myGraph contain {0}? Answer: {1}", current.ID, myGraph.ContainsGraph(current));
            Console.WriteLine("Is node {0} and {1} adjacent? Answer: {2}",
                  current.ID, to.ID, myGraph.IsAdjacent(current, to));
            Console.WriteLine("Is node {0} and {1} adjacent? Answer: {2}",
                  to.ID, current.ID, myGraph.IsAdjacent(to, current));

            Console.WriteLine("\nDepth First Traversal ------------------------->");
            myGraph.DepthFirstTraverse('A', ref visited);
            Console.WriteLine("\n\n--------------------------------------------------------");
            Console.WriteLine("\nBreadth First Traversal ------------------------->");
            myGraph.BreadthFirstTraverse('A', ref visited1);

            Console.ReadLine();
        }
    }
}
