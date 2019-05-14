using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkListGen
{
    public class LinkListGen<T> : IEnumerable where T:IComparable
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

        public bool IsPresentItem(int item)
        {
            LinkGen<T> temp = list;
            bool isPresent = false;

            while (temp != null)
            {
                if (item.CompareTo(temp.Data) == 0)
                {
                    return isPresent = true;
                }
                temp = temp.Next;
            }

            return isPresent;
        }

        public void RemoveItem(T item)
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

        public void AppendItem(T item)
        {
            LinkGen<T> temp = list;

            if (temp == null)
            {
                list = new LinkGen<T>(item); 
            }
            else
            {
                while (temp.Next != null)
                {
                    temp = temp.Next;
                }
                temp.Next = new LinkGen<T>(item);
            }
        }

        public void Concat(LinkListGen<T> list2)
        {
            LinkGen<T> temp = list2.list;

            while (temp != null)
            {
                AppendItem(temp.Data);
                temp = temp.Next;
            }
        }

        public void Copy(LinkListGen<T> list2)
        {
            list = null;
            Concat(list2);
        }

        public void InsertInOrder(T item)
        {
            LinkGen<T> temp = list;

            if (list == null || item.CompareTo(temp.Data) < 0)
            {
                AddItem(item);
            }
            else
            {
                while (temp.Next != null)
                {
                    if(item.CompareTo(temp.Next.Data) < 0)
                    {
                        temp.Next = new LinkGen<T>(item, temp.Next);
                        return;
                    }
                    temp = temp.Next;
                }
                temp.Next = new LinkGen<T>(item, temp.Next);
                
            }
        }

        public void Sort()
        {
            LinkGen<T> temp = list;
            LinkListGen<T> newList = new LinkListGen<T>();

            while (temp != null)
            {
                newList.InsertInOrder(temp.Data);
                temp = temp.Next;
            }
            list = newList.list;
        }

        
        public IEnumerator<T> GetEnumerator()
        {            
            LinkGen<T> tmp = list;

            while (tmp != null)
            {
                while (tmp != null)
                {
                    yield return tmp.Data;                    
                    tmp = tmp.Next;
                }                                  
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }

}
