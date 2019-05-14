package subscriber;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import utils.Utils;

/**
 * Created by Pritam Sangani on 07/11/2018.
 */
public class SubscriberCallback implements MqttCallback {

    public static final String ID = "16039231"; // change this to be your student-id

    @Override
    public void connectionLost(Throwable cause) {
        //This is called when the connection is lost. We could reconnect here.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        System.out.println("Message arrived. Topic: " + topic + "  Message: " + message.toString());

        ServoMover.moveServoTo(180.0);
        Utils.waitFor(5);
        ServoMover.moveServoTo(0.0);
        Utils.waitFor(2);

        if ((ID+"/LWT").equals(topic)) {
            System.err.println("Sensor gone!");
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        //no-op
    }
}
