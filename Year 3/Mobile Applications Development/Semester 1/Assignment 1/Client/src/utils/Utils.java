package utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Collections;

/**
 * Created by Pritam Sangani on 07/11/2018.
 */

public class Utils {

    public static String getMacAddress() {
        String macAddress = "";

        try {
            for (NetworkInterface ni : Collections.list(
                    NetworkInterface.getNetworkInterfaces())) {
                byte[] hardwareAddress = ni.getHardwareAddress();

                if (hardwareAddress != null) {
                    for (int i = 0; i < hardwareAddress.length; i++)
                        macAddress += String.format((i == 0 ? "" : "-") + "%02X", hardwareAddress[i]);

                    return macAddress;
                }
            }

        } catch (SocketException e) {
            System.out.println("Could not find out MAC Adress. Exiting Application ");
            System.exit(1);
        }
        return macAddress;
    }

    public static void waitFor(int numSeconds) {
        // pauses for numSeconds
        try {
            Thread.sleep(numSeconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String sendPostRequestToServer(String URL, SensorData sensorData) {
        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            Gson gson = new Gson();
            String data = gson.toJson(sensorData);

            System.out.println("data: "+data);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            writer.writeBytes(data);
            writer.flush();
            writer.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            System.out.println("response: "+response.toString());
            return response.toString();

        } catch (IOException e) {
            System.out.println("ERROR: "+e.toString());
            e.printStackTrace();
            return "ERROR";
        }
    }
}
