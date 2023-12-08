package com.zervladpy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 * Number of A: 23
 * Number of E: 45
 * Number of I: 16
 * Number of O: 18
 * Number of U: 7
 * 
 * Count total number of vowels: 109
 */

public class VowelTotalizer {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java VowelTotalizer <input_output_file>");
            System.exit(1);
        }

        File inputOutput = new File(args[0]);

        int total = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputOutput))) {

            String line;

            while ((line = br.readLine()) != null) {
                String nString = "";

                for (int i = line.length() - 1; i > -1; i--) {
                    try {
                        String n = String.valueOf(line.charAt(i));
                        Integer.parseInt(n);
                        nString = n + nString;
                    } catch (Exception e) {
                        break;
                    }
                }

                try {
                    total += Integer.parseInt(nString);
                } catch (Exception e) {
                    total = 0;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputOutput, true))) {

            bw.write("Total number of vowels: " + total + System.lineSeparator());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
