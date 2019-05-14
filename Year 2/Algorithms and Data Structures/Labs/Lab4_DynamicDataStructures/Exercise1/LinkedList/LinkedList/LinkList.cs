using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedList
{
    class LinkList
    {
        private Link list = null;

        public void AddItem(int item)
        {
            list = new Link(item, list);
        }

        public string DisplayItems()
        {
            Link temp = list;
            string buffer = "";

            while (temp!= null)
            {
                buffer += temp.Data + " ";
                temp = temp.Next;
            }
            return buffer;
        }

        public int NumberOfItems()
        {
            Link temp = list;
            int count = 0;

            while (temp != null)
            {
                count++;
                temp = temp.Next;
            }
            return count;
        }
    }
}
