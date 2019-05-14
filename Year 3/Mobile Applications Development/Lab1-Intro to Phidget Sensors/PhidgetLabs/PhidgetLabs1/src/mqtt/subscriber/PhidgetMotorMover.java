package mqtt.subscriber;



import com.phidget22.PhidgetException;
import com.phidget22.RCServo;
import com.phidget22.RCServoPositionChangeEvent;
import com.phidget22.RCServoPositionChangeListener;
import com.phidget22.RCServoTargetPositionReachedEvent;
import com.phidget22.RCServoTargetPositionReachedListener;
import com.phidget22.RCServoVelocityChangeEvent;
import com.phidget22.RCServoVelocityChangeListener;

import mqtt.utils.Utils;

public class PhidgetMotorMover {
	// Singleton implementation to allow multiple callbacks to the code
	static RCServo servo = null;
	private static PhidgetMotorMover instance = null;

	   public static RCServo getInstance() {
		  System.out.println("In singleton constructor");
	      if(servo == null) {
	         servo = PhidgetMotorMover();
	      }
	      return servo;
	   }
	
	
	
	private static  RCServo PhidgetMotorMover() {
		// Create new instance of servo board and start listening for motor changes
		// This method should only be called once when first constructing a servo instance
		try {
			System.out.println("Constructing MotorMover");
			servo = new RCServo();
			// optionally add listeners to moving.
			// Can remove if necessary
	        servo.addVelocityChangeListener(new RCServoVelocityChangeListener() {
				public void onVelocityChange(RCServoVelocityChangeEvent e) {
					//System.out.println("Velocity Changed: " + e.getVelocity());
				}
	        });
	        
	        servo.addPositionChangeListener(new RCServoPositionChangeListener() {
				public void onPositionChange(RCServoPositionChangeEvent e) {
					//System.out.println("Position Changed: " + e.getPosition());
				}
	        });
	        
	        servo.addTargetPositionReachedListener(new RCServoTargetPositionReachedListener() {
				public void onTargetPositionReached(RCServoTargetPositionReachedEvent e) {
					//System.out.println("Target Position Reached: " + e.getPosition());
				}
	        });


		// Start listening for motor interaction
			servo.open(2000);
		} catch (PhidgetException e) {
			e.printStackTrace();
		}
//	        moveServoTo(0);
//	        System.out.println("Motor initially positioned at: 0");
        return servo;
	}               

	public static void moveServoTo(double motorPosition) {
        try {
        		// Get the servo that is available
        		PhidgetMotorMover.getInstance();
        		System.out.println("moving to "+motorPosition);
        		servo.setMaxPosition(210.0);
			servo.setTargetPosition(motorPosition);
			servo.setEngaged(true);
		} catch (PhidgetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
