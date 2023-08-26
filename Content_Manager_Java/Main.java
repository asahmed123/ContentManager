import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class to demonstrate the functionality of the Content and ContentManager classes.
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
                System.out.println("Content Manager Menu:");
                System.out.println("1. Add Content");
                System.out.println("2. Edit Content");
                System.out.println("3. Delete Content");
                System.out.println("4. List Contents");
                System.out.println("5. Exit");

                // Get user choice
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                // Perform actions based on user choice
                switch (choice) {
                    case 1:
                        // Add content
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter text content: ");
                        String textContent = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        Content content = new Content(title, textContent, author);
                        contentManager.addContent(content);
                        System.out.println("Content added successfully.");
                        break;

                    case 2:
                        // Edit content
                        System.out.print("Enter index of content to edit: ");
                        int indexToEdit = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new text content: ");
                        String newTextContent = scanner.nextLine();
                        System.out.print("Enter new author: ");
                        String newAuthor = scanner.nextLine();
                        Content newContent = new Content(newTitle, newTextContent, newAuthor);
                        contentManager.editContent(indexToEdit, newContent);
                        System.out.println("Content edited successfully.");
                        break;

                    case 3:
                        // Delete content
                        System.out.print("Enter index of content to delete: ");
                        int indexToDelete = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        contentManager.deleteContent(indexToDelete);
                        System.out.println("Content deleted successfully.");
                        break;

                    case 4:
                        // List contents
                        contentManager.listContents();
                        break;

                    case 5:
                        // Exit
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Exception occurred", e);
            }
        }
    }
}
