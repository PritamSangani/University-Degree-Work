/**
 * Account class - contains methods to deposit and withdraw money, check the backup and print the transactions statement
 * The constructor takes in 2 parameters - name and startingBalance
 * @author Pritam Sangani
 * @version 1.0
 */

import java.util.ArrayList;

public class Account {
	private String name;
	private String transaction = "";
	private int startBalance;
	private int balance;
	private ArrayList<String> transactions = new ArrayList<>();

	/**
	 * Constructor to create an instance of an Account
	 * @param name = the name of the Account, e.g. main
	 * @param startingBalance = the initial balance of the Account
	 */
	// Create an account - initalisation goes in here
	public Account(String name, int startingBalance) {
		this.name = name;
		this.startBalance = startingBalance;
		this.balance = startBalance;
	}

	/**
	 * Method to deposit money into an Account
	 * @param id = the id of the Thread in which the Account is running on
	 * @param amount = amount of money to be deposited into the Account
	 */
	// Deposit <amount> into the account
	public synchronized void deposit(int id, int amount) {
		balance+=amount;
		//release lock on object
		notify();
		transaction = String.format("%s%19s%9s", "("+id+")",amount,balance);
		transactions.add(transaction);
	}

	/**
	 * Method to withdraw money from an Account
	 * @param id = the id of the Thread in which the Account is running on
	 * @param amount = amount of money to be withdrawn from the Account
	 */
	// Withdraw <amount> from the account
	public synchronized void withdraw(int id, int amount) {

		while (balance < amount) {
			try {
				//when the balance of the account is less than the requested withdraw amount
				//wait for another thread to call notify
				//will wait() again if a deposit that increases balance to the amount wanted to be withdrawn is not made
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance-=amount;
		transaction = String.format("%s%11s%17s", "("+id+")",amount,balance);
		transactions.add(transaction);
	}

	/**
	 * Method that checks balances of the main and backup Account and transfers money between both accounts accordingly.
	 * @param id = the id of the Thread in which the Account is running on
	 * @param backup = the secondary bank Account
	 */
	//synchronised method so it doesn't lead to a race condition
	public synchronized void backup(int id, Account backup) {
		final int max_threshold = startBalance;
		final int min_threshold = 10;

		if (balance < min_threshold && backup.balance > min_threshold) {
			int maxtransferAmount = max_threshold - balance;
			int transferAmount =  backup.balance;

			if (transferAmount < maxtransferAmount) {
				backup.withdraw(id,transferAmount);
				deposit(id,transferAmount);
			}
			else {
				backup.withdraw(id, maxtransferAmount);
				deposit(id, maxtransferAmount);
			}

		}
		else if (balance > max_threshold) {
			int transferAmount = balance - max_threshold;

			withdraw(id, transferAmount);
			backup.deposit(id, transferAmount);
		}
	}

	/**
	 * Method to print the statement of transactions from each Account
	 * Statement contains information about the transaction number (and which thread it ran on - using id), amount withdrawn or deposited and the current Balance.
	 */
	// Print out the statement of transactions
	public void printStatement() {
		System.out.println("Account \"" + name + "\":");
		if(transactions.size() > 0) {
			int count = 1;
			System.out.println("Transaction" + " " + "Withdrawal" + " " + "Deposit" + "  " + "Balance");
			for (String transaction : transactions) {
				System.out.printf("%8s%s", count, transaction);
				System.out.println();
				count++;
			}
		}
		else {
			System.out.println("No transactions made");
		}
	}
}
