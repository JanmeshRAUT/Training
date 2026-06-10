package LibraryManagement;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book(
                "Java Basics",
                "Pankaj",
                "Programming",
                500,
                10);

        Book b2 = new Book(
                "Java Advanced",
                "Pankaj",
                "Programming",
                1000,
                5);

        Book b3 = new Book(
                "Python",
                "Raj",
                "Programming",
                300,
                8);

        Book b4 = new Book(
                "",
                "James",
                "Programming",
                1500,
                2);

        Book[] books = {b1, b2, b3, b4};

        LibraryManagement library = new LibraryManagement();

        System.out.println("All Books");

        for (Book book : books) {
            book.display();
        }

        library.findCostlistBook(books);

        library.CheapestBook(books);

        library.findBooksByAuthor(books, "Pankaj");

        library.findBooksbyTitle(books, "Python");

        library.findTotalBooksInInventory(books);

        b1.borrowBook(books, "Java Basics");

        b1.returnBook(books, "Java Basics");

        System.out.println(
                b1.isAvailable(books, "Java Basics"));

        b1.updateBookPrice(
                books,
                "Java Basics",
                900);

        b1.display();
    }
}