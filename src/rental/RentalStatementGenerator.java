package rental;

import java.util.HashMap;

import customer.Customer;
import movie.Movie;
import movie.MovieGenre;
import movie.InMemoryMovieRepository;
import movie.MovieRental;

public class RentalStatementGenerator {
    private InMemoryMovieRepository movieRepository;
    private RentalCalculator rentalCalculator;

    public RentalStatementGenerator(InMemoryMovieRepository movieRepository, RentalCalculator rentalCalculator) {
        this.movieRepository = movieRepository;
        this.rentalCalculator = rentalCalculator;
    }

    public String generateStatement(Customer customer) {
        HashMap<String, Movie> movies = movieRepository.getMovies();

        double totalAmount = 0;
        int frequentEnterPoints = 0;
        String result = "Rental Record for " + customer.getName() + "\n";
        for (MovieRental r : customer.getRentals()) {

            // Calculate amount for each movie
            // Add frequent bonus points
            // Add bonus for a two day new release rental
            // Print figures for this rental

            double thisAmount = rentalCalculator.calculateAmount(movies.get(r.getMovieId()), r);
            frequentEnterPoints++;

            if (movies.get(r.getMovieId()).getCode().equals(MovieGenre.NEW) && r.getDays() > 2)
                frequentEnterPoints++;

            result += "\t" + movies.get(r.getMovieId()).getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentEnterPoints + " frequent points\n";

        return result;
    }
}