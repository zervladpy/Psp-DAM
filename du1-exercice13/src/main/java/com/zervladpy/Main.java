package com.zervladpy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a program in Java that reads from the standard input a number and
 * after it reads the quantity of numbers indicated above. The program must add
 * up all the numbers and calculate the square of the sum and display the result
 * on the standard output.
 * 
 * Create another program in Java that reads from the standard input a number
 * and after it reads the quantity of numbers indicated above. The program must
 * square all of the numbers and then calculate their sum and display the result
 * on the standard output.
 * 
 * Finally, create another program that launches the two programs created
 * earlier using the same numbers and display the result on the standard output.
 * Use getInputStream and getOutputStream to communicate with the processes.
 */

public class Main {

    final static String CLASS_PATH = System.getProperty("java.class.path");

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the quantity of numbers: ");

            int quantity = scanner.nextInt();

            List<String> sumSquareCommand = new ArrayList<String>();
            sumSquareCommand.add("java");
            sumSquareCommand.add("-cp");
            sumSquareCommand.add(CLASS_PATH);
            sumSquareCommand.add("com.zervladpy.SumSquare");

            List<String> squareSumCommand = new ArrayList<String>();
            squareSumCommand.add("java");
            squareSumCommand.add("-cp");
            squareSumCommand.add(CLASS_PATH);
            squareSumCommand.add("com.zervladpy.SquareSum");

            for (int i = 1; i <= quantity; i++) {

                System.out.print("Enter a " + i + " : ");

                int n = scanner.nextInt();

                squareSumCommand.add(String.valueOf(n));
                sumSquareCommand.add(String.valueOf(n));

            }

            ProcessBuilder sumSquareProcessBuilder = new ProcessBuilder(sumSquareCommand);
            ProcessBuilder squareSumProcessBuilder = new ProcessBuilder(squareSumCommand);

            try {

                squareSumProcessBuilder.inheritIO();
                sumSquareProcessBuilder.inheritIO();

                Process sumSquareProcess = sumSquareProcessBuilder.start();
                Process squareSumProcess = squareSumProcessBuilder.start();

                sumSquareProcess.waitFor();
                squareSumProcess.waitFor();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}