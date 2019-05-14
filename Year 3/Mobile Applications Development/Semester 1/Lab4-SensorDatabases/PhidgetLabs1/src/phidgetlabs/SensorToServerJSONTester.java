package phidgetlabs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;

public class SensorToServerJSONTester  {
    
    int lastSensorValue = 0;

    // Declare a default sensor object (no location, name/value set later)
    // This will only work when you have SensorData class developed
    // and a SensorServer developed that accepts json strings, as in the lab
    SensorDataSolution oneSensor = 
    		new SensorDataSolution("TestSensor", "444", "mmuphidget");
    // Declare GSON utility object
    Gson gson = new Gson();
    // Declare String to hold json representation of sensor object data
    String oneSensorJson = new String();
    // address of server which will receive sensor data
    // Altered to point to server to deal with incoming json parameters
    public static String sensorServerURL = "http://localhost:8080/PhidgetServer/SensorServer";
 
    public static void main(String[] args) {

        new SensorToServerJSONTester();
    }

    public SensorToServerJSONTester() {
    	
			oneSensorJson = gson.toJson(oneSensor);
				
			sendToServer(oneSensorJson);


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
    

}