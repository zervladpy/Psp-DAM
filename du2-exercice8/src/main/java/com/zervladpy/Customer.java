package com.zervladpy;

import java.util.Random;

public class Customer implements Runnable {

    private static int number = 0;
    private int id;
    private TakeANumber takeANumber;

    public Customer(TakeANumber gadget) {
        id = ++number;
        takeANumber = gadget;
    }

    public void run() {
        try {

            Random random = new Random();
            Thread.sleep(random.nextInt(20000, 40000));
            takeANumber.nextNumber(id);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
