package com.zervladpy;

/**
 * Create a program in Java that launches a process that verifies the MD5
 * checksum of a file and prints that checksum to the standard output.
 * 
 * The following URL shows how to do that verification in Windows 11:
 * https://www.windowsdigitals.com/verify-md5-sha256-checksum-windows-11/
 * 
 * Use the method getInputStream to print the required output.
 * 
 */

public class Main {

    final static String FILE_PATH = "/workspaces/Psp-DAM/du1-exercice12/input/test.txt";

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();

        String[] command = { "md5sum", "-c", FILE_PATH };

        pb.command(command);

        try {
            Process process = pb.start();

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("The file is valid");
            } else {
                System.out.println("The file is not valid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}