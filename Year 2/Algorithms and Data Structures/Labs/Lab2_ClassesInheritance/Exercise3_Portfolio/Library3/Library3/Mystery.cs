using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library3
{
    class Mystery : Book
    {
        public Mystery(string title) : base(title)
        {
            base.Author = new Person("Agatha Christie");
        }
    }
}
