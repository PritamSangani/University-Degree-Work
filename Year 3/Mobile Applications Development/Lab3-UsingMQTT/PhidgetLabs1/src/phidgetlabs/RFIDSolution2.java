package phidgetlabs;

import java.util.ArrayList;
import java.util.Arrays;

import com.phidget22.*;


public class RFIDSolution2 {
	// Create a list of tag items that are recognised	
	final String[] tagItemsArray = {"1600ee1bd9","tagid2","tagid3", "so low", "test tag", "dummy data"};
	ArrayList tagItemsList = new ArrayList<String>(Arrays.asList(tagItemsArray));

	public static void main(String[] args) throws PhidgetException {
        new RFIDSolution2();
    }

    public RFIDSolution2() throws PhidgetException {

		RFID phid = new RFID();
    	// Make the RFID Phidget able to detect loss or gain of an rfid card
        phid.addTagListener(new RFIDTagListener() {
			public void onTag(RFIDTagEvent e) {
				String tagStr = e.getTag();
				System.out.println("Tag read: " + tagStr);
		        // See if this tag number is in the known tag list
		        if (tagItemsList.contains(tagStr)) { 
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