package publisher;

import com.phidget22.RFID;
import org.eclipse.paho.client.mqttv3.*;
import utils.Utils;

/**
 * Created by Pritam Sangani on 07/11/2018.
 */
public class Publisher {

    private static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    private static final String ID = "16039231";
    private static final String TOPIC = "tag";
    private static final String CLIENT_ID = Utils.getMacAddress() + "-pub";

    private MqttClient client;

    public Publisher() {
        try {
            client = new MqttClient(BROKER_URL, CLIENT_ID);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setMaxInflight(1000);
            options.setAutomaticReconnect(true);
            options.setWill(client.getTopic(ID+"/LWT"), "I'm gone :(".getBytes(), 0, false);

            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start(final String TAG) throws MqttException {
        publishRFIDTag(TAG);
    }

    private void publishRFIDTag(final String TAG) throws MqttException {
        final MqttTopic topic = client.getTopic(String.format("%s/%s", ID, TOPIC));
        topic.publish(new MqttMessage(TAG.getBytes()));
        System.out.println("Published data. Topic: " + topic.getName() + "   Message: " + TAG);
    }

}
