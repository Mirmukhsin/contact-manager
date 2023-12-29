package org.example;

public class Controller {
    private final ContactService service = new ContactService();
    private final ScannerService scanner = new ScannerService();
    private int i = 0;

    public void start() {
        boolean status = true;
        while (status) {
            showMenu();
            int action = getAction();
            switch (action) {
                case 1: {
                    System.out.println("\n<---- Add Contact Menu ---->");
                    add();
                    break;
                }
                case 2: {
                    System.out.println("\n<---- Contact List Menu ---->");
                    list();
                    break;
                }
                case 3: {
                    System.out.println("\n<---- Delete Contact Menu ---->");
                    delete();
                    break;
                }
                case 4: {
                    System.out.println("\n<---- Search Contact Menu ---->");
                    search();
                    break;
                }
                case 0: {
                    System.out.println("Good Bye!");
                    status = false;
                    break;
                }
            }
        }
    }


    public void showMenu() {
        System.out.println();
        System.out.println("*** Menu ***");
        System.out.println("1. Add Contact");
        System.out.println("2. Contact List");
        System.out.println("3. Delete Contact");
        System.out.println("4. Search Contact");
        System.out.println("0. Exit");
    }

    private int getAction() {
        System.out.print("Choose Action: ");
        return scanner.getNumScan().nextInt();
    }

    public void add() {
        do {
            System.out.print("\nEnter name: ");
            String name = scanner.getStrScan().next();
            System.out.print("Enter surname: ");
            String surname = scanner.getStrScan().next();
            System.out.print("Enter phone: ");
            String phone = scanner.getStrScan().next();
            Contact contact = Contact.builder()
                    .name(name)
                    .surname(surname)
                    .phone(phone)
                    .build();
            service.addContact(contact);

            System.out.print("\n1.Again  <>  0.Back  : ");
            i = scanner.getNumScan().nextInt();
        } while (i == 1);
    }

    public void list() {
        service.contactList();
    }

    public void delete() {
        do {
            System.out.print("\nEnter phone: ");
            String phone = scanner.getStrScan().next();
            service.deleteContact(phone);

            System.out.print("\n1.Again  <>  0.Back  : ");
            i = scanner.getNumScan().nextInt();
        } while (i == 1);
    }

    public void search() {
        do {
            System.out.print("\nEnter name: ");
            String name = scanner.getStrScan().next();
            service.searchContact(name);

            System.out.print("\n1.Again  <>  0.Back  : ");
            i = scanner.getNumScan().nextInt();
        } while (i == 1);
    }
}