package mqtt.publisher;

import org.eclipse.paho.client.mqttv3.*;

import mqtt.utils.Utils;


public class PhidgetPublisher {

    public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    // public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    public static final String userid = "16039231"; // change this to be your student-id
    
    public static final String TOPIC_BRIGHTNESS = userid + "/brightness";
    public static final String TOPIC_SLIDER     = userid + "/slider";
    public static final String TOPIC_RFID       = userid + "/rfid";
    
    public static final String TOPIC_GENERIC    = userid + "/";

    private MqttClient client;


    public PhidgetPublisher() {

        try {
            client = new MqttClient(BROKER_URL, userid);
            // create mqtt session
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setWill(client.getTopic(userid + "/LWT"), "I'm gone :(".getBytes(), 0, false);
            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Specific publishing methods for particular phidgets
    public void publishBrightness(int brightnessNumber) throws MqttException {
        final MqttTopic brightnessTopic = client.getTopic(TOPIC_BRIGHTNESS);
        final String brigthness = brightnessNumber + "";
        brightnessTopic.publish(new MqttMessage(brigthness.getBytes()));
        System.out.println("Published data. Topic: " + brightnessTopic.getName() + "   Message: " + brigthness);
    }
    public void publishSlider(double d) throws MqttException {
        final MqttTopic sliderTopic = client.getTopic(TOPIC_SLIDER);
        final String slider = d + "";
        sliderTopic.publish(new MqttMessage(slider.getBytes()));
        System.out.println("Published data. Topic: " + sliderTopic.getName() + "   Message: " + slider);
    }
    public void publishRfid(String rfidTag) throws MqttException {
        final MqttTopic rfidTopic = client.getTopic(TOPIC_RFID);
        final String rfid = rfidTag + "";
        rfidTopic.publish(new MqttMessage(rfid.getBytes()));
        System.out.println("Published data. Topic: " + rfidTopic.getName() + "   Message: " + rfid);
    }

    
    
    // More generic publishing methods - avoids having to name every one
    public void publishSensor(String sensorValue, String sensorName) throws MqttException {
        final MqttTopic mqttTopic = client.getTopic(TOPIC_GENERIC + sensorName);
        final String sensor = sensorValue + "";
        mqttTopic.publish(new MqttMessage(sensor.getBytes()));
        System.out.println("Published data. Topic: " + mqttTopic.getName() + "   Message: " + sensor);
    }
    public void publishSensor(int sensorValue, String sensorName) throws MqttException {
    // same as string publisher, just convert int to String
      publishSensor(String.valueOf(sensorValue), sensorName);
    }
    public void publishSensor(float sensorValue, String sensorName) throws MqttException {
    // same as string publisher, just convert float to String
      publishSensor(String.valueOf(sensorValue), sensorName);
    }
    
    
}
