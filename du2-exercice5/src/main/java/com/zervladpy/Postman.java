package com.zervladpy;

import java.util.Random;
import java.lang.Runnable;

public class Postman implements Runnable {

    private MailBox mailBox;

    static private int counter = 0;
    private int id;

    public Postman(MailBox mailBox) {
        this.mailBox = mailBox;
        this.id = counter++;
    }

    public void run() {
        while (true) {
            String message = "Message from " + this;
            this.mailBox.deposit(message);
            System.out.println("Postman " + this + " deposited message: " + message);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Postman " + this.id;
    }

}
