using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BubbleSelectionSort
{
    class Program
    {
        static void Main(string[] args)
        {
            int arrsize = 20;
            int[] arr1 = new int[arrsize];
            int[] arr2 = new int[arrsize];
            Random rnd = new Random();

            for (int i = 0; i < arrsize; i++)
            {
                int num = rnd.Next(1, 100);
                arr1[i] = num;
                arr2[i] = num;
            }

            BubbleSort(arr1);
            SelectionSort(arr2);
            Console.WriteLine(InOrder(arr1));
            Console.WriteLine(InOrder(arr2));
            Console.ReadLine();
        }

        public static Boolean InOrder(int[] arr)
        {
            for (int i = 0; i < arr.Length - 1; i++)
            {
                if (arr[i] > arr[i + 1])
                    return false;
            }
            return true;
        }

        public static void swap(ref int x, ref int y)
        {
            int temp = x;
            x = y;
            y = temp;
        }

        public static void BubbleSort(int[] array)
        {
            bool swapped = true;
            int upper = array.Length - 1;
            while (swapped)
            {
                swapped = false;
                for (int i = 0; i < upper; i++)
                {
                    if (array[i] > array[i + 1])
                    {
                        swap(ref array[i], ref array[i + 1]);
                        swapped = true;
                    }   
                }  
                --upper;
            }  
        }

        public static void SelectionSort(int[] array)
        {
            for (int i = 0; i < array.Length - 1; i++)
            {
                int smallest = i;
                for (int j = i + 1; j < array.Length; j++)
                {
                    if (array[j] < array[smallest])
                        smallest = j;
                }
                swap(ref array[i], ref array[smallest]);
            }

        }
    }
}
