package com.zervladpy;

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
            pb.environment().forEach((key, value) -> System.out.println(key + " : " + value));
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
