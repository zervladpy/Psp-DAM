package com.zervladpy;

import java.util.Random;
import java.lang.Runnable;

public class Collector implements Runnable {

    static private int counter = 0;
    private int id;

    private MailBox mailBox;

    public Collector(MailBox mailBox) {
        this.mailBox = mailBox;
        this.id = counter++;
    }

    @Override
    public void run() {

        while (true) {
            String message = this.mailBox.collect();
            System.out.println(this + " collected message: " + message);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "Collector " + this.id;
    }

}
