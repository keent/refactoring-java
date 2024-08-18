package rental;

import java.util.HashMap;

import customer.Customer;
import movie.Movie;
import movie.MovieRental;
import movie.MovieRepository;

public class RentalInfo {

  private MovieRepository movieRepository;
  private RentalCalculator rentalCalculator;

  public RentalInfo(MovieRepository movieRepository, RentalCalculator rentalCalculator) {
    this.movieRepository = movieRepository;
    this.rentalCalculator = rentalCalculator;
  }

  public String statement(Customer customer) {
    HashMap<String, Movie> movies = movieRepository.getMovies();

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";
    for (MovieRental r : customer.getRentals()) {

      // Determine amount for each movie
      double thisAmount = rentalCalculator.calculateAmount(movies.get(r.getMovieId()), r);

      // Add frequent bonus points
      frequentEnterPoints++;

      // Add bonus for a two day new release rental
      if (movies.get(r.getMovieId()).getCode() == "new" && r.getDays() > 2)
        frequentEnterPoints++;

      // print figures for this rental
      result += "\t" + movies.get(r.getMovieId()).getTitle() + "\t" + thisAmount + "\n";
      totalAmount += thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }
}
