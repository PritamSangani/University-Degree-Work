package subscriber;

import com.phidget22.PhidgetException;
import com.phidget22.RCServo;

/**
 * Created by Pritam Sangani on 07/11/2018.
 */
public class ServoMover {
    static RCServo servo = null;
    private static ServoMover instance = null;

    public static RCServo getInstance() {
        if (servo == null) {
            servo = ServoMover();
        }
        return servo;
    }

    private static RCServo ServoMover() {
        try {
            servo = new RCServo();
            servo.open(150000);
        } catch (PhidgetException e) {
            e.printStackTrace();
        }

        return servo;
    }

    public static void moveServoTo(double motorPosition) {

        try {
            ServoMover.getInstance();
            servo.setMaxPosition(210.0);
            servo.setTargetPosition(motorPosition);
            servo.setEngaged(true);
        } catch (PhidgetException e) {
            e.printStackTrace();
        }

    }
}
