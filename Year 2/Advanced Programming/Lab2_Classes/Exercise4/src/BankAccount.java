/**
 * Created by Pritam Sangani on 03/10/2017.
 */

public class BankAccount {
    private float balance;

    BankAccount() {

    }

    BankAccount(double balance) {
        this.balance = (float)balance;
    }

    void deposit(double depositAmount) {
        balance = balance + (float)depositAmount;
    }

    void withdraw(double withdrawAmount) {
        balance = balance - (float)withdrawAmount;
    }

    double getBalance() {
        return balance;
    }


}
