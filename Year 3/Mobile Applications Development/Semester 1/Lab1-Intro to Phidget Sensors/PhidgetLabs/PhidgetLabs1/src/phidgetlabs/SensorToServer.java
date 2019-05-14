package phidgetlabs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.phidget22.*;

public class SensorToServer  {
    
    VoltageRatioInput slider = new VoltageRatioInput();
    int lastSensorValue = 0;

    // address of server which will receive sensor data
    public static String sensorServerURL = "http://localhost:8080/PhidgetServer/SensorServerDB";
     public static void main(String[] args) throws PhidgetException {

        new SensorToServer();
    }

    public SensorToServer() throws PhidgetException {
    	
        // This is the id of your PhidgetInterfaceKit (on back of device)
        // slider.setDeviceSerialNumber(319864);
        // This is the channel your slider is connected to on the interface kit
        slider.setChannel(0);
        slider.open(5000);

        slider.addVoltageRatioChangeListener(new VoltageRatioInputVoltageRatioChangeListener() {
  			public void onVoltageRatioChange(VoltageRatioInputVoltageRatioChangeEvent e) {
  				double sensorReading = e.getVoltageRatio();
  				//System.out.println("Slider Voltage Ratio Changed: "+ sensorReading);
  				
  				// scale the sensor value from 0-1 to 0-1000
  				int scaledSensorReading = (int) (1000 * sensorReading);
  				// send value to server if changed since last reading
  				if (scaledSensorReading != lastSensorValue ) {
  					System.out.println("Sending new sensor value : " + scaledSensorReading);
  					// Change sensor value to String and send to server
  					String strSensorReading = "" + scaledSensorReading;
  					sendToServer(strSensorReading);
  					lastSensorValue = scaledSensorReading;
  				}
  			}
         });
 
         // attach to the sensor and start reading
        try {      
                            
            System.out.println("\n\nGathering data for 15 seconds\n\n");
            pause(15);
            slider.close();
            System.out.println("\nClosed slider Voltage Ratio Input");
            
        } catch (PhidgetException ex) {
            System.out.println(ex.getDescription());
        }

    }

    public String sendToServer(String sensorValue){
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String fullURL = sensorServerURL + "?sensorname=slider&sensorvalue="+sensorValue;
        System.out.println("Sending data to: "+fullURL);  // DEBUG confirmation message
        String line;
        String result = "";
        try {
           url = new URL(fullURL);
           conn = (HttpURLConnection) url.openConnection();
           conn.setRequestMethod("GET");
           rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           // Request response from server to enable URL to be opened
           while ((line = rd.readLine()) != null) {
              result += line;
           }
           rd.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return result;    	
    }
    
	private void pause(int secs){
        try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}