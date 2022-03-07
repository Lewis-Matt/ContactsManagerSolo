import java.io.IOException;

import static util.Input.getInt;

public class Main {

    // TODO SHOW MENU TO USER *************************************
    public static void menu() throws IOException {
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option [1-5]: ");

        // Store user choice
        int selectedOption = getInt(1, 5);

        // Cases 1 - 5
        switch (selectedOption) {
            case 1:
                viewContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContacts();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                System.out.println("Exiting...");
                break;
        }
    }

    // TODO VIEW CONTACTS *************************************
    public static void viewContacts() throws IOException {

    }

    // TODO ADD CONTACT *************************************
    public static void addContact() throws IOException {

    }

    // TODO SEARCH CONTACTS *************************************
    public static void searchContacts() throws IOException {

    }

    // TODO DELETE CONTACT *************************************
    public static void deleteContact() throws IOException {

    }

    // TODO ******************* MAIN **************************
    public static void main(String[] args) throws IOException {
        menu();
    }
}
