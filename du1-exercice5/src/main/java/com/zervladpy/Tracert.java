package com.zervladpy;

/**
 * Create a process to launch in the command line a tracert to
 * iessanclemente.net.
 * 
 * Redirect the process output to a file called outputTracert.txt using the
 * redirectOutput method of ProcessBuilder
 * 
 * Wait for 500 miliseconds after the start of the process and destroy the
 * process after that time throwing an InterruptedException.
 * 
 * Verify the content of the outputTracert.txt file.
 */

public class Tracert {

    static final String OUTPUT_FILE = "/workspaces/Psp-DAM/du1-exercice5/output/outputTracert.txt";

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();

        String[] commands = { "traceroute", "www.iessanclemente.net" };

        pb.command(commands);

        try {
            pb.redirectOutput(ProcessBuilder.Redirect.to(new java.io.File(OUTPUT_FILE)));
            Process p = pb.start();
            Thread.sleep(500);
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
