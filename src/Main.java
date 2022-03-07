import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static util.Input.getInt;

public class Main {
    // Path to contacts.txt
    static Path contactsPath = Paths.get("data", "contacts.txt");
    // TODO SHOW MENU TO USER *************************************
    public static void menu() throws IOException {
        // Menu options
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
        // Read contacts.txt and put in temporary contact list
        List<String> contactList = Files.readAllLines(contactsPath);
        // Loop through each element (lines of text) of contactList
        for (int i = 0; i < contactList.size(); i++) {
            System.out.printf("%s%n",contactList.get(i));
        }

        menu();
    }

    // TODO ADD CONTACT *************************************
    public static void addContact() throws IOException {

        menu();
    }

    // TODO SEARCH CONTACTS *************************************
    public static void searchContacts() throws IOException {

        menu();
    }

    // TODO DELETE CONTACT *************************************
    public static void deleteContact() throws IOException {

        menu();
    }

    // TODO ******************* MAIN **************************
    public static void main(String[] args) throws IOException {
        menu();
    }
}
