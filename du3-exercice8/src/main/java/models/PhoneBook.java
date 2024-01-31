package models;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private ArrayList<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public PhoneBook(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contact getContact(String name) {

        for (Contact contact: contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }

        return null;
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }
}
