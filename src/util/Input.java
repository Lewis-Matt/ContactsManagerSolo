package util;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

    // USER INPUT AS A STRING
    public static String getString() {
        return sc.next();
    }

    // USER INPUT AS A INT BETWEEN A MAX AND MIN
    public static int getInt(int min, int max) {
        int selected;
        try {
            selected = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Input was not an integer.");
            return getInt(min, max);
        }
        if (selected < min || selected > max) {
            System.out.println("Number was not between 1 - 5.");
            return getInt(min, max);
        } else {
            return selected;
        }
    }

    // USER INPUT AS A PHONE NUMBER
    // Sporadic issues with scanner,if I enter all numbers it will sometimes throw the error. It will let me re-enter a number, but it will have already stored '0' as the phone number in the text file.
    // Maybe try using getString() for enteredNumber... Or just get rid of the exception handling...
    public static String getPhoneNumber() {
        // Java didn't like this uninitialized, even though it is set in the 'try' block
        int enteredNumber = 0;
        try {
            // By parsing the user input as an integer, I can verify if only numbers were entered
            enteredNumber = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Exception: Enter only numbers.");
            getPhoneNumber();
        }
        // Convert phone number to string
        return Integer.toString(enteredNumber);
        // TODO: Format number with dashes
    }
}
