/**
 * Created by Pritam Sangani on 26/09/2017.
 */

import java.util.Random;

public class Controller {
    public static void main(String[] args) {
        Random rand = new Random();
        int [] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        for (int element: array) {
            System.out.print(element + " ");
        }
        bubbleSort(array);
        System.out.println(" ");
        for (int element: array) {
            System.out.print(element + " ");
        }
    }

    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < (a.length - i); j++) {
                if (a[j-1] > a[j]) {
                    swap(a, j-1, j);
                }
            }
        }
    }

    private static void swap(int[] a, int x, int y) {
        int tempStore = a[x];
        a[x] = a[y];
        a[y] = tempStore;
    }
}
