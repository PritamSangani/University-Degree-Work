package ControllerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Pritam Sangani on 14/11/2017.
 */
public class ControllerServer {
    public static void main(String[] args) throws IOException {
        //SERVER
        ServerSocket listener = new ServerSocket(3000);
        System.out.println("Server up and running on port 3000 >>");
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }
}
