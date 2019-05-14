using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntegerStack
{
    class IntStack
    {
        private const int maxSize = 10;
        private int top = 0;
        private int[] array = new int[maxSize];

        public void Push(int value)
        {
            if (!IsFull())
            {
                array[top++] = value;
            }
            
        }

        public int Pop()
        {
            if (!IsEmpty())
            {
                return array[--top];
            }
            return 0;
        }

        public int Peek()
        {
            if (!IsEmpty())
            {
                return array[top - 1];
            }
            return 0;
            
        }

        public bool IsEmpty()
        {
            return top == 0;
        }

        public bool IsFull()
        {
            return top == maxSize;
        }

        public string Print()
        {
            StringBuilder output = new StringBuilder();

            for (int i = top - 1; i >= 0; i--)
            {
                output.Append(array[i] + Environment.NewLine);
            }

            return output.ToString();
        }
    }
}
