package client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.phidget22.PhidgetException;
import com.phidget22.RFID;
import org.eclipse.paho.client.mqttv3.MqttException;
import publisher.Publisher;
import utils.SensorData;
import utils.Utils;

/**
 * Created by Pritam Sangani on 16/11/2018.
 */

public class RFIDReaderClient {
    public static final String BASE_URL = "http://localhost:3000";
    public static void main(String[] args) throws PhidgetException {
        new RFIDReaderClient();
    }

    private RFIDReaderClient() throws PhidgetException {
        RFID reader = new RFID();
        Publisher publisher = new Publisher();
        try {
            reader.open();
            reader.addTagListener(rfidTagEvent -> {
                String tagID = rfidTagEvent.getTag();
                System.out.printf("TAG FOUND: %s\n", tagID); //DEBUG: prints out tag if and when detected
                String url = String.format("%s/attempt", BASE_URL);
                SensorData sensorData = new SensorData();
                sensorData.setSensorname("rfid");
                sensorData.setSensorvalue("found1");
                sensorData.setUsername("Bob");

                String response = Utils.sendPostRequestToServer(url, sensorData);
                JsonObject json = new JsonParser().parse(response).getAsJsonObject();
                String attemptResult = json.get("attemptResult").toString();
                if (attemptResult.equals("true")) {
                    try {
                        publisher.start(tagID);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            });

            try {
                System.out.println("Gathering Data for 150 seconds");
                Thread.sleep(150000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            reader.close();
            System.out.println("RFID reader closed");
        }
    }
}
