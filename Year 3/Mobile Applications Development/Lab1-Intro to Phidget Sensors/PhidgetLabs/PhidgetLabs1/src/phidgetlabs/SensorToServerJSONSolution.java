package phidgetlabs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.phidget22.*;

public class SensorToServerJSONSolution  {
    
    VoltageRatioInput slider = new VoltageRatioInput();
    int lastSensorValue = 0;

    // Declare a default sensor object (no location, name/value set later)
    SensorDataSolution oneSensor = 
    		new SensorDataSolution("unknown", "unknown", "mmuphidget");
    // Declare GSON utility object
    Gson gson = new Gson();
    // Declare String to hold json representation of sensor object data
    String oneSensorJson = new String();
    // address of server which will receive sensor data
    // Altered to point to server to deal with incoming json parameters
    public static String sensorServerURL = "http://localhost:8080/PhidgetServer/SensorServerJsonSolution";
 
    public static void main(String[] args) throws PhidgetException {

        new SensorToServerJSONSolution();
    }

    public SensorToServerJSONSolution() throws PhidgetException {
    	
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
  					
  					// Place sensor values inside sensor object
  					oneSensor.setSensorname("slider");
  					oneSensor.setSensorvalue(strSensorReading);
  					oneSensorJson = gson.toJson(oneSensor);
  					
  					sendToServer(oneSensorJson);
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

    public String sendToServer(String oneSensorJson){
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        // Replace invalid URL characters from json string
        try {
			oneSensorJson = URLEncoder.encode(oneSensorJson, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
        String fullURL = sensorServerURL + "?sensordata="+oneSensorJson;
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