import java.util.Scanner;

class UserAuthSystem {

    static String storedUsername = "admin";
    static String storedPassword = "Admin@123";

    // Password validation method
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasUpper = false; 
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            // Password format check
            if (!isValidPassword(password)) {
                attempts--;
                System.out.println("Invalid Password Format!");
            }
            // Authentication check
            else if (username.equals(storedUsername) && password.equals(storedPassword)) {
                System.out.println("Login Successful");
                break;
            }
            // Wrong credentials
            else {
                attempts--;
                System.out.println("Invalid Credentials");
            }

            // Lock condition
            if (attempts == 0) {
                System.out.println("Account Locked  due to 3 invalid attempts.");
            } else {
                System.out.println("Attempts left: " + attempts);
            }
        }

        sc.close();
    }
}