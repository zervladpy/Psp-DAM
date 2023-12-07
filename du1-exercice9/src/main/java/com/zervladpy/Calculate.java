package main.java.com.zervladpy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;

public class Calculate {

    public static void main(String[] args) {

        String filePath = args[0];
        String output = args[1];

        BigDecimal sum = new BigDecimal(0);

        try (BufferedReader fileReader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;

            for (line = fileReader.readLine(); line != null; line = fileReader.readLine()) {
                sum = sum.add(new BigDecimal(line));
            }

            System.out.println("file: " + filePath + " report: " + sum);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new java.io.FileWriter(new File(output), true))) {
            fileWriter.write("file: " + filePath + " report: " + sum);
            fileWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
