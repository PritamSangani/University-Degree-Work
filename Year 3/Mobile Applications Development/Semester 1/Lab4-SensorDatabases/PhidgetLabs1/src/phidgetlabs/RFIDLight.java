package phidgetlabs;
import com.phidget22.*;


public class RFIDLight {

   	RFID phid = new RFID();
    DigitalOutput digOut  = new DigitalOutput();
    
	public static void main(String[] args) throws PhidgetException {
        new RFIDLight();
    }

    public RFIDLight() throws PhidgetException {

    	// set the DigitalOutput channel (0 or 1 on RFID board)
    	digOut.setChannel(1);
    	// open for writing
    	digOut.open(2000);

    		
    	// Make the RFID Phidget able to detect loss or gain of an rfid card
        phid.addTagListener(new RFIDTagListener() {
			public void onTag(RFIDTagEvent e) {
				   String tagStr = e.getTag();
					System.out.println("Tag read: " + tagStr);
					
					// replace value here with your tag id to be recognised
				    if (tagStr.equals("mytagstring")) 
				    		 { turnOnLight(true); } // Method defined later in code
				    else 
				    		 { turnOnLight(false); }

			}
        });

        phid.addTagLostListener(new RFIDTagLostListener() {
			public void onTagLost(RFIDTagLostEvent e) {
				System.out.println("Tag lost: " + e.getTag());
				turnOnLight(false);
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


private void turnOnLight(boolean lightState){
	// method to set state of digital out for light to on or off
	if (lightState==true) {

        try {
        	System.out.println("LIGHT ON");
        	digOut.setState(true);
			
		} catch (PhidgetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else {
        try {
        	System.out.println("LIGHT OFF");
        	digOut.setState(false);

        } catch (PhidgetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


}


