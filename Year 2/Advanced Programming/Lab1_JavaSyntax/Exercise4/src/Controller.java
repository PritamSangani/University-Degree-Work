/**
 * Created by Pritam Sangani on 26/09/2017.
 */

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, sum, bigNum;
        sum = 0;
        bigNum = 0;
        System.out.print("Enter a num to add to the final sum (-9999 terminates) > ");
        num = sc.nextInt();
        while (num!= -9999) {
            if(num >= 1 && num <= 100) {
                sum += num;
                if (num > bigNum) {
                    bigNum = num;
                }
            }
            else {
                System.out.println("That is an invalid number. Please enter a number between 1 and 100.");
            }

            System.out.print("Enter a num to add to the final sum (-9999 terminates) > ");
            num = sc.nextInt();
        }
        System.out.println("The final sum is " + sum);
        System.out.println("The biggest number entered is " + bigNum);
    }
}
