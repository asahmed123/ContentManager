import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class to demonstrate the functionality of the Content and ContentManager
 * classes.
 */
public class Main {

    // Logger for this class
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Initialize ContentManager and Scanner objects
        ContentManager contentManager = new ContentManager();
        Scanner scanner = new Scanner(System.in);

        // Loop for menu options
        while (true) {
            try {
                               // Display menu
                LOGGER.info(String.format("%-10s %s", "1.", "Add Content"));
                LOGGER.info(String.format("%-10s %s", "2.", "Edit Content"));
                LOGGER.info(String.format("%-10s %s", "3.", "Delete Content"));  
                LOGGER.info(String.format("%-10s %s", "4.", "List Contents"));
                LOGGER.info(String.format("%-10s %s", "5.", "Exit"));

                // Input validation for user choice
                while (!scanner.hasNextInt()) {
                    LOGGER.info("Must enter a valid number from the list.");
                    scanner.next(); // Clear invalid input
                    LOGGER.info("Enter your choice: ");
                }

                // Get user choice
                LOGGER.info("Enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 5)
                    break; // Exit condition to break the loop
                scanner.nextLine(); // Consume newline

                // Perform actions based on user choice
                switch (choice) {
                    case 1:
                        // Add content
                        LOGGER.info("Enter title: ");
                        String title = scanner.nextLine();
                        LOGGER.info("Enter text content: ");
                        String textContent = scanner.nextLine();
                        LOGGER.info("Enter author: ");
                        String author = scanner.nextLine();
                        Content content = new Content(title, textContent, author);
                        contentManager.addContent(content);
                        LOGGER.info("Content added successfully.");
                        break;

                    case 2:
                        // Edit content
                        LOGGER.info("Enter index of content to edit: ");
                        int indexToEdit = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        LOGGER.info("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        LOGGER.info("Enter new text content: ");
                        String newTextContent = scanner.nextLine();
                        LOGGER.info("Enter new author: ");
                        String newAuthor = scanner.nextLine();
                        Content newContent = new Content(newTitle, newTextContent, newAuthor);
                        contentManager.editContent(indexToEdit, newContent);
                        LOGGER.info("Content edited successfully.");
                        break;

                    case 3:
                        // Delete content
                        LOGGER.info("Enter index of content to delete: ");
                        int indexToDelete = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        contentManager.deleteContent(indexToDelete);
                        LOGGER.info("Content deleted successfully.");
                        break;

                    case 4:
                        // List contents
                        contentManager.listContents();
                        break;

                    default:
                        LOGGER.info("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Exception occurred", e);
            }
        }
    }
}
