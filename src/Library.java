import java.util.HashMap;
import java.util.Map;

class Book {
    private String authorName;
    private String title;
    private final String ISBN;

    public Book(String authorName, String title, String ISBN) {
        this.authorName = authorName;
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "[" + authorName + ", " + title + ", " + ISBN + "]";
    }
}

public class Library {
    private Map<String, Book> booksByISBN;

    public Library() {
        booksByISBN = new HashMap<>();
    }

    public void addBook(String authorName, String title, String ISBN) {
        Book book = new Book(authorName, title, ISBN);
        booksByISBN.put(ISBN, book);
    }

    public Book findBookByISBN(String ISBN) {
        return booksByISBN.get(ISBN);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : booksByISBN.values()) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        
        library.addBook("Author1", "Title1", "ISBN123");
        library.addBook("Author2", "Title2", "ISBN456");
        library.addBook("Author3", "Title3", "ISBN789");

        
        library.displayBooks();

        
        String searchISBN = "ISBN456";
        Book foundBook = library.findBookByISBN(searchISBN);
        if (foundBook != null) {
            System.out.println("Book with ISBN " + searchISBN + " found: " + foundBook);
        } else {
            System.out.println("Book with ISBN " + searchISBN + " not found.");
        }
    }
}
