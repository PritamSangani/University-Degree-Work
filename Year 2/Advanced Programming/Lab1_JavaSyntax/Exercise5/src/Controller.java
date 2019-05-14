/**
 * Created by Pritam Sangani on 26/09/2017.
 */

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float balance;
        float newBalance = 0f;

        final float S_INTEREST = 3f;
        final float D_INTEREST = 0.5f;
        final float C_INTEREST = 1.5f;
        final float L_INTEREST = 4f;

        char accountType;

        System.out.print("Please enter a balance amount > ");
        balance = sc.nextFloat();
        System.out.print("Please enter an account type (S = Saver, D = Deposit, C = Child, L = Long) > ");
        accountType = sc.next().charAt(0);

        switch (accountType) {
            case 'S':
            case 's': {
                newBalance = balance * (1 + (S_INTEREST / 100));
            }
            break;
            case 'D':
            case 'd': {
                newBalance = balance * (1 + (D_INTEREST / 100));
            }
            break;
            case 'C':
            case 'c': {
                newBalance = balance * (1 + (C_INTEREST / 100));
            }
            break;
            case 'L':
            case 'l': {
                newBalance = balance * (1 + (L_INTEREST / 100));
            }
            break;
        }
        System.out.println("Value after 1 year > " + newBalance);
    }
}
