package LibraryManagement;

public class LibraryManagement {

    void findCostlistBook(Book[] books) {

        double maxPrice = 0;
        Book costliestBook = null;

        for (Book book : books) {
            if (book.getPrice() > maxPrice) {
                maxPrice = book.getPrice();
                costliestBook = book;
            }
        }

        if (costliestBook != null) {
            System.out.println("Costliest Book:");
            costliestBook.displayBookDetails();
        } else {
            System.out.println("No books found.");
        }
    }

    void CheapestBook(Book[] books) {

        double minPrice = Double.MAX_VALUE;
        Book cheapestBook = null;

        for (Book book : books) {
            if (book.getPrice() < minPrice) {
                minPrice = book.getPrice();
                cheapestBook = book;
            }
        }

        if (cheapestBook != null) {
            System.out.println("Cheapest Book:");
            cheapestBook.displayBookDetails();
        } else {
            System.out.println("No books found.");
        }
    }

    void findBooksByAuthor(Book[] books, String author) {

        boolean found = false;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.displayBookDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by " + author);
        }
    }

    void findBooksbyTitle(Book[] books, String title) {

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBookDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with title " + title);
        }
    }

    void findTotalBooksInInventory(Book[] books) {

        int totalBooks = 0;

        for (Book book : books) {
            totalBooks += book.getAvailableCopies();
        }

        System.out.println("Total Books in Inventory: " + totalBooks);
    }
}