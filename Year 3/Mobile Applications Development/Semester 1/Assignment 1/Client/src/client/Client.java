package client;

import com.phidget22.PhidgetException;
import com.phidget22.RFID;
import org.eclipse.paho.client.mqttv3.MqttException;
import publisher.Publisher;
import subscriber.Subscriber;

/**
 * Created by Pritam Sangani on 07/11/2018.
 */
public class Client {
    private Publisher publisher = new Publisher();

    public static void main(String[] args) throws PhidgetException {
        new Client();
    }

    private Client() throws PhidgetException {
        RFID reader = new RFID();

        try {
            reader.setChannel(0);
            reader.open(150000);
            reader.addTagListener(rfidTagEvent -> {
                System.out.println("TAG FOUND");
                System.out.println(rfidTagEvent.getTag());
                try {
                    publisher.start(rfidTagEvent.getTag());
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            });
            Subscriber subscriber = new Subscriber();
            subscriber.start();

            try {
                System.out.println("Gathering data for 150 seconds\n\n");
                Thread.sleep(150000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            System.out.println("Closed reader and exiting...");
        }
    }
}
