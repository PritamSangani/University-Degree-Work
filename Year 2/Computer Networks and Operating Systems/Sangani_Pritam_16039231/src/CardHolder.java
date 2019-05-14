/**
 * CardHolder class - implements each card as a Thread which allows simultaneous withdrawals and deposits using multiple cards, whilst effectively eliminating the risk of card fraud.
 * @author Pritam Sangani
 * @version 1.0
 * @see java.lang.Runnable
 */
public class CardHolder implements Runnable {
	private int id;
	private Account account;
	final static int numIterations = 20;
	private int totalWithdrawn = 0;
	private int totalDeposit = 0;
	private int netTransactions = 0;
	
	public CardHolder(int id, Account account) {
		this.id = id;
		this.account = account;
	}
	
	/**
	 * run method is what is executed when you start a Thread that
	 * is initialised with an instance of this class.
	 * You will need to add code to keep track of local balance (cash
	 * in hand) and report this when the thread completes.
	 */
	public void run() {
		for (int i = 0; i < numIterations; i++) {
			// Generate a random amount from 1-10
			int amount = (int)(Math.random()*10)+1;
			// Then with 50/50 chance, either deposit or withdraw it
			if (Math.random() > 0.5) {
				account.withdraw(id, amount);
				totalWithdrawn+=amount;
			} else {
				account.deposit(id, amount);
				totalDeposit+=amount;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			netTransactions = totalWithdrawn - totalDeposit;
		}
		System.out.println("THREAD " + id + " net transactions ===> "+netTransactions);
		System.out.println("THREAD "+ id + " finished");
	}
}
