package org.zervladpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareClientHandler implements Runnable{

    private final Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public SquareClientHandler(Socket socket) {
        clientSocket = socket;
    }


    @Override
    public void run() {

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String input;

            while((input = in.readLine()) != null) {

                int n = Integer.parseInt(input);

                out.println(n*n);
            }

            in.close();
            out.close();

            clientSocket.close();


        } catch (IOException e) {
            System.out.println("A");
        } catch (NumberFormatException e) {
            System.out.println("Format Exception");
        }

    }
}
