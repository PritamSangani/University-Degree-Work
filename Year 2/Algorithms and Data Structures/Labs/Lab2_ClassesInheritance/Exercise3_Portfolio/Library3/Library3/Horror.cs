using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library3
{
    class Horror : Book
    {
        public Horror(string title) : base(title)
        {
            base.Author = new Person("Stephen King");
        }
    }
}
