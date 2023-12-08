package com.zervladpy;

import java.util.Random;

public class ReadBook {

    public static boolean read(Book b1, Book b2, Student student) {

        Book bA, bB;
        boolean result = false;

        if (b1.getId() < b2.getId()) {
            bA = b1;
            bB = b2;
        } else {
            bA = b2;
            bB = b1;
        }

        synchronized (bA) {
            synchronized (bB) {
                Random random = new Random();

                long time = random.nextInt(1000) + 2000;

                System.out.println(student + " is reading " + bA + " and " + bB + " for " + time + " ms");
                try {
                    Thread.currentThread();
                    Thread.sleep(time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                result = true;
            }
        }

        return result;

    }

}
