package com.zervladpy;

public class SquareSum {
    public static void main(String[] args) {

        if (args.length < 1) {
            throw new IllegalArgumentException("You must provide a number as an argument.");
        }

        int total = 0;

        for (int i = 0; i < args.length; i++) {

            int n = Integer.parseInt(args[i]);

            total += (n * n);
        }

        System.out.println("The square of the numbers and their sum is : " + total);

    }
}
