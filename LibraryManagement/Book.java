package LibraryManagement;

public class Book {

    int id = 0;
    String title;
    String author;
    String category;
    private double price;
    int availableCopies;

    private static int idCounter = 1;

    Book(String title, String author, String category,
         double price, int availableCopies) {

        this.id = idCounter++;

        if (title == null || title.trim().isEmpty()) {
            this.title = "Unknown Title";
        } else {
            this.title = title;
        }

        this.author = author.trim();
        this.category = category;
        this.price = (price > 0) ? price : 0.0;
        this.availableCopies = (availableCopies >= 0) ? availableCopies : 0;
    }

    void displayBookDetails() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
        System.out.println("Available Copies: " + availableCopies);
    }

    void display() {
        displayBookDetails();
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    void borrowBook(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.availableCopies > 0) {
                    book.availableCopies--;
                    System.out.println("You have borrowed: " + book.title);
                } else {
                    System.out.println("No copies available for: " + book.title);
                }
                return;
            }
        }
        System.out.println("Book titled '" + title + "' not found.");
    }

    void returnBook(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.availableCopies++;
                System.out.println("You have returned: " + book.title);
                return;
            }
        }
        System.out.println("Book titled '" + title + "' not found.");
    }

    public boolean isAvailable(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book.availableCopies > 0;
            }
        }

        System.out.println("Book titled '" + title + "' not found.");
        return false;
    }

    void updateBookPrice(Book[] books, String title, double newPrice) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (newPrice > 0) {
                    book.price = newPrice;
                    System.out.println("Price updated for: " + book.title);
                } else {
                    System.out.println("Invalid price.");
                }
                return;
            }
        }
    }
}