package com.zervladpy;

import java.util.Map;

/**
 * Create a program to show the execution environment of a process with the
 * ProcessBuilder method Map<String,String> environment().
 * 
 * Execute the process created to echo "Hello World" in the command line.
 */

public class Enviroment {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();

        String[] commands = { "echo", "Hello World" };

        pb.command(commands);

        try {
            pb.inheritIO();
            for (Map.Entry<String, String> entry : pb.environment().entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
