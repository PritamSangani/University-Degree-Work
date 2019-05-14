package phidgetlabs;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.phidget22.*;

public class LockingServoSolution {

	static RCServo ch;
	
    public static void main(String[] args) throws Exception {
    	ch = new RCServo();

    	ch.addVelocityChangeListener(new RCServoVelocityChangeListener() {
			public void onVelocityChange(RCServoVelocityChangeEvent e) {
				System.out.printf("Velocity Changed: %.3g\n", e.getVelocity());
			}
        });
        
        ch.addPositionChangeListener(new RCServoPositionChangeListener() {
			public void onPositionChange(RCServoPositionChangeEvent e) {
				System.out.printf("Position Changed: %.3g\n", e.getPosition());
			}
        });
        
        ch.addTargetPositionReachedListener(new RCServoTargetPositionReachedListener() {
			public void onTargetPositionReached(RCServoTargetPositionReachedEvent e) {
				System.out.printf("Target Position Reached: %.3g\n", e.getPosition());
			}
        });
        
        try {
             /*
            * Please review the Phidget22 channel matching documentation for details on the device
            * and class architecture of Phidget22, and how channels are matched to device features.
            */

            System.out.println("Opening and waiting 5 seconds for attachment...");
            ch.open(5000);

            System.out.println("Setting lock to closed initially, position to 0");
            ch.setTargetPosition(0.0);
            System.out.println("Setting engaged");
            ch.setEngaged(true);
 
            int doorCode = getDoorCode();  // code shown below
            if (doorCode == 999) {
            		openDoor();	// code shown below
            }
            else{
            		System.out.println("\nInvalid door code");
            }
            
            
            ch.close();
            System.out.println("\nClosed Motor Servo");
            
        } catch (PhidgetException ex) {
            System.out.println(ex.getDescription());
        }
    }
    

	private static int getDoorCode(){
	        String input = JOptionPane.showInputDialog(null, "Enter door code:");
	        int doorCode = Integer.parseInt(input);
	        return doorCode;
	    }
	
	private static void openDoor() throws Exception{
        System.out.println("\n\nSetting lock open position to 180 for 3 seconds\n\n");
        try {
        	ch.setTargetPosition(180);
        	Thread.sleep(3000);
        	System.out.println("\n\nSetting lock close position to 0\n\n");
        	ch.setTargetPosition(0);
        	Thread.sleep(3000);        	
    	} catch (PhidgetException ex) {
    		System.out.println(ex.getDescription());
    	}
		
	}   
}
