import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ContentManager class to manage a list of Content objects.
 */
public class ContentManager {

    // Logger for this class
    private static final Logger LOGGER = Logger.getLogger(ContentManager.class.getName());

    // Constant for the exception message
    private static final String EXCEPTION_MESSAGE = "Exception occurred";

    // List to store Content objects
    private List<Content> contents;

    // Constructor to initialize the ContentManager object
    public ContentManager() {
        this.contents = new ArrayList<>();
    }

    // Method to add a Content object to the list
    public void addContent(Content content) {
        try {
            if (content == null) {
                throw new IllegalArgumentException("Content object cannot be null.");
            }
            contents.add(content);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    // Method to edit a Content object in the list
    public void editContent(int index, Content newContent) {
        try {
            if (index < 0 || index >= contents.size() || newContent == null) {
                throw new IllegalArgumentException("Invalid index or new content.");
            }
            contents.set(index, newContent);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    // Method to delete a Content object from the list
    public void deleteContent(int index) {
        try {
            if (index < 0 || index >= contents.size()) {
                throw new IllegalArgumentException("Invalid index.");
            }
            contents.remove(index);
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    // Method to list all Content objects
    public void listContents() {
        try {
            if (contents.isEmpty()) {
                LOGGER.log(Level.INFO, "No content available.");
                return;
            }
            for (Content content : contents) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.log(Level.INFO, content.toString());
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }
}
