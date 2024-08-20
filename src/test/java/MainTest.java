import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.customer.Customer;
import main.java.movie.InMemoryMovieRepository;
import main.java.movie.MovieRental;
import main.java.rental.RentalCalculator;
import main.java.rental.RentalStatementGenerator;

public class MainTest {

    @Test
    public void testGenerateStatement() {
        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

        InMemoryMovieRepository movieRepository = new InMemoryMovieRepository();
        RentalCalculator rentalCalculator = new RentalCalculator();
        RentalStatementGenerator statementGenerator = new RentalStatementGenerator(movieRepository, rentalCalculator);

        String result = statementGenerator
                .generateStatement(
                        new Customer("C. U. Stomer",
                                Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

        assertEquals(expected, result);
    }
}