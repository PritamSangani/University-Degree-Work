using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library2
{
    class Book : IComparable
    {
        private string title;
        private Person author;
        //Constructor
        public Book(string title)
        {
            this.title = title;
            author = new Person();
        }
        public Book(string title, string authorName)
        {
            this.title = title;
            author = new Person(authorName);
        }
        //Property for title
        public string Title
        {
            get { return title; }
            set { title = value; }
        }
        //Property for author
        public Person Author
        {
            get { return author; }
            set { author = value; }
        }
        //implementation of CompareTo for IComparable
        public int CompareTo(Object obj)
        {
            Book other = (Book)obj;
            return Title.CompareTo(other.Title);
        }

        //method to return title, author and author's age
        public String GetSummary()
        {
            return Title + " is written by " + Author.Name + " who is " + Author.Age + " years old.";
        }
    }
}
