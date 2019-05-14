using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library3
{
    class Program
    {
        static void Main(string[] args)
        {
            //declare an array of Book
            Book[] books = new Book[5];

            books[0] = new Book("Moby Dick");
            books[0].Author = new Person("Herman Melville");
            books[1] = new Horror("The Creeping");
            books[1].Author = new Person("Alexandra Sirowy");
            books[2] = new Horror("It");
            books[3] = new Childrens("The Recruit");
            books[3].Author = new Person("Robert Muchamore");
            books[4] = new Mystery("Death on the Nile");
            books[4].Author = new Person("Agatha Christie");

            for (int i = 0; i < books.Length; i++)
            {
                Console.WriteLine(books[i].GetSummary());
            }
            Console.ReadKey();
        }
    }
}
