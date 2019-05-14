using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GenQuickSort
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] strings = {"apple", "zebra", "cat", "able", "jobs", "java", "computer", "dog" };
            int[] numbers = {100, 24, 55, 99, 1, 9, 987, 10, 24, 55, 66};

            Console.WriteLine("QuickSorting String Array ---------------------------------->");
            printArray(strings);
            QuickSort(strings, 0, strings.Length-1);
            printArray(strings);

            Console.WriteLine("QuickSorting Integer Array ---------------------------------->");
            printArray(numbers);
            QuickSort(numbers, 0, numbers.Length - 1);
            printArray(numbers);

            Console.ReadLine();
        }

        static void QuickSort<T>(T[] items, int left, int right) where T : IComparable<T>
        {
            int i, j;
            i = left; j = right;
            T pivot = items[left];

            while (i <= j)
            {
                for (; (items[i].CompareTo(pivot) < 0) && (i < right); i++) ;
                for (; (pivot.CompareTo(items[j]) < 0) && (j > left); j--) ;

                if (i <= j)
                    swap(ref items[i++], ref items[j--]);
            }

            if (left < j)
                QuickSort(items, left, j);
            if (i < right)
                QuickSort(items, i, right);

        }

        static void swap<T>(ref T x, ref T y)
        {
            T temp = x;
            x = y;
            y = temp;
        }

        static void printArray<T>(T[] a)
        {
            for(int i = 0; i < a.Length; i++)
            {
                Console.Write(a[i] + " ");
            }
            Console.WriteLine();
        }
    }
}
