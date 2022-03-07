package util;

import java.util.Scanner;

public class Input {
    // METHOD TO GET USER INPUT (INT) FOR MENU METHOD
    public static int getInt(int min, int max) {
        Scanner sc = new Scanner(System.in);
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
}
