package ArrayList;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Whitelist {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addAllMovies(List<Movie> movies) {
        this.movies.addAll(movies);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public void replaceMovie(Movie oldMovie, Movie newMovie) {
        int index = movies.indexOf(oldMovie);

        if (index != -1) {
            movies.set(index, newMovie);
        }
    }

    public List<Movie> displayMovies() {
        return movies;
    }

    public void sortMovies() {
        this.movies.sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
    }

    public void displaysortedMovies() {
        this.movies.sort((m1, m2) -> m2.getTitle().compareToIgnoreCase(m1.getTitle()));
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void searchMovieByChar(String character) {

        if (character == null || character.isEmpty()) {
            System.out.println("Invalid character input.");
            return;
        }

        char firstChar = Character.toLowerCase(character.charAt(0));

        System.out.println("Movies starting with '" + character + "':");

        for (Movie movie : movies) {
            if (Character.toLowerCase(movie.getTitle().charAt(0)) == firstChar) {
                System.out.println(movie);
            }
        }
    }

    public void countMovieByWord(String word) {

        int count = 0;

        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase()
                    .contains(word.toLowerCase())) {
                count++;
            }
        }

        System.out.println("Number of movies containing \"" +
                word + "\" : " + count);
    }

    public void displayDuplicateMovies() {

        List<Movie> duplicates = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++) {

            for (int j = i + 1; j < movies.size(); j++) {

                if (movies.get(i).equals(movies.get(j))
                        && !duplicates.contains(movies.get(i))) {

                    duplicates.add(movies.get(i));
                }
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicate movies found.");
        } else {
            System.out.println("Duplicate Movies:");
            for (Movie movie : duplicates) {
                System.out.println(movie);
            }
        }
    }

    public void removeDuplicateMovies() {
        movies = new ArrayList<>(new LinkedHashSet<>(movies));
    }
}