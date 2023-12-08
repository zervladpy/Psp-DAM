package com.zervladpy;

/**
 * Suppose we want to implement a synchronized application with a Mailbox class
 * that allows one thread to deposit a message and another thread to pick it up.
 * But, there can only be one message in the mailbox at a time. If a thread
 * tries to deposit a message when there is already one, it must wait until it
 * is collected. And if a thread tries to pick up a message when there is none,
 * it must wait until one is deposited.
 * 
 * After a message is deposited or collected, each thread sleeps for a random
 * amount of time to repeat the cycle again.
 * 
 * First, the application must work with one thread depositing messages and one
 * thread collecting messages.
 * 
 * Finally, the application must run with five threads of each type.
 *
 */
public class MailThread {

    final static int NUMBER_OF_POSTMEN = 5;
    final static int NUMBER_OF_COLLECTORS = 5;

    public static void main(String[] args) {

        MailBox mailBox = new MailBox();

        for (int i = 0; i < NUMBER_OF_POSTMEN; i++) {
            new Thread(new Postman(mailBox)).start();
        }

        for (int i = 0; i < NUMBER_OF_COLLECTORS; i++) {
            new Thread(new Collector(mailBox)).start();
        }

    }
}
