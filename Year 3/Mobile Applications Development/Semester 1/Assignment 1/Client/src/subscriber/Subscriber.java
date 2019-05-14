package subscriber;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import utils.Utils;

/**
 * Created by Pritam Sangani on 07/11/2018.
 */
public class Subscriber {

    private static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    private static final String ID = "16039231";
    private static final String TOPIC = "tag";
    private static final String CLIENT_ID = Utils.getMacAddress() + "-sub";

    private MqttClient client;

    public Subscriber() {
        try {
            client = new MqttClient(BROKER_URL, CLIENT_ID);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start() throws MqttException {
        client.setCallback(new SubscriberCallback());
        client.connect();
        client.subscribe(String.format("%s/%s", ID, TOPIC));
        System.out.println("Subscriber now listening to "+ TOPIC);
    }

}
