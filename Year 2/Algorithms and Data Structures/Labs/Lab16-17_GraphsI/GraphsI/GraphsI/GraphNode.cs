using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GraphsI
{
    public class GraphNode<T>
    {
        private T id;
        private LinkedList<T> adjList; //adjacency list

        public GraphNode(T id)
        {
            this.id = id;
            adjList = new LinkedList<T>();        
        }

        //add an edge from this node : add 'to' to the adjacency list
        public void AddEdge(GraphNode<T> to) => adjList.AddFirst(to.ID);

        //set and get properties for id - data stored in the graph
        public T ID { get => id; set => id = value; }

        //returns adjacency list - useful for traversal methods.
        public LinkedList<T> GetAdjList() => adjList;
    }
}
