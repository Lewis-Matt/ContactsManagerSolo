import java.io.IOException;
import java.util.Scanner;

import static util.Input.getInt;

public class MAIN {

    // TODO MENU METHOD
    // throws IOException?
    public static void menu() throws IOException {
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option [1-5]: ");

        // Store user choice
        int selectedOption = getInt(1,5);

    }


    // TODO VIEW CONTACTS

    // TODO ADD CONTACT

    // TODO SEARCH CONTACTS

    // TODO DELETE CONTACT


    // ************************* MAIN **************************
    public static void main(String[] args) throws IOException {
        menu();
    }
}
