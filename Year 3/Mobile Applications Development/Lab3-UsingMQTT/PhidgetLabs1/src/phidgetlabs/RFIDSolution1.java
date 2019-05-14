package phidgetlabs;
import com.phidget22.*;


public class RFIDSolution1 {

    public static void main(String[] args) throws PhidgetException {
        new RFIDSolution1();
    }

    public RFIDSolution1() throws PhidgetException {

    		RFID phid = new RFID();
        	// Make the RFID Phidget able to detect loss or gain of an rfid card
            phid.addTagListener(new RFIDTagListener() {
    			public void onTag(RFIDTagEvent e) {
    				String tagStr = e.getTag();
    				System.out.println("Tag read: " + tagStr);
    		        if (tagStr.equals("1600ee1bd9")) {  // insert your known tag id here
    		        		System.out.println("HELLO AND WELCOME MY FRIEND!" ); 
    		        }
    		        else { 
    		        		System.out.println("UNKNOWN TAG. PLEASE GO AWAY."); 
    		        }      

    			}
            });

            phid.addTagLostListener(new RFIDTagLostListener() {
    			public void onTagLost(RFIDTagLostEvent e) {
    				String tagStr = e.getTag();
    				System.out.println("Tag lost: " + tagStr);
    			}
            });
            // Open and start detecting rfid cards
            phid.open(5000);  // wait 5 seconds for device to respond

            // Display info on currently connected devices
            System.out.println("Device Name " + phid.getDeviceName());
            System.out.println("Serial Number " + phid.getDeviceSerialNumber());
            System.out.println("Device Version " + phid.getDeviceVersion());


            phid.setAntennaEnabled(true);

            
            System.out.println("\n\nGathering data for 15 seconds\n\n");
            try {
    			Thread.sleep(15000);
    		} catch (InterruptedException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}

            phid.close();
            System.out.println("\nClosed RFID");
     
    }

}