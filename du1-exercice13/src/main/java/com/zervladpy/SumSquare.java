package com.zervladpy;

public class SumSquare {
    public static void main(String[] args) {

        if (args.length < 1) {
            throw new IllegalArgumentException("You must provide a number as an argument.");
        }

        int total = 0;

        for (int i = 0; i < args.length; i++) {
            total += Integer.parseInt(args[i]);
        }

        total *= total;

        System.out.println("The square of the sum is: " + total);

    }
}
