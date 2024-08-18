import java.util.Arrays;

import customer.Customer;
import movie.MovieRental;
import movie.MovieRepository;
import rental.RentalInfo;

public class Main {

  public static void main(String[] args) {
    String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    MovieRepository movieRepository = new MovieRepository();
    RentalInfo rentalInfo = new RentalInfo(movieRepository);

    String result = rentalInfo
        .statement(new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

    if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator()
          + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }

    System.out.println("Success");
  }
}
