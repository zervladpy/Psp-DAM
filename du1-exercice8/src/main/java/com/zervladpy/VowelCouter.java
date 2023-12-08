package com.zervladpy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VowelCouter {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java VowelCouter <vowel> <input_file> <output_file>");
            System.exit(1);
        }

        String vowel = args[0];
        String input = args[1];
        String output = args[2];

        File inputFile = new File(input);
        File outputFile = new File(output);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == vowel.charAt(0) || line.charAt(i) == vowel.toUpperCase().charAt(0)) {
                        count++;
                    }
                }

            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {

                bw.write("Number of " + vowel.toUpperCase() + ": " + count + System.lineSeparator());

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
