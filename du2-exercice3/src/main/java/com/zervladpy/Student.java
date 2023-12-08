package com.zervladpy;

import java.util.List;
import java.util.Random;
import java.lang.Runnable;
import java.lang.Thread;

public class Student implements Runnable {

    private static int count = 0;
    private int id;

    private List<Book> books;

    public Student(List<Book> books) {
        id = count;
        this.books = books;
        count++;

    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }

    @Override
    public void run() {

        System.out.println(this + " is starting");

        while (true) {
            Random random = new Random();
            Book b1 = books.get(random.nextInt(books.size()));
            Book b2;
            do {
                b2 = books.get(random.nextInt(books.size()));
            } while (b1 == b2);

            try {
                ReadBook.read(b1, b2, this);
                Thread.currentThread();
                Thread.sleep(random.nextInt(1000) + 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
