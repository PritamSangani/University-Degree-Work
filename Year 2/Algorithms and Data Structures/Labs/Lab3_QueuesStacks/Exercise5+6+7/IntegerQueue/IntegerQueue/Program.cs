using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntegerQueue
{
    class Program
    {
        static void Main(string[] args)
        {
            IntQueue myqueue = new IntQueue(10);

            while (!myqueue.IsFull())
            {
                Console.WriteLine(myqueue.IsFull());
                myqueue.Enqueue(1);
            }

            for (int i = 0; i < 5; i++)
            {
                myqueue.Dequeue();
            }
            

            Console.ReadKey();
        }
    }
}
