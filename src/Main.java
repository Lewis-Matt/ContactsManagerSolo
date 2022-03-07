import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.write;
import static util.Input.*;

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
            // Prints each line to console
            System.out.printf("%s%n", contactList.get(i));
        }
        System.out.println("----- END OF LIST -----");

        // Displays menu
        menu();
    }

    // TODO ADD CONTACT *************************************
    public static void addContact() throws IOException {
        System.out.println("Enter first name: ");
        String firstName = getString();
        System.out.println("Enter last name: ");
        String lastName = getString();
        System.out.println("Enter phone number: ");
        String phoneNumber = getPhoneNumber();

        // Create a new Contact from user input
        Contact newContact = new Contact(firstName, lastName, phoneNumber);
        // Format newContact
        String formattedContact = newContact.getFirstName() + " " + newContact.getLastName() + " | " + newContact.getPhoneNumber() + System.lineSeparator();

        // Write to contacts.txt
        Files.writeString(contactsPath, formattedContact, StandardOpenOption.APPEND);
        System.out.println("CONTACT ADDED");
        System.out.println("------------------");

        // TODO: Add functionality to check for duplicate contact

        // Displays menu
        menu();
    }

    // TODO SEARCH CONTACTS *************************************
    public static void searchContacts() throws IOException {
        System.out.println("Search by name: ");
        String searchQuery = getString();
        boolean exists = false;

        // TODO: This does not let me search for contacts added in the same session!
        //  ------ SOLVED ---> moved if(!exists) outside of forEach loop.
        // Read contacts.txt and put in temporary contact list
        List<String> contactList = Files.readAllLines(contactsPath);

        // Loop through each element (line of text) of contactList
        for (String contact : contactList) {
            // Normalize the searchQuery and entries in contact list
            // Note: wasn't working until I added extra parenthesis
            // contains() is looking for the occurrence of a char string
            if ((contact.toLowerCase()).contains((searchQuery.toLowerCase()))) {
                System.out.println(contact);
                System.out.println("------------------");
                exists = true;
            }
        }
        if (!exists) {
            System.out.println("CONTACT NOT FOUND");
            System.out.println("------------------");
        }
        // Displays menu
        menu();
    }

    // TODO DELETE CONTACT *************************************
    public static void deleteContact() throws IOException {
        System.out.println("Enter Last Name of contact to delete: ");
        String toDelete = getString();

        // Read contacts.txt and put in temporary contact list
        List<String> contactList = Files.readAllLines(contactsPath);
        for(String contact : contactList) {
            if (!contact.contains(toDelete)) {
                // loop thru contactList, add everything to a new list (except toDelete) and return newList



            }
        }
        menu();
    }

    // TODO ******************* MAIN **************************
    public static void main(String[] args) throws IOException {
        menu();
    }
}
