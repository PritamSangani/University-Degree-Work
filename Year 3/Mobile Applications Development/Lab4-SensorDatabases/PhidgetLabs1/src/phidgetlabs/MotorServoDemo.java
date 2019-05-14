package phidgetlabs;
import com.phidget22.*;

public class MotorServoDemo {

	static RCServo ch;
 
	public static void main(String[] args) throws Exception {
         
        ch = new RCServo();

        // Following listeners/actions are optional, just a demo
        
        // Listener and action to do whenever the speed of the motor changes
        ch.addVelocityChangeListener(new RCServoVelocityChangeListener() {
			public void onVelocityChange(RCServoVelocityChangeEvent e) {
				System.out.println("Velocity Changed: "+ e.getVelocity());
			}
        });
        
        // Listener and action to do whenever the motor position changes
        ch.addPositionChangeListener(new RCServoPositionChangeListener() {
			public void onPositionChange(RCServoPositionChangeEvent e) {
				System.out.println("Position Changed: "+ e.getPosition());
			}
        });

        // Listener and action to do when the motor reaches target position
        ch.addTargetPositionReachedListener(new RCServoTargetPositionReachedListener() {
			public void onTargetPositionReached(RCServoTargetPositionReachedEvent e) {
				System.out.println("Target Position Reached: "+ e.getPosition());
			}
        });
        
        try {
             /*
            * Please review the Phidget22 channel matching documentation for details on the device
            * and class architecture of Phidget22, and how channels are matched to device features.
            */

        		// Find an attached motor
        		System.out.println("Opening and waiting 5 seconds for attachment...");
            ch.open(5000);

            // move motor to position 90 (range is approx 0-220)
            System.out.println("Setting target position to 90");
            ch.setTargetPosition(90.0);
            // Now position is set, engage the motor to actually move it
            System.out.println("Setting engaged");
            ch.setEngaged(true);
                
            System.out.println("\n\nSetting target position to 180 for 5 seconds\n\n");
            ch.setTargetPosition(180);
            // wait to allow motor to actually move, else will just go
            // to next instruction which moves it again before previous move finished
            Thread.sleep(5000);
            
            System.out.println("\n\nSetting target position to 0 for 5 seconds\n\n");
            ch.setTargetPosition(0);
            Thread.sleep(5000);
            
            System.out.println("\n\nSetting target position to 90 for 5 seconds\n\n");
            ch.setTargetPosition(90);
            Thread.sleep(5000);

            ch.close();
            System.out.println("\nClosed Motor Servo");
            
        } catch (PhidgetException ex) {
            System.out.println(ex.getDescription());
        }
    }
}