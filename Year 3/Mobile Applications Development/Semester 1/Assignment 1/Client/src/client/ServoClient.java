package client;

import org.eclipse.paho.client.mqttv3.MqttException;
import subscriber.Subscriber;

/**
 * Created by Pritam Sangani on 16/11/2018.
 */

public class ServoClient {

    public static void main(String[] args) {
        new ServoClient();
    }

    private ServoClient() {
        Subscriber subscriber = new Subscriber();

        try {
            subscriber.start();

            System.out.println("Subscribing Data for 150 seconds");
            Thread.sleep(150000);
        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }


    }

}
