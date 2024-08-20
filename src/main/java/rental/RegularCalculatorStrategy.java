package main.java.rental;

import main.java.movie.MovieRental;

public class RegularCalculatorStrategy implements IRentalCalculatorStrategy {
    @Override
    public double calculateAmount(MovieRental rental) {
        double amount = 2;
        if (rental.getDays() > 2) {
            amount += (rental.getDays() - 2) * 1.5;
        }
        return amount;
    }
}