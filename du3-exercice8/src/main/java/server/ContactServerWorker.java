package server;

import constraints.ClientPetitions;
import models.Contact;
import models.PhoneBook;
import constraints.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ContactServerWorker implements Runnable {
    private final PhoneBook phoneBook;
    private final DataOutputStream out;
    private final DataInputStream in;

    private boolean connected;

    public ContactServerWorker(
            DataInputStream in,
            DataOutputStream out
    ) {
        phoneBook = new PhoneBook();

        this.out = out;
        this.in = in;

        connected = true;
    }

    @Override
    public void run() {

        while (connected) {

            try {

                final String input = in.readUTF();

                System.out.println("CLEINT: " + input);

                // ADD NEW CONTACT
                if (input.contains(ClientPetitions.ADD.name())) {

                    final String[] command = input.split(" ");

                    if (command.length != 3) {
                        out.writeUTF(ServerResponses.ERROR.name());
                    } else {

                        String name = command[1], phone = command[2];

                        if (phoneBook.getContact(name) == null) {
                            System.out.println("a");
                            phoneBook.add(new Contact(name, phone));
                            out.writeUTF(ServerResponses.ACCEPTED.name());
                        } else {
                            System.out.println("b");
                            out.writeUTF(ServerResponses.REJECTED.name());
                        }

                    }
                }

                // FIND CONTACT
                if (input.contains(ClientPetitions.FIND.name())) {
                    final String[] command = input.split(" ");

                    if (command.length == 2) {

                        String name = command[1];
                        System.out.println(name);
                        final Contact contact = phoneBook.getContact(name);

                        if (contact != null) {
                            out.writeUTF(contact.toString());
                        } else {
                            out.writeUTF(ServerResponses.ACCEPTED.name());
                        }
                    } else {
                        out.writeUTF(ServerResponses.REJECTED.name());
                    }
                }

                // EXIT
                if (input.contains(ClientPetitions.EXIT.name())) {
                    out.writeUTF(ServerResponses.BYE.name());
                    connected = false;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
