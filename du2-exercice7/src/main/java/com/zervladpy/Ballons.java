package com.zervladpy;

import java.util.ArrayList;
import java.util.List;

public class Ballons {

    private List<Ballon> ballons;

    private int inflatingBalloons = 0;
    private int maxInflatingBallons;

    public Ballons(int maxBalloons, int maxInflatingBallons) {
        this.ballons = new ArrayList<Ballon>(maxBalloons);
        for (int i = 0; i < maxBalloons; i++) {
            ballons.add(new Ballon());
        }
        this.maxInflatingBallons = maxInflatingBallons;
    }

    synchronized void inflate(Ballon ballon, BallonBlower ballonBlower) {

        while (!ballon.isBurst()) {
            ballon.inflate();
            System.out.println(
                    "\u001B[32m" + ballonBlower + "\u001B[0m" + " is inflating " + "\u001B[33m" + ballon + "\u001B[0m");
            try {
                wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        --inflatingBalloons;

    }

    synchronized void prick(BallonPricker ballonPricker) {

        for (Ballon ballon : ballons) {
            if (ballon.isInflating() && !ballon.isBurst()) {
                ballon.burst();
                System.out.println(
                        "\u001B[35m" + ballonPricker + "\u001B[0m" + " pricked " + "\u001B[31m" + ballon + "\u001B[0m");
                --inflatingBalloons;
                notifyAll();
                break;
            }
        }

    }

    synchronized Ballon getBallonForBB() {

        while (inflatingBalloons >= maxInflatingBallons) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Ballon ballon : ballons) {
            if (!ballon.isInflating() && !ballon.isBurst()) {
                ballon.setInflating(true);
                inflatingBalloons++;
                return ballon;
            }
        }

        return null;

    }

    synchronized boolean hasBallons() {
        for (Ballon ballon : ballons) {
            if (!ballon.isBurst()) {
                return true;
            }
        }
        return false;
    }

}
