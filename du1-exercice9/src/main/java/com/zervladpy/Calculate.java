package com.zervladpy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;

public class Calculate {

    public static void main(String[] args) {

        String input = args[0];
        String output = args[1];

        BigDecimal sum = new BigDecimal(0);

        try (BufferedReader fileReader = new BufferedReader(new FileReader(new File(input)))) {
            String line;

            for (line = fileReader.readLine(); line != null; line = fileReader.readLine()) {
                sum = sum.add(new BigDecimal(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File(output), true))) {
            fileWriter.write("file: " + input + " report: " + sum);
            fileWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
