package rental;

import customer.Customer;
import movie.MovieRental;
import movie.IMovieRepository;
import movie.Movie;
import movie.MovieGenre;

public class RentalInfo {

  private IMovieRepository movieRepository;
  private RentalCalculator rentalCalculator;

  public RentalInfo(IMovieRepository movieRepository, RentalCalculator rentalCalculator) {
    this.movieRepository = movieRepository;
    this.rentalCalculator = rentalCalculator;
  }

  public double calculateTotalAmount(Customer customer) {
    double totalAmount = 0;
    for (MovieRental rental : customer.getRentals()) {
      String movieId = rental.getMovieId();
      Movie movie = movieRepository.getMovies().get(movieId);
      double rentalAmount = rentalCalculator.calculateAmount(movie, rental);
      totalAmount += rentalAmount;
    }
    return totalAmount;
  }

  public int calculateFrequentEnterPoints(Customer customer) {
    int frequentEnterPoints = 0;
    for (MovieRental r : customer.getRentals()) {
      frequentEnterPoints++;
      String movieId = r.getMovieId();
      Movie movie = movieRepository.getMovies().get(movieId);
      boolean isNewRelease = movie.getCode().equals(MovieGenre.NEW);
      boolean isRentedForMoreThanTwoDays = r.getDays() > 2;

      if (isNewRelease && isRentedForMoreThanTwoDays) {
        frequentEnterPoints++;
      }
    }
    return frequentEnterPoints;
  }

}
