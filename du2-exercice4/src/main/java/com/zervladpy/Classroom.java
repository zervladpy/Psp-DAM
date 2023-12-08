package com.zervladpy;

import java.util.Random;

/**
 * We want to create a multithreaded application.
 * 
 * In the application we want to consider two types of people: students and
 * teachers. We will use a Person class for both students and teachers.
 * 
 * The task to be performed by both students and teachers is to greet each
 * other. To perform this task, both students and teachers will share an object
 * of the Greeting class.
 * 
 * When a teacher arrives in a classroom he/she greets.
 * 
 * When a student arrives in a classroom, if the teacher has not arrived, waits
 * for the teacher to arrive. In case the teacher has arrived before the
 * student, the student should greet the teacher and apologise for the delay.
 * 
 * We want to perform a simulation with 20 students and one teacher.
 *
 */
public class Classroom {

    static final int STUDENTS = 20;

    public static void main(String[] args) {

        Greeting greeting = new Greeting();

        int teacher = new Random().nextInt(STUDENTS);

        for (int i = 0; i < STUDENTS; i++) {
            if (i == teacher - 1) {
                new Thread(new Person(true, greeting)).start();
            } else {
                new Thread(new Person(false, greeting)).start();
            }
        }

    }
}
