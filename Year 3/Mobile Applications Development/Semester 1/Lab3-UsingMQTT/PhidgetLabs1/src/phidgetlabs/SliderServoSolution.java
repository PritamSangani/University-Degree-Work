package phidgetlabs;
import com.phidget22.PhidgetException;
import com.phidget22.RCServo;
import com.phidget22.RCServoPositionChangeEvent;
import com.phidget22.RCServoPositionChangeListener;
import com.phidget22.RCServoTargetPositionReachedEvent;
import com.phidget22.RCServoTargetPositionReachedListener;
import com.phidget22.RCServoVelocityChangeEvent;
import com.phidget22.RCServoVelocityChangeListener;
import com.phidget22.VoltageRatioInput;
import com.phidget22.VoltageRatioInputVoltageRatioChangeEvent;
import com.phidget22.VoltageRatioInputVoltageRatioChangeListener;

public class SliderServoSolution {

	RCServo servo = new RCServo();;

    public static void main(String[] args) throws Exception {
    	new SliderServoSolution();
    }
    	
    public SliderServoSolution() throws Exception {
        VoltageRatioInput slider = new VoltageRatioInput();

        System.out.println("Opening and waiting 5 seconds for servo attachment...");
        servo.open(5000);
        servo.setTargetPosition(0);;
        servo.setEngaged(true);
  
        
      // This is the id of your PhidgetInterfaceKit (on back of device)
      // slider.setDeviceSerialNumber(319864);
      // This is the channel your slider is connected to on the interface kit
      slider.setChannel(3);
      slider.open(5000);

      slider.addVoltageRatioChangeListener(new VoltageRatioInputVoltageRatioChangeListener() {
			public void onVoltageRatioChange(VoltageRatioInputVoltageRatioChangeEvent e) {
				// System.out.println("Slider Voltage Ratio Changed: "+ e.getVoltageRatio());
				try {
					// scale sensor value from 0-1 to 0-180
					servo.setTargetPosition(e.getVoltageRatio()*180.0);
				} catch (PhidgetException e1) {
					e1.printStackTrace();
				}
			}
       });
     	servo.addVelocityChangeListener(new RCServoVelocityChangeListener() {
  			public void onVelocityChange(RCServoVelocityChangeEvent e) {
  				// System.out.println("Velocity Changed: "+ e.getVelocity());
  			}
          });
          
          servo.addPositionChangeListener(new RCServoPositionChangeListener() {
  			public void onPositionChange(RCServoPositionChangeEvent e) {
  				// System.out.println("Position Changed: "+ e.getPosition());
  			}
          });
          
          servo.addTargetPositionReachedListener(new RCServoTargetPositionReachedListener() {
  			public void onTargetPositionReached(RCServoTargetPositionReachedEvent e) {
  				System.out.println("Target Position Reached: "+ e.getPosition());
  			}
          });
    
      double x;
        x = slider.getVoltageRatio();
      System.out.println("Start slider Voltage Ratio is "+x);
    
    
    // attach to the sensor and start reading
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