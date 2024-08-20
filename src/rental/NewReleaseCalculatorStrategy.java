package rental;

import movie.MovieRental;

public class NewReleaseCalculatorStrategy implements IRentalCalculatorStrategy {
    public double calculateAmount(MovieRental rental) {
        return rental.getDays() * 3;
    }
}
