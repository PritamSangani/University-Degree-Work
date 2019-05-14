package mqtt.subscriber;

import org.eclipse.paho.client.mqttv3.*;

import mqtt.utils.Utils;


public class MotorSubscribeCallback implements MqttCallback {

    public static final String userid = "mmuphidget"; // change this to be your student-id

    @Override
    public void connectionLost(Throwable cause) {
        //This is called when the connection is lost. We could reconnect here.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Message arrived. Topic: " + topic + "  Message: " + message.toString());
        
        // Move motor to open, then shut after pausing
        PhidgetMotorMover.moveServoTo(180.0);
        System.out.println("Waiting until motor at position 180");
        Utils.waitFor(5);
        PhidgetMotorMover.moveServoTo(0.0);
        Utils.waitFor(2);
        
        if ((userid+"/LWT").equals(topic)) {
            System.err.println("Sensor gone!");
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        //no-op
    }
}
