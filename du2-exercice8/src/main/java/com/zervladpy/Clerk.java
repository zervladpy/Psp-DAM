package com.zervladpy;

public class Clerk implements Runnable {

    private TakeANumber takeANumber;

    public Clerk(TakeANumber gadget) {
        takeANumber = gadget;
    }

    public void run() {
        while (takeANumber.getServing() < takeANumber.getMaxClients()) {
            try {
                Thread.sleep((int) (Math.random() * 1000));
                takeANumber.nextCustomer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
