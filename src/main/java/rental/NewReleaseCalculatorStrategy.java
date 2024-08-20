package main.java.rental;

import main.java.movie.MovieRental;

public class NewReleaseCalculatorStrategy implements IRentalCalculatorStrategy {
    public double calculateAmount(MovieRental rental) {
        return rental.getDays() * 3;
    }
}
