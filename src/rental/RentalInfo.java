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

  public double calculateTotalAmount(Customer customer) {
    double totalAmount = 0;
    for (MovieRental r : customer.getRentals()) {
      totalAmount += rentalCalculator.calculateAmount(movieRepository.getMovies().get(r.getMovieId()), r);
    }
    return totalAmount;
  }

  public int calculateFrequentEnterPoints(Customer customer) {
    int frequentEnterPoints = 0;
    for (MovieRental r : customer.getRentals()) {
      frequentEnterPoints++;
      if (movieRepository.getMovies().get(r.getMovieId()).getCode().equals("new") && r.getDays() > 2)
        frequentEnterPoints++;
    }
    return frequentEnterPoints;
  }

}
