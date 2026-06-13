package ArrayList;

import java.time.LocalDate;
import java.util.Objects;

public class Movie implements Comparable<Movie> {

    private String title;
    private String director;
    private LocalDate releaseDate;

    public Movie(String director, LocalDate releaseDate, String title) {
        this.director = director;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String Gettitle() {
        return getTitle();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public int compareTo(Movie other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        return Objects.equals(title, other.title)
                && Objects.equals(director, other.director)
                && Objects.equals(releaseDate, other.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, releaseDate);
    }

    @Override
    public String toString() {
        return "Movie [title=" + title +
                ", director=" + director +
                ", releaseDate=" + releaseDate + "]";
    }
}