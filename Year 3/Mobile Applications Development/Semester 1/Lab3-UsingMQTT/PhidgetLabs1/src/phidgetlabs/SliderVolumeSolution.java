package phidgetlabs;
import com.phidget22.PhidgetException;
import com.phidget22.VoltageRatioInput;
import com.phidget22.VoltageRatioInputVoltageRatioChangeEvent;
import com.phidget22.VoltageRatioInputVoltageRatioChangeListener;

public class SliderVolumeSolution {

    public static void main(String[] args) throws Exception {
    	new SliderVolumeSolution();
    }
    	
    public SliderVolumeSolution() throws Exception {
        VoltageRatioInput slider = new VoltageRatioInput();

      // This is the id of your PhidgetInterfaceKit (on back of device)
      // If you wish to make a more secure sensor access, uncomment the setDeviceSerialNumber 
      //  and replace the number with the number on the back of the interface board
      // slider.setDeviceSerialNumber(319864);

        // This is the channel your slider/sensor is connected to on the interface kit
      slider.setChannel(0); // here assume plugged into channel 0
      slider.open(5000); // wait for 5 seconds to register sensor

      // the VoltageChangeRatio listener will detect changes in the voltage ratio of the sensor
      // Voltage ratio is in the range 0-1. When a change is detected, the method is invoked
      slider.addVoltageRatioChangeListener(new VoltageRatioInputVoltageRatioChangeListener() {
    	  public void onVoltageRatioChange(VoltageRatioInputVoltageRatioChangeEvent e) {
	    		  	String message = "just right.";
	    		  	double sensorValue = e.getVoltageRatio();
	    		  	// check value of sensor and display appropriate message
	    		  	if (sensorValue > 0.7) { message = "way too loud!";}
	    		  	else if (sensorValue < 0.3) { message = "too quiet, I can hardly hear it.";}
	    		    System.out.println("The volume is "+ message);
			}
       });
      

      // Display initial value of slider voltage ratio
      double x;
        x = slider.getVoltageRatio();
      System.out.println("Start slider Voltage Ratio is "+x);
    
    
    // attach to the sensor and start reading
    // no need for any real code at the moment, the listener will detect changes and act
    // pause the loop for 15 seconds then close the slider/sensor  
    try {      
                        
        System.out.println("\n\nGathering data for 15 seconds\n\n");
        Thread.sleep(15000);

        slider.close();
        System.out.println("\nClosed slider Voltage Ratio Input");
        
    } catch (PhidgetException ex) {
        System.out.println(ex.getDescription());
    }
}

    
    
    
}