package com.zervladpy;

import java.lang.Runnable;

public class BallonPricker implements Runnable {

    private static int count = 0;
    private int id;
    private Ballons ballons;

    public BallonPricker(Ballons ballons) {
        this.id = ++count;
        this.ballons = ballons;
    }

    @Override
    public String toString() {
        return "BP" + id;
    }

    @Override
    public void run() {

        while (ballons.hasBallons()) {

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ballons.prick(this);

        }

    }

}
