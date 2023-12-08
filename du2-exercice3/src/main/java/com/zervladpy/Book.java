package com.zervladpy;

public class Book {

    private static int count = 0;
    private int id;

    public Book() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + "]";
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)) {
            return false;
        } else {
            Book other = (Book) obj;
            return hashCode() == other.hashCode();
        }
    }

}
