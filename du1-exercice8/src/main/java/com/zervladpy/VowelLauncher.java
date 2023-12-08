package com.zervladpy;

import java.io.File;

/**
 * Create a program that is able to count how many vowels are in a file. The
 * parent program must launch five child processes, each of which will count a
 * particular vowel (which can be either lower or upper case). Each
 * vowel-counting process must leave the result in a file. The parent program
 * will then retrieve the results from the files, add up all the subtotals and
 * display the final result on the screen.
 * 
 * For the file given as example fileData.txt the results would be:
 * 
 * Number of A: 23
 * 
 * Number of E: 45
 * 
 * Number of I: 16
 * 
 * Number of O: 18
 * 
 * Number of U: 7
 * 
 * Total number: of vowels: 109
 *
 */
public class VowelLauncher {

    final static String INPUT_FILE = "/workspaces/Psp-DAM/du1-exercice8/input/input.txt";
    final static String OUTPUT_FILE = "/workspaces/Psp-DAM/du1-exercice8/output/output.txt";

    public static void main(String[] args) {

        String[] vowels = { "a", "e", "i", "o", "u" };

        if (new File(OUTPUT_FILE).exists()) {
            new File(OUTPUT_FILE).delete();
        }

        for (String vowel : vowels) {

            String[] command = {
                    "java",
                    "/workspaces/Psp-DAM/du1-exercice8/src/main/java/com/zervladpy/VowelCouter.java",
                    vowel,
                    INPUT_FILE,
                    OUTPUT_FILE
            };

            ProcessBuilder pb = new ProcessBuilder();

            pb.command(command);

            try {
                Process process = pb.start();
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        String[] command = {
                "java",
                "/workspaces/Psp-DAM/du1-exercice8/src/main/java/com/zervladpy/VowelTotalizer.java",
                OUTPUT_FILE
        };

        ProcessBuilder pb = new ProcessBuilder();

        pb.command(command);

        try {
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
