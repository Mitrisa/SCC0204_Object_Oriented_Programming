// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessôto 13749653

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Objects;

public class UserManager {
    // Setting up the arrays that store the information on the file
    private String[] usernames;
    private String[] passwords;
    private int[] ids;
    // Counts the amount of users at the moment
    private int count;
    // Logger that will keep track of the exceptions
    private static final Logger logger = Logger.getLogger(UserManager.class.getName());

    public UserManager() {
        // Maximum number of users is 100
        usernames = new String[100];
        passwords = new String[100];
        ids = new int[100];
        // No users at the start
        count = 0;
        // Starting the logger
        configureLogger();
    }

    private void configureLogger() {
        // Trying to connect the logger to the error.log file
        try {
            FileHandler fileHandler = new FileHandler("error.log");//redirecionar mensagens de erro para o arquivo
            fileHandler.setFormatter(new SimpleFormatter());//define o formato das mensagens como simples
            logger.addHandler(fileHandler);//adiciona o FileHander ao logger
        } catch (IOException e) { // If connection fails
            logger.severe("Error setting up logger: " + e.getMessage());//roblema em config o logger
        }
    }

    public void login(String username, String password) {
        // Trying to find a user and  password in the array
        try {
            for (int i = 0; i < count; i++) {
                if (Objects.equals(username, usernames[i])) {
                    if (Objects.equals(password, passwords[i])) {
                        System.out.println("User " + username + " logged-in");
                    }
                }
            }
        } catch (NullPointerException e) {
            logger.severe("NullPointerException occurred: " + e.getMessage());
        }
    }

    public void fetchUserData(String idString) {
        // Using the id to find a user and password
        try {
            int id = Integer.parseInt(idString); // Trying to convert the String to an integer
            boolean found = false; // Checks if the user was found
            for (int i = 0; i < count; i++) {
                if (id == ids[i]) {
                    System.out.println("User: " + usernames[i] + "\nPassword: " + passwords[i]);
                    found = true;
                }
            }
            if (!found){
                System.out.println("Unable to find the user ID.");
            }
        } catch (NumberFormatException e) { // If id is not a number
            logger.severe("NumberFormatException occurred: Invalid ID format.");
            System.out.println("Please enter a valid user ID.");
        }
    }

    // Updates an existing user or create a new one if id is not found
    public void updateUserData(int id, String username, String password) {
        try {
            boolean found = false; // Checks if the user was found
            // Existing user
            for (int i = 0; i < count; i++) {
                if (id == ids[i]) {
                    // Changes the user data
                    usernames[i] = username;
                    passwords[i] = password;
                    found = true; // Updates flag so it doesn't enter the next if
                    System.out.println("Updated user info! User: " + username + " \nPassword: " + password);
                }
            }
            // New user
            if (!found) {
                // Initializes users data
                usernames[count] = username;
                passwords[count] = password;
                ids[count] = id;
                count++; // Updates the counter
                System.out.println("New user added! User: " + username + "\nPassword: " + password);
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            logger.severe("Exception occurred: " + e.getMessage());
        }
    }

    // Reads the file and puts the information in the arrays
    public void startup(String file) {
        Scanner inputFile;
        try {
            File myFile = new File(file);
            inputFile = new Scanner(myFile);
            // Reads file
            while (inputFile.hasNextLine()) {
                usernames[count] = inputFile.nextLine();
                passwords[count] = inputFile.nextLine();
                ids[count] = Integer.parseInt(inputFile.nextLine());
                count++; // Updates the counter
            }
            // Closes file
            inputFile.close();
        } catch (FileNotFoundException e) {
            logger.severe("FileNotFoundException occurred: " + e.getMessage());
        } catch (NullPointerException | NumberFormatException e) {
            logger.severe("Exception occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        UserManager user = new UserManager();// Create UserManager object
        // Insert path to text file
        user.startup("C:\\Users\\isa_g\\OneDrive\\Documentos\\POO\\ex13\\POOex13data.txt");

        // Invalid user login
        user.login("User0","abc");
        // Valid user login
        user.login("User1","1234");

        // Invalid user fetch data
        user.fetchUserData("10");
        user.fetchUserData("abcde");
        // Valid user fetch data
        user.fetchUserData("3");

        // Updating user
        user.updateUserData(5, "User5att","password1" );
        // Creating new user
        user.updateUserData(6, "newuser", "newpassword");

    }
}
