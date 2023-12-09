package com.zervladpy;

public class EvenAddNumbers {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java EvenAddNumbers <number1> <number2>");
            throw new IllegalArgumentException("Usage: java EvenAddNumbers <number1> <number2>");
        }

        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);

        int sum = 0;

        for (int i = number1; i <= number2; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println("Sum of even numbers between " + number1 + " and " + number2 + " is " + sum);

    }
}