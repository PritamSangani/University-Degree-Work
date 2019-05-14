/**
 * Created by Pritam Sangani on 26/09/2017.
 */

public class Controller {
    public static void main(String[] args) {
        int arry[] = new int[6];
        for (int i = 0; i < 6; i++) {
            arry[i] = i + 1;
        }
        System.out.println("Number at index 1 in array is " + arry[1]);

        for (int element: arry) {
            System.out.println(element);
            System.out.println(" ");
        }

        for (int i = 0; i < arry.length; i++) {
            arry[i] = i * 2;
        }

        for (int element: arry) {
            System.out.println(element);
        }
    }
}
