package rental;

import movie.Movie;
import movie.MovieRental;

public class RentalCalculator {

    public double calculateAmount(Movie movie, MovieRental rental) {
        switch (movie.getCode()) {
            case REGULAR:
                return calculateRegularAmount(rental);
            case NEW:
                return calculateNewReleaseAmount(rental);
            case CHILDRENS:
                return calculateChildrenAmount(rental);
            default:
                throw new IllegalArgumentException("Unknown movie code: " + movie.getCode());
        }
    }

    private double calculateRegularAmount(MovieRental rental) {
        double amount = 2;
        if (rental.getDays() > 2) {
            amount += (rental.getDays() - 2) * 1.5;
        }
        return amount;
    }

    private double calculateNewReleaseAmount(MovieRental rental) {
        return rental.getDays() * 3;
    }

    private double calculateChildrenAmount(MovieRental rental) {
        double amount = 1.5;
        if (rental.getDays() > 3) {
            amount += (rental.getDays() - 3) * 1.5;
        }
        return amount;
    }
}