package org.zervladpy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static org.zervladpy.constraints.Constraints.DEFAULT_PORT;

public class GameClient {

    Socket client;
    Scanner sc;

    DataInputStream in;
    DataOutputStream out;

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            throw new Exception("usage: $classpath IP");
        }

        GameClient gameClient = new GameClient();


        gameClient.sc = new Scanner(System.in);
        gameClient.initializeConnection(args[0], DEFAULT_PORT);
    }

    public void initializeConnection(String ip, int port) throws IOException {
        client = new Socket(ip, port);
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());

        while (sc != null) {
            read();
            communicate();
        }

    }

    public void closeConnection() throws IOException {
        sc = null;
        client.close();
        System.exit(0);
    }

    void communicate() throws IOException {
        String clientInput = sc.nextLine();
        out.writeUTF(clientInput);
    }

    void read() throws IOException {

        String response = in.readUTF();

        System.out.println(response);

        if (response.contains("11")) {
            closeConnection();
        }
    }


}
