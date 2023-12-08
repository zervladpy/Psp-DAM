package com.zervladpy;

import java.util.Random;

public class HiddenNumber {

    private int hiddenNumber;
    private int gamseStatus = 0;

    public HiddenNumber(int minValue, int maxValue) {
        this.hiddenNumber = new Random().nextInt(minValue, maxValue);
    }

    public int numberGuess(int num) {
        if (gamseStatus == 0) {
            if (num == hiddenNumber) {
                gamseStatus = 1;
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

}
