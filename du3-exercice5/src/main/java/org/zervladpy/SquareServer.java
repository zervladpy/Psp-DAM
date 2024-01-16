package org.zervladpy;

import java.io.IOException;
import java.net.ServerSocket;

import static org.zervladpy.constraints.Constraints.DEFAULT_PORT;

public class SquareServer {

    public static void main(String[] args) {
        SquareServer server = new SquareServer();

        server.initialize(DEFAULT_PORT);

    }


    private void initialize(int port) {

        try (var socket = new ServerSocket(port, 5) ) {
            while (true) {
                new Thread(new SquareClientHandler(socket.accept())).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            stop();
        }
    }

    private void stop() {}


}
