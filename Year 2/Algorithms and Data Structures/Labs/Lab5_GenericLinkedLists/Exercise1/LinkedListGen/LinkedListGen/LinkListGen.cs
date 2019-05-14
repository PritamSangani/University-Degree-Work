using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedListGen
{
    class LinkListGen<T> where T:IComparable
    {
        private LinkGen<T> list = null;

        public void AddItem(T item)
        {
            list = new LinkGen<T>(item, list);
        }

        public string DisplayList()
        {
            LinkGen<T> temp = list;
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
            LinkGen<T> temp = list;
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
            LinkGen<T> temp = list;
            bool isPresent = false;

            while (temp != null)
            {
                if (item.CompareTo(temp.Data) == 0)
                {
                    isPresent = true;
                }
                temp = temp.Next;
            }

            return isPresent;
        }

        public void RemoveItem(int item)
        {
            LinkGen<T> temp = list;

            while (temp != null)
            {
                if (item.CompareTo(temp.Data) == 0)
                {
                    list = temp.Next;
                }

                else if (temp.Next != null && item.CompareTo(temp.Next.Data) == 0)
                {
                    temp.Next = temp.Next.Next;
                }
                temp = temp.Next;
            }
        }
    }
}
