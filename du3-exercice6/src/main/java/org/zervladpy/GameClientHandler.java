package org.zervladpy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class GameClientHandler implements Runnable {

    private boolean gameOnGoing;
    private boolean connectionOpen;
    private int hiddenNumber;
    private int totalGuesses;
    private int currentGuesses;
    private final Socket client;
    private DataOutputStream out;
    private DataInputStream in;

    GameClientHandler(Socket client) {
        this.client = client;
        gameOnGoing = false;
        connectionOpen = true;

    }

    @Override
    public void run() {

        try {
            out = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());

            out.writeUTF("10 Number game server ready");

            while (connectionOpen) {

                String input = in.readUTF();

                if (input.startsWith("NEW")) {
                    totalGuesses = Integer.parseInt(input.substring(0, 4));
                    hiddenNumber = new Random().nextInt(10);
                    out.writeUTF("20 PLAY " + totalGuesses);
                }

                if (input.startsWith("NUM")) {
                    int n = Integer.parseInt(input.substring(0, 4));

                    if (n < hiddenNumber) {
                        out.writeUTF("25 LOW");

                    }

                    if (n > hiddenNumber) {
                        out.writeUTF("35 HIGH");
                    }

                    if (n == hiddenNumber) {

                    }
                }

                if (input.startsWith("HELP")) {

                }

                if (input.equals("QUIT")) {
                    connectionOpen = false;
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void read() {

    }

}
