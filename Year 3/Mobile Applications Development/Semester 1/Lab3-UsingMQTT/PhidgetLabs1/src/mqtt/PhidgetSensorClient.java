package mqtt;

	import org.eclipse.paho.client.mqttv3.MqttException;

import com.phidget22.PhidgetException;
import com.phidget22.VoltageRatioInput;
import com.phidget22.VoltageRatioInputVoltageRatioChangeEvent;
import com.phidget22.VoltageRatioInputVoltageRatioChangeListener;

import mqtt.publisher.PhidgetPublisher;

	public class PhidgetSensorClient  {
	    
	    PhidgetPublisher publisher = new PhidgetPublisher(); // source in PhidgetPublisher.java
        VoltageRatioInput sensor = new VoltageRatioInput();
	    
	    public static void main(String[] args) throws PhidgetException {
	        new PhidgetSensorClient();
	    }

	    public PhidgetSensorClient() throws PhidgetException {

	        try {
	            // OPTIONAL This is the id of your PhidgetInterfaceKit (on back of device)
	            // sensor.setDeviceSerialNumber(319864);
	            // This is the channel your slider is connected to on the interface kit
	            sensor.setChannel(0);
	            sensor.open(5000);

	            sensor.addVoltageRatioChangeListener(new VoltageRatioInputVoltageRatioChangeListener() {
	      			public void onVoltageRatioChange(VoltageRatioInputVoltageRatioChangeEvent e) {
	      				double sensordata = e.getVoltageRatio();
	      				System.out.println("Sensor Voltage Ratio Changed: "+ sensordata); 
	      				// Publish the sensor data via MQTT
	      				// Code to publish is in file PhidgetPublisher.java
						try {
							publisher.publishSlider(sensordata);
						} catch (MqttException mqtte) {
							mqtte.printStackTrace();
						}						
	      			}
	             });
	            
	            
	            // Start the main code
	            double x;
	              x = sensor.getVoltageRatio();
	            System.out.println("Start sensor Voltage Ratio is "+x);

	            // attach to the sensor and start reading
	            try {      	                                
	                System.out.println("\n\nGathering data for 15 seconds\n\n");
	                Thread.sleep(15000);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        } finally {
	            sensor.close();
	            System.out.println("Closed and exiting...");
	        }
	    }



	
}
