package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Pritam Sangani on 14/11/2017.
 */
public class ControllerServer {
    public static void main(String[] args) throws IOException {
        String clientSentence;
        String capitalisedSentence;
        ServerSocket serverSocket = null;
        Socket connectionSocket = null;

        try {
            serverSocket = new ServerSocket(3001);
            System.out.println("Server up and running on port 3001");
            while (true) {
                connectionSocket = serverSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                System.out.println("Received > " + clientSentence);
                capitalisedSentence = clientSentence.toUpperCase();
                outToClient.writeBytes(capitalisedSentence + "\n");
            }
        } catch (IOException ioe) {
            System.out.println("Connection problems "+ioe);
        } finally {
            connectionSocket.close();
            serverSocket.close();
        }
    }
}
