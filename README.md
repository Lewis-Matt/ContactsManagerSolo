# ContactsManagerSolo
### Summary and Lessons Learned
Command Line Application that mimics a rolodex™
- Created util package with methods for getting user input as integer, string, and as a phone number
- Created Contact Class, which was mostly unused (New Contact was created just for the addContact method)
- Normalize data/input for easier comparison
- Files.write vs Files.writeString
- Using .next was more consistent than using .nextLine for Scanner
- Separating reusable methods into a new class
- Everything File IO throws IOException - have to add to every method signature
- All methods within Main set to static, as a instance of the class will never be created (main method is within the Main class)

### Issues
- getPhoneNumber() will throw the exception randomly (even if Integers were entered correctly)
- Finish bonus TODO blocks

## Requirements:
The application should be able to:

    Show all your contacts
    Add a new contact
    Search a contact by her name
    Delete an existing contact

The application should keep its data in a file named contacts.txt so that the information persists between runs of the application.

    The text file should contain one contact per line.
    When the application starts, the contact list should be read from the file.
    Before the application exits, the contacts file should be rewritten.
    The user interface for your application should include a main menu like the following, where the user will need to enter a number between 1 and 5:

1. View contacts.
2. Add a new contact.
3. Search a contact by name.
4. Delete an existing contact.
5. Exit.
   Enter an option (1, 2, 3, 4 or 5):

   The contacts information should be shown using the following format
<p>
Name | Phone number <br>
-------------------------------- <br>
Jack Blank | 1231231234 <br>
Jane Doe | 2342342345 <br>
Sam Space | 3453453456 <br>
</p>
<hr>
TODO: Bonus

    Format the phone numbers using dashes:

    instead of 8675309, your output should display 867-5309

    Allow formatting phone numbers with different lengths. For example, phone numbers can have 10 or 7 digits. You can be even more creative here and allow international phone numbers.

    Warn the user when she tries to enter a contact with an existing name.

    Format the output of the contacts, so that all of the columns have the same width.

Name       | Phone number |
---------------------------
Jack Blank | 210-567-8923 |
Jane Doe   | 789-8902     |
Sam Space  | 210-581-8123 |

Hint: you can use format strings with the System.our.printf or String.format methods to ensure the columns have the same width.