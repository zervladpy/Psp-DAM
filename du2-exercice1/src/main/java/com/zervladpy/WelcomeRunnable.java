package com.zervladpy;

import java.util.Random;

/**
 * Create a Java class that implements the Runnable interface.
 * 
 * The run() method of the class must do the following:
 * 
 * Display a welcome message with the name of the current thread.
 * Repeat five times:
 * Get a random number between 10 and 500 (use java.util.Random).
 * Pause the execution of the current thread for the number of miliseconds equal
 * to the random number obtained above.
 * Display a goodbye message with the name of the current thread.
 * Create a Java executable class to launch two threads created using the
 * previous class. Thie main thread waits for the other two threads to finish
 * and then displays a message indicating that it has finished.
 *
 */
public class WelcomeRunnable {

    final static int N_THREADS = 5;
    final static int MIN_SLEEP_TIME = 10;
    final static int MAX_SLEEP_TIME = 500;

    public static void main(String[] args) {

        for (int i = 0; i < N_THREADS; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {

                    Random random = new Random();

                    int sleepTime = random.nextInt(MIN_SLEEP_TIME, MAX_SLEEP_TIME);

                    System.out.println("Hello from thread " + this.getName());

                    try {
                        Thread.sleep(sleepTime);
                        System.out.println("Goodbye from thread " + this.getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };

            thread.start();
        }

    }
}
