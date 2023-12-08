package com.zervladpy;

import java.util.ArrayList;
import java.util.Random;

public class Seller implements Runnable {

    private Random random = new Random();

    private Table table;

    public Seller(Table table) {
        this.table = table;
    }

    @Override
    public void run() {

        while (true) {

            var materials = new ArrayList<Material>();

            while (materials.size() < 2) {

                var material = Material.values()[random.nextInt(3)];

                if (!materials.contains(material)) {
                    materials.add(material);
                }

            }

            table.setMaterials(materials);

            System.out.println(this + " put " + materials.toString() + " on the table");

        }

    }

    @Override
    public String toString() {
        return "Seller";
    }

}
