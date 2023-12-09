package com.zervladpy;

/**
 * A clerk in a bakery serves customers in the order they took their tickets.
 * Customers take tickets in a random order.
 * 
 * The program must simulate that 100 clients want to be served by the clerk.
 * When the clerk finishes serving the clients, the simulation must end.
 * 
 * The clerk takes a random time of no more than 1000ms to serve a customer.
 * 
 * Each client waits a random time between 20000 and 40000 milliseconds to take
 * a number after entering the bakery.
 * 
 * You have to use four classes in this project: Bakery (main), TakeANumber
 * (shared resource), Clerk and Customer.
 * 
 * The messages to be displayed during execution are:
 * 
 * Starting clerk and customer threads (simulation begins)
 * Clerk waiting (there are no clients to serve)
 * Customer #numClient takes ticket #numTicket
 * Clerk serving ticket #numTicket
 */

public class Backery {

    public static final int MAX_CLIENTS = 100;

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Starting clerk and customer threads");

        TakeANumber takeANumber = new TakeANumber(MAX_CLIENTS);

        Thread clerkThread = new Thread(new Clerk(takeANumber));

        clerkThread.start();

        for (int i = 0; i < MAX_CLIENTS; i++) {

            Thread customerThread = new Thread(new Customer(takeANumber));

            customerThread.start();

        }
    }
}