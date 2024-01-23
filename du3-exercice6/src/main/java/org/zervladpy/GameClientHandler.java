package org.zervladpy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
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

    private List<String> commands;

    GameClientHandler(Socket client) {
        this.client = client;
        gameOnGoing = false;
        connectionOpen = true;

        commands = new ArrayList<>();
        commands.add("NEW");
        commands.add("QUIT");
        commands.add("HELP");
        commands.add("NUM");
    }

    @Override
    public void run() {

        try {
            out = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());

            out.writeUTF("10 Number game server ready");

            while (connectionOpen) {

                String input = in.readUTF();

                boolean isValid = false;

                for (String cmd : commands) {
                    if (input.contains(cmd)) {
                        isValid = true;
                        break;
                    }
                }

                if (!isValid) {
                    out.writeUTF("90 UNKNOWN");
                }

                if (input.startsWith("NEW") && !gameOnGoing) {

                    int n = getNumber(input);

                    if (n == -1) {
                        out.writeUTF("90 UNKNOWN");
                    } else if (n > -1) {
                        totalGuesses = getNumber(input);
                        hiddenNumber = new Random().nextInt(10);
                        out.writeUTF("20 PLAY " + totalGuesses);
                    }

                }

                if (input.startsWith("NUM")) {
                    int n = getNumber(input);

                    if (n == -1) {
                        out.writeUTF("90 UNKNOWN");
                    } else if (n > -1) {
                        if (n < hiddenNumber) {
                            out.writeUTF("25 LOW " + (currentGuesses - totalGuesses));

                        }

                        if (n > hiddenNumber) {
                            out.writeUTF("35 HIGH " + (currentGuesses - totalGuesses));
                        }

                        if (n == hiddenNumber) {
                            out.writeUTF("50 WIN");
                        }
                    }


                }

                if (input.startsWith("HELP")) {
                    out.writeUTF("NEW <attempts> - new game with user given attempts\nNUM <guess> - try guess\nHELP - help menu\nQUIT - end game");
                }

                if (input.equals("QUIT")) {
                    out.writeUTF("11 BYE");
                    connectionOpen = false;
                }

            }
            client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private int getNumber(String str) throws IOException {
        try {
            return Integer.parseInt(str.substring(4));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            out.writeUTF("80 ERR");

            return -1;
        }
    }

}
