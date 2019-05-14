using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GlobalTradingDataApp
{
    public class Node<T> where T : IComparable
    {
        private T data;
        private int balanceFactor = 0;
        public Node<T> Left, Right;

        public Node(T item)
        {
            data = item;
            Left = null;
            Right = null;
        }

        public T Data { get => data; set => data = value; }

        public int BalanceFactor { get => balanceFactor; set => balanceFactor = value; }

        public override string ToString() => Data.ToString();
    }
}
