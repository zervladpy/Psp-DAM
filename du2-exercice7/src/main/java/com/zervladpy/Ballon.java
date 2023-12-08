package com.zervladpy;

public class Ballon {

    private static int count = 0;
    private int id;

    private int volume = 0;
    private boolean burst = false;

    private boolean isInflating = false;

    public Ballon() {
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public void inflate() {
        if (volume < 5) {
            volume++;
        } else {
            burst();
        }
    }

    public boolean isBurst() {
        return burst;
    }

    public void burst() {
        burst = true;
    }

    @Override
    public String toString() {
        return "Ballon " + id + " (" + volume + " litres)";
    }

    public static int getCount() {
        return count;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isInflating() {
        return isInflating;
    }

    public void setInflating(boolean isInflating) {
        this.isInflating = isInflating;
    }

}
