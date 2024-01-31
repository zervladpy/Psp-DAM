package client;

import constraints.ServerResponses;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static constraints.Connection.HOST;
import static constraints.Connection.PORT;

public class ContactClient {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean connected;

        try (Socket socket = new Socket(HOST, PORT)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            connected = true;
            while (connected) {
                String client = input.nextLine();
                if (!client.isEmpty()) {
                    out.writeUTF(client);
                    String response = in.readUTF();
                    System.out.println("CLIENT: " + client);
                    System.out.println("SERVER: " + response);
                    if (response.contains(ServerResponses.BYE.name())) {
                        connected = false;
                    } else {
                        out.writeUTF(input.nextLine());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

}
