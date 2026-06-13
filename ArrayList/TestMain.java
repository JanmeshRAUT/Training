package ArrayList;

import java.time.LocalDate;

public class TestMain {

        public static void main(String[] args) {

                Whitelist list = new Whitelist();

                Movie m1 = new Movie("Rajkumar Hirani", LocalDate.of(2009, 12, 25), "3 Idiots");
                Movie m2 = new Movie("S. S. Rajamouli", LocalDate.of(2014, 7, 10), "Baahubali");
                Movie m3 = new Movie("Ayan Mukerji", LocalDate.of(2025, 9, 9), "Brahmastra");
                Movie m4 = new Movie("Kabir Khan", LocalDate.of(2024, 6, 27), "Chandu Champion");
                Movie m5 = new Movie("Sandeep Reddy Vanga", LocalDate.of(2023, 12, 1), "Animal");

                // Duplicate movie
                Movie m6 = new Movie("Rajkumar Hirani", LocalDate.of(2009, 12, 25), "3 Idiots");

                list.addMovie(m1);
                list.addMovie(m2);
                list.addMovie(m3);
                list.addMovie(m4);
                list.addMovie(m5);
                list.addMovie(m6);

                System.out.println("All Movies:");
                list.displayMovies().forEach(System.out::println);

                System.out.println("\nSorted Movies:");
                list.sortMovies();
                list.displayMovies().forEach(System.out::println);

                System.out.println("\nReverse Order:");
                list.displayReverseOrder();

                System.out.println("\nSearch By Character:");
                list.searchMovieByChar("I");

                System.out.println();
                list.countMovieByWord("Park");

                System.out.println("\nDuplicate Movies:");
                list.displayDuplicateMovies();

                System.out.println("\nAfter Removing Duplicates:");
                list.removeDuplicateMovies();
                list.displayMovies().forEach(System.out::println);
        }
}