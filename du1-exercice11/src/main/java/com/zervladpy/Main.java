package com.zervladpy;

import java.io.File;

/**
 * Create a program in Java that takes two numbers from command line and add all
 * even numbers between the smaller and the greater both inclusive,Test the
 * program to verify it works properly.
 * 
 * Create a new program to launch the previous program. Redirect the errors to a
 * file named errors.txt. Redirect the output to a file named output.txt. Its
 * important to wait until the launched process is finished.
 * 
 */

public class Main {

    final static String ERROR_FILE = "/workspaces/Psp-DAM/du1-exercice11/errors/errors.txt";
    final static String CLASS_PATH = System.getProperty("java.class.path");

    public static void main(String[] args) {

        String[] command = { "java", "-cp", CLASS_PATH, "com.zervladpy.EvenAddNumbers", "10", "120" };
        String[] commandError = { "java", "-cp", CLASS_PATH, "com.zervladpy.EvenAddNumbers" };

        ProcessBuilder pb = new ProcessBuilder().command(command);
        ProcessBuilder pbError = new ProcessBuilder().command(commandError);

        pb.redirectError(new File(ERROR_FILE));

        try {

            Process process = pb.start();
            process.waitFor();

            Process processError = pbError.start();
            processError.waitFor();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
