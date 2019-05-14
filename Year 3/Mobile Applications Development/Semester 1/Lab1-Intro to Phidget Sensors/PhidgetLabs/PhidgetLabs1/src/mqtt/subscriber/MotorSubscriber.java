package mqtt.subscriber;

import mqtt.utils.Utils;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;


public class MotorSubscriber {

    public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    // public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    public static final String userid = "mmuphidget"; // change this to be your student-id
    String clientId = userid + "-sub";


    private MqttClient mqttClient;

    public MotorSubscriber() {

        try {
            mqttClient = new MqttClient(BROKER_URL, clientId);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start() {
        try {
            mqttClient.setCallback(new MotorSubscribeCallback());
            mqttClient.connect();

            //Subscribe to correct topic
            final String topic = userid+"/motor";
            mqttClient.subscribe(topic);

            System.out.println("Subscriber is now listening to "+topic);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String... args) {
        final MotorSubscriber subscriber = new MotorSubscriber();
        subscriber.start();
    }

}
