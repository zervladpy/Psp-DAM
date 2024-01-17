package org.zervladpy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.zervladpy.constraints.Constraints.DEFAULT_PORT;

public class GameServer {
    ServerSocket serverSocket;
    Socket client;

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();

        int port = DEFAULT_PORT;

        try {
            if (args.length == 1) {
                port = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Port: " + args[0] + "is not valid, using default instead");
        }

        server.initialize(port);
    }

    void initialize(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server initialized correctly");
        System.out.println("Listening on: " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
        while (true) {
            client = serverSocket.accept();
            new Thread(new GameClientHandler(client)).start();
        }

    }

}
