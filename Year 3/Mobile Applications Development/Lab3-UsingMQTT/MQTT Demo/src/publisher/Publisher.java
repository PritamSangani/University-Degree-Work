package publisher;

import utils.Utils;
import org.eclipse.paho.client.mqttv3.*;


public class Publisher {

    // public static final String BROKER_URL = "tcp://broker.hivemq.com:1883";
     public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    //public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    public static final String userid = "16039231"; // change this to be your student-id

    public static final String TOPIC_BRIGHTNESS 	= userid + "/brightness";
    public static final String TOPIC_TEMPERATURE = userid +"/temperature";

    private MqttClient client;


    public Publisher() {


        try {

            client = new MqttClient(BROKER_URL, userid);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void start() {

        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setMaxInflight(1000);
            options.setAutomaticReconnect(true);
            options.setWill(client.getTopic(userid+"/LWT"), "I'm gone :(".getBytes(), 0, false);

            client.connect(options);

            //Publish data forever
            while (true) {

                publishBrightness();

                Thread.sleep(1000);

                publishTemperature();

                Thread.sleep(2000);
            }
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void publishTemperature() throws MqttException {
        final MqttTopic temperatureTopic = client.getTopic(TOPIC_TEMPERATURE);

        final int temperatureNumber = Utils.createRandomNumberBetween(20, 30);
        final String temperature = temperatureNumber + "°C";

        temperatureTopic.publish(new MqttMessage(temperature.getBytes()));

        System.out.println("Published data. Topic: " + temperatureTopic.getName() + "  Message: " + temperature);
    }

    private void publishBrightness() throws MqttException {
        final MqttTopic brightnessTopic = client.getTopic(TOPIC_BRIGHTNESS);

        final int brightnessNumber = Utils.createRandomNumberBetween(0, 100);
        final String brightness = "b"+brightnessNumber;

        brightnessTopic.publish(brightness.getBytes(), 0, true);
        //.publish(new MqttMessage(brightness.getBytes()));

        System.out.println("Published data. Topic: " + brightnessTopic.getName() + "   Message: " + brightness);
    }

    public static void main(String... args) {
        final Publisher publisher = new Publisher();
        publisher.start();
    }
}
