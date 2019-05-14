package mqtt.subscriber;

import org.eclipse.paho.client.mqttv3.*;


public class SubscribeCallback implements MqttCallback {

    public static final String userid = "mmuphidget"; // change this to be your student-id

    @Override
    public void connectionLost(Throwable cause) {
        //This is called when the connection is lost. We could reconnect here.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Message arrived. Topic: " + topic + "  Message: " + message.toString());

        if ((userid+"/LWT").equals(topic)) {
            System.err.println("Sensor gone!");
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        //no-op
    }
}
