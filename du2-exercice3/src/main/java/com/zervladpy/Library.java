package com.zervladpy;

import java.util.ArrayList;
import java.util.List;

/**
 * There are four students sharing nine books. The books can be stored in an
 * array. The students select two books at random and, once obtained, use them
 * for a random time of between one and three hours. After this time, they
 * return them, so that they can be used by other students, and rest for a
 * random time of between one and two hours. They then select another two books,
 * and the cycle continues. The Book class may not have any functionality beyond
 * having an identifier that can be used in messages referencing a book. The
 * simulation does not have to be in real time.
 */
public class Library {

    final static int N_BOOKS = 9;
    final static int N_STUDENT = 4;

    public static void main(String[] args) {

        List<Book> books = new ArrayList<Book>(N_BOOKS);
        for (int i = 0; i < N_BOOKS; i++) {
            books.add(new Book());
        }

        for (int i = 0; i < N_STUDENT; i++) {
            new Thread(new Student(books)).start();
        }

    }
}
