using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntegerQueue
{
    class IntQueue
    {
        private readonly int maxsize = 10;
        private int[] store;
        private int head = 0;
        private int tail = 0;
        private int numItems;

        public IntQueue()
        {
            store = new int[maxsize];
        }

        public IntQueue(int size)
        {
            maxsize = size;
            store = new int[maxsize];
        }

        public void Enqueue(int value)
        {
            numItems++;
            store[tail] = value;
            if (++tail == maxsize)
            {
                tail = 0;
            }
        }

        public int Dequeue()
        {
            int headItem;
            numItems--;
            headItem = store[head];
            if(++head == maxsize)
            {
                head = 0;
            }

            return headItem;
        }

        public int Peek()
        {
            return store[head];
        }

        public bool IsEmpty()
        {
            return numItems == 0;
        }

        public bool IsFull()
        {
            return numItems == maxsize; 
        }

        public int Count()
        {
            return numItems;
        }

        public string Print()
        {
            StringBuilder output = new StringBuilder();
   
            foreach (int element in store)
            {
                output.Append(store[element] + Environment.NewLine);
            }

            return output.ToString();
        }
    }
}
