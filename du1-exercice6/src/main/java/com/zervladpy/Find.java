package com.zervladpy;

import java.io.File;

/**
 * Create a program to exect the command find in Ububtu to count the number of
 * lines that one text appears in one file. The number obtained must be write to
 * another file. The text, the name of the file where to search the text and the
 * name of the file where to put the result must be arguments in the command
 * line. Use the ProcessBuilder methods redirectInput and redirectOutput.
 */
public class Find {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java -jar du1-exercice6.jar <text> <file> <result_file>");
            System.exit(1);
        }

        String text = args[0];
        String file = args[1];
        String result = args[2];

        String[] command = { "find", file, "-type", "f", "-exec", "grep", "-c", text, "{}", ";" };

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectOutput(new File(result));

        try {
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
