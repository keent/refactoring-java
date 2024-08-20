package main.java.rental;

import main.java.movie.MovieRental;

public class ChildrenCalculatorStrategy implements IRentalCalculatorStrategy {
    @Override
    public double calculateAmount(MovieRental rental) {
        double amount = 1.5;
        if (rental.getDays() > 3) {
            amount += (rental.getDays() - 3) * 1.5;
        }
        return amount;
    }
}
