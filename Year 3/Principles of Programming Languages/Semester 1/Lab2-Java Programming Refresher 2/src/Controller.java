import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Pritam Sangani on 02/10/2018.
 */
public class Controller {
    public static void main(String[] args) {
        /* Ex. 1a - for to enhanced for loop - Display(int[a]) method */
        int[] intary = { 1, 2, 3, 4 };
        Display(intary);

        System.out.println();

        /* Ex. 1b - Display elements of Linked List */
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("duck", "goose", "swan", "chicken", "turkey"));
        DisplayLinkedList(animals);

        System.out.println();

        /* Ex. 2 - Complete program to print out arrays */
        Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("Array integerArray Contains: ");
        printArray(integerArray);

        System.out.println("\nArray doubleArray Contains: ");
        printArray(doubleArray);

        System.out.println("\nArray characterArray Contains: ");
        printArray(characterArray);

        System.out.println();

        /* Ex. 3 - Complete Program to calculate areas of shapes */
        ArrayList<Figure> figList = new ArrayList<Figure>();
        figList.add(new Rectangle(3.0, 4.0));
        figList.add(new Circle(2.0));
        figList.add(new Triangle(2.5, 4.0));
        figList.add(new Rectangle(3.0, 4.0));
        figList.add(new Rectangle(3.0, 4.0));
        figList.add(new Triangle(3.0, 4.0));
        figList.add(new Circle(4.2));
        figList.add(new Circle(1.0));

        for (Figure f : figList) {
            System.out.println("This is a " + f.name + " with area = " + f.Area());
        }
    }
    
    public static void Display(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void DisplayLinkedList(LinkedList<String> linkedList) {
        for (String animal : linkedList) {
            System.out.print(animal + " ");
        }
    }

    public static <E> void printArray(E[] genArray) {
        for (E element : genArray) {
            System.out.print(element + " ");
        }
    }
}
