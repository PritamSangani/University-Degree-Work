using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedList2
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

            while (temp != null)
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

        //PORTFOLIO

        public bool IsPresentItem(int item)
        {
            Link temp = list;
            bool isPresent = false;

            while (temp != null)
            {
                if(temp.Data == item)
                {
                    isPresent = true;
                }
                temp = temp.Next;
            }

            return isPresent;
        }

        public void RemoveItem(int item)
        {
            Link temp = list;

            while (temp != null)
            {
                if (temp.Data == item)
                {
                    list = temp.Next;
                }

                else if (temp.Next != null && temp.Next.Data == item )
                {
                    temp.Next = temp.Next.Next;
                }
                temp = temp.Next;
            }
        }
    }
}
