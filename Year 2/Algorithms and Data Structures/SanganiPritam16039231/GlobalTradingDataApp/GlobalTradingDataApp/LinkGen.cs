using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkListGen
{
    public class LinkGen<T>
    {
        private T data;
        private LinkGen<T> next;

        public LinkGen(T item)
        {
            data = item;
            next = null;
        }

        public LinkGen(T item, LinkGen<T> list)
        {
            data = item;
            next = list;
        }

        public T Data
        {
            set { this.data = value; }
            get { return this.data; }
        }

        public LinkGen<T> Next
        {
            set { this.next = value; }
            get { return this.next; }
        }
    }
}
