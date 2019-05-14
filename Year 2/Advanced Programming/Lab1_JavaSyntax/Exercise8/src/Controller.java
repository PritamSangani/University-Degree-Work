/**
 * Created by Pritam Sangani on 26/09/2017.
 */

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float temp;
        float conTemp;
        char unit;

        System.out.print("Are you entering in a temperature in Celsius or Fahrenheit [C/F] > ");
        unit = sc.next().charAt(0);
        System.out.println(" ");
        System.out.print("OK. Enter in a temperature > ");
        temp = sc.nextFloat();

        switch (unit) {
            case 'C': {
                conTemp = (9/5f) * temp + 32;
                System.out.println(temp + "C " + "is equivalent to " + conTemp + "F");
            }
            break;
            case 'F': {
                conTemp = (5/9f) * (temp - 32);
                System.out.println(temp + "F " + "is equivalent to " + conTemp + "C");
            }
            break;
        }

    }
}
