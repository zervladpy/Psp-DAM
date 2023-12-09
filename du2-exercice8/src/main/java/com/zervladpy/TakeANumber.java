package com.zervladpy;

public class TakeANumber {

    private int next = 0;
    private int serving = 0;

    public int getMaxClients() {
        return maxClients;
    }

    private int maxClients = 0;

    public synchronized int getServing() {
        return serving;
    }

    public TakeANumber(int maxClients) {
        this.maxClients = maxClients;
    }

    public synchronized int nextNumber(int custId) throws InterruptedException {
        next = next + 1;
        System.out.println("Customer " + custId + " takes ticket " + next);
        notifyAll();
        return next;
    }

    public synchronized int nextCustomer() {
        try {
            while (next <= serving) {
                System.out.println("Clerk waiting ");
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception " + e.getMessage());
        } finally {
            ++serving;
            System.out.println("Clerk serving ticket " + serving);
            notifyAll();
        }

        return serving;
    }

}
