package server;

import constraints.Connection;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static constraints.Connection.PORT;

public class ContactServer {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            listen(serverSocket);

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }

    private static void notifyStart() {
        System.out.println("Server Listening...");
    }

    private static void listen(ServerSocket serverSocket) throws IOException {

        notifyStart();

        while (true) {
            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(new ContactServerWorker(in, out)).start();

        }

    }

    private static void shutdown() {

    }

}
