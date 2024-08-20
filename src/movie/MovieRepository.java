package movie;

import java.util.HashMap;

public class MovieRepository {
    public HashMap<String, Movie> getMovies() {

        HashMap<String, Movie> movies = new HashMap<>();

        movies.put("F001", new Movie("You've Got Mail", MovieGenre.REGULAR));
        movies.put("F002", new Movie("Matrix", MovieGenre.REGULAR));
        movies.put("F003", new Movie("Cars", MovieGenre.CHILDRENS));
        movies.put("F004", new Movie("Fast & Furious X", MovieGenre.NEW));

        return movies;
    }
}