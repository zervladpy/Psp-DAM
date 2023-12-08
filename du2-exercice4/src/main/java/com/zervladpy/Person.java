package main.java.com.zervladpy;

import java.lang.Runnable;;

public class Person implements Runnable {

    private static int count = 0;
    private int id;
    private boolean isTeacher;
    private Greeting greet;

    public Person(boolean isTeacher, Greeting greeting) {
        this.id = count++;
        this.isTeacher = isTeacher;
        this.greet = greeting;
    }

    @Override
    public void run() {

        if (isTeacher) {
            greet.teacherGreet(this);
        } else {
            greet.studentGreet(this);
        }
    }

    @Override
    public String toString() {
        return isTeacher ? "Teacher " + id + ": " : "Student " + id + ": ";
    }
}
