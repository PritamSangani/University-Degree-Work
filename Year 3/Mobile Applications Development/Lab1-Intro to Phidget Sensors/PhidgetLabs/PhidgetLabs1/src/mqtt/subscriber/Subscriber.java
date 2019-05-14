package mqtt.subscriber;

import mqtt.utils.Utils;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * @author Dominik Obermaier
 * @author Christian Götz
 */
public class Subscriber {

    public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    // public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    public static final String userid = "mmuphidget"; // change this to be your student-id

    //We have to generate a unique Client id.
//    String clientId = Utils.getMacAddress() + "-sub";
    String clientId = userid + "-sub";
    private MqttClient mqttClient;

    public Subscriber() {

        try {
            mqttClient = new MqttClient(BROKER_URL, clientId);
//            mqttClient = new MqttClient(BROKER_URL, userid);


        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start() {
        try {

            mqttClient.setCallback(new SubscribeCallback());
            mqttClient.connect();

            //Subscribe to all subtopics of home
//            final String topic = userid + "/brightness";
            final String topic = userid + "/motor";
            mqttClient.subscribe(topic);

            System.out.println("Subscriber is now listening to "+topic);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String... args) {
        final Subscriber subscriber = new Subscriber();
        subscriber.start();
    }

}
