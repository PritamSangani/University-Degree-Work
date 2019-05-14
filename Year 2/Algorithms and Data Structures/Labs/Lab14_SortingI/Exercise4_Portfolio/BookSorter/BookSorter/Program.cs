using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookSorter
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] array1 = { "Fred", "Zoe", "Angela", "Umbrella", "Ben" };
            string[] titles = {"Writing Solid Code",
                "Objects First","Programming Gems",
                "Head First Java","The C Programming Language",
                "Mythical Man Month","The Art of Programming",
                "Coding Complete","Design Patterns",
                "Problem Solving in Java"};
            string[] authors = { "Maguire", "Kolling", "Bentley", "Sierra", "Richie", "Brooks", "Knuth", "McConnal", "Gamma", "Weiss" };
            string[] isbns = { "948343", "849328493", "38948932", "394834342", "983492389", "84928334", "4839455", "21331322", "348923948", "43893284", "9483294", "9823943" };

            Book[] library = new Book[10];

            for (int i = 0; i < library.Length; i++)
            {
                library[i] = new Book(isbns[i], titles[i], authors[i]);
            }


            SelectionSort(library);
            Console.WriteLine(IsInOrder<Book>(library));

            foreach (Book book in library)
            {
                Console.WriteLine(" {0} ", book);
            }
            Console.WriteLine();
            Console.ReadKey();

        }

        static void swap<T>(ref T x, ref T y)
        {
            //swapcount++;
            T temp = x;
            x = y;
            y = temp;
        }


        static void printArray(int[] a)
        {
            for (int i = 0; i < a.Length; i++)
            {
                Console.Write(a[i] + ",");
            }
            Console.WriteLine();
        }

        static bool IsInOrder<T>(T[] a) where T : IComparable<T>
        {
            for (int i = 0; i < a.Length - 1; i++)
            {
                if (a[i].CompareTo(a[i + 1]) > 0)
                    return false;
            }
            return true;
        }

        public static void SelectionSort<T>(T[] a) where T : IComparable<T>
        {
            for(int i = 0; i < a.Length-1; i++)
            {
                int smallest = i;
                for (int j = i + 1; j < a.Length; j++)
                {
                    
                    if (a[j].CompareTo(a[smallest]) < 0)
                        smallest = j;
                }
                swap(ref a[i], ref a[smallest]);
            }
        }
    }
}
