import java.util.Arrays;

import customer.Customer;
import movie.MovieRental;
import movie.MovieRepository;
import rental.RentalCalculator;
import rental.RentalInfo;
import rental.RentalStatementGenerator;

public class Main {

  public static void main(String[] args) {
    String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    MovieRepository movieRepository = new MovieRepository();
    RentalCalculator rentalCalculator = new RentalCalculator();
    RentalStatementGenerator statementGenerator = new RentalStatementGenerator(movieRepository, rentalCalculator);

    String result = statementGenerator
        .generateStatement(
            new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

    if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator()
          + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }

    System.out.println("Success");
  }
}
