package com.zervladpy;

public class ProcessWIthErrorCode {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();

        String[] commands = { "ping", "-n" };

        pb.command(commands);

        try {
            pb.inheritIO();
            pb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
