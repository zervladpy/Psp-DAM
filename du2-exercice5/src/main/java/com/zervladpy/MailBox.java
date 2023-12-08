package com.zervladpy;

public class MailBox {

    private String message;

    public synchronized void deposit(String message) {
        while (this.message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        notifyAll();
    }

    public synchronized String collect() {
        while (this.message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String message = this.message;
        this.message = null;
        notifyAll();
        return message;
    }

}
