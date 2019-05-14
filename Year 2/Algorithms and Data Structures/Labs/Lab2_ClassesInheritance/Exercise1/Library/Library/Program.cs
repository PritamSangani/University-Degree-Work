using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library
{
    class Program
    {
        static void Main(string[] args)
        {
            //declare an array of Book
            Book[] books = new Book[3];

            books[0] = new Book("Moby Dick");
            books[0].Author = new Person("Herman Melville");
            books[1] = new Horror("The Creeping");
            books[1].Author = new Person("Alexandra Sirowy");
            books[2] = new Horror("It");

            for (int i = 0; i < books.Length; i++)
            {
                Console.WriteLine("{0} {1}", books[i].Author.Name, books[i].Title);
            }
            Console.ReadKey();


        }
    }
}
