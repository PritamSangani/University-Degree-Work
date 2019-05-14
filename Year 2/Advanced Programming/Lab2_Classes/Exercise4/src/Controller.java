/**
 * Created by Pritam Sangani on 03/10/2017.
 */
public class Controller {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.deposit(100);
        System.out.println("Balance: "+account.getBalance());
        account.withdraw(500);
        System.out.println("Balance: "+account.getBalance());

    }
}
