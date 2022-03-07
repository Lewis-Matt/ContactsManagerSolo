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
            selected = Integer.parseInt(sc.nextLine());
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
    public static String getPhoneNumber() {
        int enteredNumber = 0;
        try {
            // By parsing the user input as an integer, I can verify if only numbers were entered
            enteredNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Enter only numbers.");
            getPhoneNumber();
        }
        // Convert phone number to string
        return Integer.toString(enteredNumber);
    }
}
