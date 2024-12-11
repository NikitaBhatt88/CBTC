import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // To string for display
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

class LibraryCatalog {
    private List<Book> catalog;

    // Constructor
    public LibraryCatalog() {
        catalog = new ArrayList<>();
    }

    // Add a new book
    public void addBook(String title, String author, String isbn) {
        Book newBook = new Book(title, author, isbn);
        catalog.add(newBook);
        System.out.println("Book added successfully!");
    }

    // Search books by title or author
    public void searchBooks(String keyword) {
        boolean found = false;
        System.out.println("\nSearch Results:");
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the keyword: " + keyword);
        }
    }

    // List all books
    public void listBooks() {
        System.out.println("\nBooks in the Catalog:");
        if (catalog.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : catalog) {
                System.out.println(book);
            }
        }
    }
}

public class LibraryCatalogSystem {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Books");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    libraryCatalog.addBook(title, author, isbn);
                    break;

                case 2:
                    System.out.print("Enter keyword to search (title/author): ");
                    String keyword = scanner.nextLine();
                    libraryCatalog.searchBooks(keyword);
                    break;

                case 3:
                    libraryCatalog.listBooks();
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
