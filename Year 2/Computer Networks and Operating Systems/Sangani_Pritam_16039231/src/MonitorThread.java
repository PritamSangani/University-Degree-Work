/**
 * MonitorThread class - special Thread class which runs alongside CardHolder class Threads
 * Checks the status of the backup and main account each time it loops making sure there is enough money in each and that the balance doesn't go above a threshold.
 * @author Pritam Sangani
 * @version 1.0
 * @see java.lang.Runnable
 */
public class MonitorThread implements Runnable {

    private Account main;
    private Account backup;
    int id = 0;

    /**
     * Constructor - creates an instance of a MonitorThread
     * @param id = id of Thread
     * @param main = the main Account
     * @param backup = the secondary Account
     */
    MonitorThread(int id, Account main, Account backup) {
        this.id = id;
        this.main = main;
        this.backup = backup;
    }

    @Override
    /**
     * Contains the code which is executed when the Thread runs.
     */
    public void run() {
        //while only main, MonitorThread and garbage collecting Thread are running
        while (Thread.activeCount() > 3) {
            main.backup(id, backup);
            try {
                //wait for 300ms before continuing execution
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
