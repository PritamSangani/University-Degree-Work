package com.epmmu.mqttdemo;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {

    public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
//    public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";


    String userid = "mmuphidget";  // Alter this to your student id
    //We have to generate a unique Client id.
    String clientId = userid + "-sub";

    // Default sensor to listen for -
    // Change to another if you are broadcasting a different sensor name
    String sensorname = "brightness";

    String topicname = userid + "/" + sensorname;

    private MqttClient mqttClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start new
        // Create MQTT client and start subscribing to message queue
        try {
            // change from original. Messages in "null" are not stored
            mqttClient = new MqttClient(BROKER_URL, clientId,null);
            mqttClient.setCallback(new MqttCallbackExtended() {
                @Override
                public void connectionLost(Throwable cause) {
                    //This is called when the connection is lost. We could reconnect here.
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("DEBUG: Message arrived. Topic: " + topic + "  Message: " + message.toString());
                    // get message data
                    final String messageStr = message.toString();
                    runOnUiThread(new Runnable() {
                        public void run() {
                            System.out.println("Updating UI");
                            // Update UI elements
                            TextView sensorValueTV = (TextView) findViewById(R.id.sensorValueTV);
                            sensorValueTV.setText(messageStr);
                        }
                    });
                    if ((topicname+"/LWT").equals(topic)) {
                        System.err.println("Sensor gone!");
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    //no-op
                }

                @Override
                public void connectComplete(boolean b , String s) {
                    //no-op
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // temp use of ThreadPolicy until use AsyncTask
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        startSubscribing();


    }


    public void startSubscribing() {
        try {
            mqttClient.connect();

            //Subscribe to all subtopics of home
            final String topic = topicname;
            mqttClient.subscribe(topic);

            System.out.println("Subscriber is now listening to "+topic);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }





}
