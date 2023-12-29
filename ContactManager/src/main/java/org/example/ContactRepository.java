package org.example;

import java.util.LinkedList;
import java.util.List;

public class ContactRepository {
    private final List<Contact> contacts = new LinkedList<>();

    public boolean save(Contact contact) {
        contacts.add(contact);
        return true;
    }

    public List<Contact> getList() {
        return contacts;
    }

    public boolean delete(String phone) {
        return contacts.removeIf(contact -> contact.getPhone().equals(phone));
    }

    public Contact getByPhone(String phone) {
        return contacts.stream().filter(contact -> contact.getPhone().equals(phone)).findFirst().orElse(null);
    }

    public Contact getByName(String name) {
        return contacts.stream().filter(contact -> contact.getName().equals(name)).findFirst().orElse(null);
    }
}
