/**
 * Created by Pritam Sangani on 26/09/2017.
 */

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        float balance=0.0f;
        float withdraw =0.0f;
        float deposit =0.0f;
        System.out.println("Please enter the bank balance");
        Scanner aScanner = new Scanner(System.in);
        balance =aScanner.nextFloat();
        System.out.println("Balance = "+balance);
        String commandStr="";
        do
        {
            System.out.println("Enter q=quit, w=withdraw, d=deposit");
            commandStr=aScanner.next();
            if(commandStr.equals("w"))
            {
                //withdrawn money
                System.out.println("Enter amount to withdraw");
                withdraw=aScanner.nextFloat();
                balance=balance-withdraw;
            }
            else if(commandStr.equals("d"))
            {
                //deposit money
                System.out.println("Enter amount to deposit");
                deposit =aScanner.nextFloat();
                balance=balance+deposit;
            }
            System.out.println("New balance = "+balance) ;
        }while(!commandStr.equals("q"));
    }

}
