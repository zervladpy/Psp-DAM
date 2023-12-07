package com.zervladpy;

import java.io.File;

/**
 * Make a program that goes through all the files in the departments directory
 * calculating the sum of the values stored in each of the files and creates a
 * report in a file with this information.
 * 
 * The program must create one process for each file. The code for each process
 * must be the same.
 */

public class DocumentsReader {

    static final String INPUT_DIRECTORY = "/workspaces/Psp-DAM/du1-exercice9/input/departments";
    static final String OUTPUT_FILE = "/workspaces/Psp-DAM/du1-exercice9/output/report.txt";

    public static void main(String[] args) {

        File[] files = new File(INPUT_DIRECTORY).listFiles();

        for (File file : files) {

            ProcessBuilder pb = new ProcessBuilder();

            pb.redirectOutput(new File(OUTPUT_FILE));

            String[] commands = {
                    "java",
                    "/workspaces/Psp-DAM/du1-exercice9/src/main/java/com/zervladpy/Calculate.java",
                    file.getPath(), OUTPUT_FILE
            };

            /*
             * With classPath:
             * 
             * String classPath = System.getProperty("java.class.path");
             * 
             * String[] commands = {
             * "java", "-cp", classPath, "main.java.com.zervladpy.Calculate
             * file.getPath(), OUTPUT_FILE
             * };
             */

            pb.command(commands);

            try {
                pb.inheritIO();
                pb.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
