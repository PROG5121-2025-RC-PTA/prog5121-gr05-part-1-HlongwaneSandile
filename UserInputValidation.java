
import java.util.Scanner;

public class UserInputValidation {
    private String username;
    private String password;
    private String firstName;
    private String phoneNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInputValidation app = new UserInputValidation();

        // Registration process to see wether its accepting the users login
        String registrationMessage = app.registerUser(scanner);
        System.out.println(registrationMessage);

        // Checking if the registration was successful before proceeding to login into the main chat
        if (registrationMessage.contains("successful")) {
            System.out.print("Enter your username to log in: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = scanner.nextLine();

            String loginMessage = app.authenticateUser(loginUsername, loginPassword);
            System.out.println(loginMessage);
        } else {
            System.out.println("Please try registering again.");
        }

        scanner.close();
    }

    // Method where the user should enter his or her details or information
    /// I got this from youtube tutorials on how to print out the code 
    private String registerUser(Scanner scanner) {
        System.out.print("Please Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Please Enter your username (must contain an underscore and be no longer than five characters): ");
        username = scanner.nextLine();

        if (!checkUserName(username)) {
            return "Invalid username. It must contain an underscore and be no longer than five characters.";
        }

        System.out.print("Please Enter your password (at least 8 characters long): ");
        password = scanner.nextLine();

        if (!checkPasswordComplexity(password)) {
            return "Invalid password. It must be at least 8 characters long.";
        }

        System.out.print("Please Enter your South African cell phone number (must start with '+27' and be 13 characters long): ");
        phoneNumber = scanner.nextLine();

        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Invalid phone number. It must start with '+27' and be exactly 13 characters long.";
        }

        return "Registration successful! You can now log in.";
    }

    // Method on how to print out the information
    private String authenticateUser(String inputUsername, String inputPassword) {
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            return "Welcome " + firstName + ", you are logged in.";
        } else {
            return "Username or password incorrect.";
        }
    }

    // method that validates the username of user
    private boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // method to validate the phone number or digits
    private boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("+27") && phoneNumber.length() == 13;
    }

    // method on how to login using the password
    private boolean checkPasswordComplexity(String password) {
        return password.length() >= 8; // Simple check for length
    }
}