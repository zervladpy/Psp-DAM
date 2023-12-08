package com.zervladpy;

public class Greeting {

    private boolean teacherArrived = false;

    public synchronized void teacherGreet(Person teacher) {
        System.out.println(teacher + "Hello Students!");

        teacherArrived = true;
        try {
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void studentGreet(Person student) {

        if (teacherArrived) {
            System.out.println(student + "Hello Teacher! Sorry for being late.");
        } else {
            while (!teacherArrived) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(student + "Hello Teacher!");
        }

    }

}
