package com.zervladpy;

import java.lang.Runnable;

public class BallonBlower implements Runnable {

    private static int count = 0;
    private int id;
    private Ballons ballons;

    public BallonBlower(Ballons ballons) {
        this.id = ++count;
        this.ballons = ballons;
    }

    @Override
    public String toString() {
        return "BB" + id;
    }

    @Override
    public void run() {

        while (ballons.hasBallons()) {

            Ballon ballon = ballons.getBallonForBB();

            if (ballon != null) {
                ballons.inflate(ballon, this);
            }

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
