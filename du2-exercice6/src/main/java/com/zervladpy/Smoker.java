package com.zervladpy;

import java.lang.Runnable;

public class Smoker implements Runnable {

    private static int counter = 0;
    private int id;

    private Material material;
    private Table table;

    public Smoker(Material material, Table table) {
        this.id = counter++;
        this.material = material;
        this.table = table;
    }

    public Material getMaterial() {
        return this.material;
    }

    @Override
    public void run() {

        while (true) {
            table.getMaterials(this);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "Smoker " + this.id;
    }

}
