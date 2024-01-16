package org.zervladpy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static org.zervladpy.constraints.Constraints.DEFAULT_PORT;

public class SquareClient {

    private Socket clinetSocket;
    private PrintWriter out;
    private BufferedReader in;


    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            throw new Exception("Pass ip as arguments");
        }

        SquareClient client = new SquareClient();
        client.startConnection(args[0], DEFAULT_PORT);
        client.communicate();

    }

    private void communicate() {

        System.out.println("Enter lines of text. Finish with .");
        Scanner scanner=new Scanner(System.in);
        String input;
        while (scanner.hasNextLine()){
            input = scanner.nextLine();
            System.out.println("Server Response: " + sendMessage(input));
        }
    }

    private String sendMessage(String inputLine) {
        try {
            out.println(inputLine);
            return in.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    private void startConnection(String ip, int port) throws IOException {
            clinetSocket = new Socket(ip, port);
            out = new PrintWriter(clinetSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clinetSocket.getInputStream()));
    }

    private void stopConnection() throws IOException {
        in.close();
        out.close();
        clinetSocket.close();
    }
}
