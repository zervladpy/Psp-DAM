package com.zervladpy;

public class NoExistingProcess {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();

        String[] commands = { "pin", "www.iessanclemente.net" };

        pb.command(commands);

        try {
            pb.inheritIO();
            pb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
