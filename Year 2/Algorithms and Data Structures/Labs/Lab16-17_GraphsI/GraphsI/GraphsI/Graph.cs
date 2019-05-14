using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GraphsI
{
    class Graph<T> where T:IComparable
    {
        //list of GraphNodes in this graph
        private LinkedList<GraphNode<T>> nodes;

        public Graph()
        {
            nodes = new LinkedList<GraphNode<T>>();
        }

        //only return true if the graph's list of nodes is empty
        public bool IsEmptyGraph() => nodes == null;

        //Search through list of nodes for node
        //Node will be a new GraphNode with the node
        //containing the ID to be searched for
        public bool ContainsGraph(GraphNode<T> node)
        {
            //search based on ID 
            //go through each node in LinkedList of nodes
            foreach(GraphNode<T> n in nodes)
            {
                if (n.ID.CompareTo(node.ID) == 0)
                    return true;
            }
            return false;            
        }

        //find 'from' in list of nodes and search its adjlist for 'to'
        public bool IsAdjacent(GraphNode<T> from, GraphNode<T> to)
        {
            foreach(GraphNode<T> n in nodes)
            {
                if(n.ID.CompareTo(from.ID) == 0)
                {
                    if (from.GetAdjList().Contains(to.ID))                                       
                        return true;                                           
                }
            }
            return false;
        }

        //add a new  GraphNode to list of Nodes
        public void AddNode(T id)
        {
            GraphNode<T> node = new GraphNode<T>(id);

            nodes.AddFirst(node);
        }

        //Search through list of nodes for node with this id
        public GraphNode<T> GetNodeByID(T id)
        {
            foreach(GraphNode<T> n in nodes)
            {
                if (n.ID.CompareTo(id) == 0)
                    return n;             
            }
            return null;
        }

        //find 'from' in list of nodes and call GraphNode method to add 
        //an edge to 'to' - think about validation
        public void AddEdge(T from, T to)
        {
            GraphNode<T> nodeFrom = GetNodeByID(from);
            GraphNode<T> nodeTo = GetNodeByID(to);

            if(nodeFrom != null && nodeTo != null)            
                nodeFrom.AddEdge(nodeTo);                   
        }

        //perform a DFS traversal starting at startID 
        //leaving a list of visited IDs in the visited list
        public void DepthFirstTraverse(T startID, ref List<T> visited)
        {           
            LinkedList<T> adj;
            Stack<T> toVisit = new Stack<T>();
            GraphNode<T> current;
            toVisit.Push(startID);

            while(toVisit.Count != 0)
            {
                startID = toVisit.Peek();
                current = GetNodeByID(startID);
                toVisit.Pop();
                visited.Add(current.ID);           
                adj = current.GetAdjList();

                foreach(T adjNode in adj)
                {
                    if (!toVisit.Contains(adjNode) && !visited.Contains(adjNode))
                        toVisit.Push(adjNode);
                }
            }

            foreach(T n in visited)            
                Console.Write(n + " ");            
        }

        //perform a BFS traversal starting at startID 
        //leaving a list of visited IDs in the visited list
        public void BreadthFirstTraverse(T startID, ref List<T> visited)
        {
            LinkedList<T> adj;
            Queue<T> toVisit = new Queue<T>();
            GraphNode<T> current;
            toVisit.Enqueue(startID);

            while (toVisit.Count != 0)
            {
                startID = toVisit.Peek();
                current = GetNodeByID(startID);
                toVisit.Dequeue();
                visited.Add(current.ID);
                adj = current.GetAdjList();

                foreach (T adjNode in adj)
                {
                    if (!toVisit.Contains(adjNode) && !visited.Contains(adjNode))
                        toVisit.Enqueue(adjNode);
                }
            }

            foreach (T n in visited)            
                Console.Write(n + " ");            
        }

    }
}
