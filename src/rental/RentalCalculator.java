package rental;

import movie.Movie;
import movie.MovieRental;

public class RentalCalculator {
    public double calculateAmount(Movie movie, MovieRental rental) {
        double amount = 0;
        switch (movie.getCode()) {
            case REGULAR:
                amount = 2;
                if (rental.getDays() > 2) {
                    amount += (rental.getDays() - 2) * 1.5;
                }
                break;
            case NEW:
                amount = rental.getDays() * 3;
                break;
            case CHILDRENS:
                amount = 1.5;
                if (rental.getDays() > 3) {
                    amount += (rental.getDays() - 3) * 1.5;
                }
                break;
        }
        return amount;
    }
}