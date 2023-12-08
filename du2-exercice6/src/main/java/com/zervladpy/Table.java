package com.zervladpy;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<Material> materials = new ArrayList<Material>(2);

    synchronized void getMaterials(Smoker smoker) {

        while (this.materials.isEmpty() || this.materials.contains(smoker.getMaterial())) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(smoker + " with " + smoker.getMaterial() + " taked " + materials.toString()
                + " and now smoking");
        materials.clear();
        notifyAll();

    }

    synchronized void setMaterials(List<Material> materials) {
        while (!this.materials.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        this.materials = materials;
        notifyAll();

    }

}
