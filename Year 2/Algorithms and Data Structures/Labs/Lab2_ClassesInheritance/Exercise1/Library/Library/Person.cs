using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library
{
    class Person : IComparable
    {
        private int age;
        private string name;

        public Person ()
        {
            age = 18;
        }
        //constructor with one argument
        public Person (string name)
        {
            this.name = name;
            age = 18; //this is the default age
        }

        //Property for name
        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        //Property for age
        public int Age
        {
            get { return age; }
            set { age = value; }
        }

        public int CompareTo (Object obj) //implementation of CompareTo for IComparable
        {
            Person other = (Person)obj;
            return Name.CompareTo(other.Name);
        }

    }
}
