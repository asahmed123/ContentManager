import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Content class to represent a piece of content.
 * This could be an article, a blog post, etc.
 */
public class Content {
    
    // Logger for this class
    private static final Logger LOGGER = Logger.getLogger(Content.class.getName());
    
    // Constant for the exception message
    private static final String EXCEPTION_MESSAGE = "Exception occurred";

    // Attributes for the Content class
    private String title;
    private String textContent;
    private String author;
    private Date dateCreated;

    // Constructor to initialize the Content object
    public Content(String title, String textContent, String author) {
        try {
            if (title == null || textContent == null || author == null) {
                throw new IllegalArgumentException("None of the fields can be null.");
            }
            this.title = title;
            this.textContent = textContent;
            this.author = author;
            this.dateCreated = new Date();
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        try {
            if (title == null) {
                throw new IllegalArgumentException("Title cannot be null.");
            }
            this.title = title;
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        try {
            if (textContent == null) {
                throw new IllegalArgumentException("Text content cannot be null.");
            }
            this.textContent = textContent;
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        try {
            if (author == null) {
                throw new IllegalArgumentException("Author cannot be null.");
            }
            this.author = author;
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Display content information
    @Override
    public String toString() {
        return "Title: " + title + "\\n" +
               "Author: " + author + "\\n" +
               "Date Created: " + dateCreated.toString() + "\\n" +
               "Text Content: " + textContent;
    }
}
