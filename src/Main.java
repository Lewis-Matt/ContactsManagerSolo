import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
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
        // Cases 1 - 5 -
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

    // Not sure if these methods should be in a separate class?
    // TODO VIEW CONTACTS *************************************
    public static void viewContacts() throws IOException {
        // Read contacts.txt and put in temporary contact list
        List<String> contactList = Files.readAllLines(contactsPath);

        // Loop through each element (lines of text) of contactList
        for (String line : contactList) {
            // Prints each line/contact to console
            System.out.printf("%s%n", line);
        }
        System.out.println("----- END OF LIST -----");

        // TODO: Format contacts so the spacing is consistent (loop through length of longest sting?)

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

        // Create a new Contact from user input (not technically needed - could have just formatted the above)
        Contact newContact = new Contact(firstName, lastName, phoneNumber);
        // Format newContact
        String formattedContact = newContact.getFirstName() + " " + newContact.getLastName() + " | " + newContact.getPhoneNumber() + System.lineSeparator();

        // Write to contacts.txt
        // For now, had to manually set up the contacts.txt to have a newline after the last contact, otherwise this appends to the end of the previous contact (on the same line)
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
            // Note: wasn't working until I added parenthesis enclosing entire .toLowerCase methods
            // contains() is looking for the occurrence of the sequence of chars
            if ((contact.toLowerCase()).contains((searchQuery.toLowerCase()))) {
                System.out.println(contact);
                System.out.println("------------------");
                exists = true;
            } // No 'else' needed, as exists will continue to = false
        }
        // If it is true that 'exists' is not true:
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
        List<String> originalContactList = Files.readAllLines(contactsPath);
        // Create a new list to push contacts to
        List<String> modifiedContactList = new ArrayList<>();
        for (String contact : originalContactList) {
            if (!contact.contains(toDelete)) {
                // Loop through existing contacts, add everything to the new list (except toDelete)
                modifiedContactList.add(contact);
            }
        }
        // Write the new list to contacts.txt (replaces/overwrites).
        Files.write(contactsPath, modifiedContactList);
        System.out.println("CONTACT DELETED");
        System.out.println("------------------");
        menu();
    }

    // TODO ******************* MAIN **************************
    public static void main(String[] args) throws IOException {
        menu();
    }
}
