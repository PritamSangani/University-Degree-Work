public class Controller {
    public static void main(String[] args) {

        // Check to make sure program has been called with correct number of
        // command line arguments
        if (args.length != 3) {
            System.err.println("Error: program should take exactly three command line arguments:");
            System.err.println("\t<No. of card holders> <main acct starting bal.> <backup acct. starting bal.>");
            System.exit(0);
        }
        // And then make sure that those args are all integers
        try {
            int numCards = Integer.parseInt(args[0]);
            Account account = new Account("Main", Integer.parseInt(args[1]));
            Account backup = new Account("Backup", Integer.parseInt(args[2]));
            Thread monitor = new Thread(new MonitorThread(numCards+1,account, backup));

            // Your code to create and manage the threads should go here.
            Thread[] cards = new Thread[numCards];
            //add number of cards to Array as per args[0]
            for(int i = 0; i < numCards; i++) {
                cards[i] = (new Thread(new CardHolder(i, account)));
                cards[i].start();
            }
            //start executing the MonitorThread simultaneously with other Threads (.run() would run one thread after another rather than simultaneously)
            monitor.start();
            try {
                //wait for other Threads to complete execution
                monitor.join();
                System.out.println();
                account.printStatement();
                System.out.println();
                backup.printStatement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            System.err.println("All three arguments should be integers");
            System.err.println("\t<No. of card holders> <main acct starting bal.> <backup acct. starting bal.>");
        }
    }
}