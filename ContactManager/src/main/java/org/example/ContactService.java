package org.example;

import java.util.List;

public class ContactService {
    private final ContactRepository repository = new ContactRepository();

    public void addContact(Contact contact) {
        Contact exists = repository.getByPhone(contact.getPhone());
        if (exists != null) {
            System.out.println("PHONE ALREADY EXISTS.");
            return;
        }
        boolean result = repository.save(contact);
        if (result) {
            System.out.println("Contact saved!");
        } else {
            System.out.println("SOMETHING WENT WRONG.");
        }
    }

    public void contactList() {
        List<Contact> contacts = repository.getList();
        if (!contacts.isEmpty()) {
            for (Contact contact : contacts) {
                System.out.println("NAME: " + contact.getName());
                System.out.println("SURNAME: " + contact.getSurname());
                System.out.println("PHONE: " + contact.getPhone());
                System.out.println("><><><><><><><><><><><><><><><>");
            }
        }else {
            System.out.println("NO CONTACTS.");
        }
    }

    public void deleteContact(String phone) {
        boolean result = repository.delete(phone);
        if (result) {
            System.out.println("Contact deleted!");
        } else {
            System.out.println("CONTACT NOT EXISTS.");
        }
    }

    public void searchContact(String name) {
        Contact contact = repository.getByName(name);
        if (contact != null) {
            System.out.println("NAME: " + contact.getName());
            System.out.println("SURNAME: " + contact.getSurname());
            System.out.println("PHONE: " + contact.getPhone());
        }else {
            System.out.println("CONTACT NOT EXISTS.");
        }
    }
}
