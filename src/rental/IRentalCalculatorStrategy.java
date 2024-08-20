package rental;

import movie.MovieRental;

public interface IRentalCalculatorStrategy {
    double calculateAmount(MovieRental movieRental);
}
