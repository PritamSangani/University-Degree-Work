using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GraphsI
{
    public class GraphEdge<T>
    {
        private GraphNode<T> to;
        int weight;

        public GraphEdge(GraphNode<T> to, int weight)
        {
            this.to = to;
            this.weight = weight;
        }
    }
}
