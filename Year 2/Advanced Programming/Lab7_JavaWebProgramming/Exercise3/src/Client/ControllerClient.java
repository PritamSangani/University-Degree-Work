package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Pritam Sangani on 14/11/2017.
 */
public class ControllerClient {
    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;

        System.out.println("Please enter some text >");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 3001);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        System.out.println(sentence);
        outToServer.writeBytes(sentence + "\n");
        modifiedSentence = inFromServer.readLine();
        System.out.println("Incoming from server > " + modifiedSentence);
        clientSocket.close();
    }
}
