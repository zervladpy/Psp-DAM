package com.zervladpy;

/**
 * Make an application composed of four classes:
 * 
 * BalloonBlower (BB) (in charge of blowing up the balloons)
 * BalloonPricker (BP) (in charge of pricking the balloons)
 * Balloons (storage of balloons)
 * MainBalloons (contains the main code and instantiates the rest)
 * In relation to the Balloons class, there will be 1 instance of this class.
 * 
 * There will be a maximum of 10 balloons in the warehouse. They will be
 * delivered one by one, numbered from 1 to 10. Each balloon can be blown up
 * until it burst or pricks. Only 3 balloons can be blown up at a time. The
 * balloons will have a volume of 0 to 5 litres. When trying to fill a balloon
 * to more than 5 litres, it will burst. Each balloon is delivered with an
 * initial volume of 0 litres. Balloons can be pricked while they are being
 * blown up.
 * 
 * Display a message with the balloon number each time:
 * 
 * A balloon is delivered to a balloon blower. Example: Balloon 5 delivered to
 * BB3.
 * A balloon is being blown up. In this situation we will indicate the new
 * volume. Example: Balloon 5 gets volume 5.
 * A balloon bursts due to over-blowing. Example: Balloon 5 bursts.
 * A BP pricks a balloon. Example: Balloon 5 pricked by BP3.
 * In relation to the BalloonBlower class, we will have 5 threads implementing
 * this class.
 * 
 * Balloon blowers will obtain a balloon from the balloon storage if possible.
 * Only three balloons can be blown up at the same time. If there are already
 * three balloons blowing up, blowers must wait until one of the balloons burst
 * or pricks. Each second each balloon being blown up will increase its volume
 * in 1 liter. When a balloon burst or pricks, the balloon blower has to take
 * another balloon if any.
 * 
 * In relation to the BalloonPricker class, we will have 5 threads implementing
 * of this class.
 * 
 * Balloon prickers have to try to prick one of the balloons that is being
 * blowing up every random time from 1 to 10 seconds. If there are no balloons
 * to prick, they will wait if there are balloons left to prick.
 * 
 */

public class MainBallons {

    static final int MAX_BALLOONS = 10;
    static final int MAX_INFLATING_BALLOONS = 3;
    static final int MAX_BLOWERS = 5;
    static final int MAX_PRICKERS = 5;

    public static void main(String[] args) {

        Ballons ballons = new Ballons(MAX_BALLOONS, MAX_INFLATING_BALLOONS);

        for (int i = 0; i < MAX_BLOWERS; i++) {
            new Thread(new BallonBlower(ballons)).start();
            new Thread(new BallonPricker(ballons)).start();
        }

    }
}