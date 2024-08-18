import java.util.HashMap;

public class RentalInfo {

  private MovieRepository movieRepository;

  public RentalInfo(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public String statement(Customer customer) {
    HashMap<String, Movie> movies = movieRepository.getMovies();

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";
    for (MovieRental r : customer.getRentals()) {
      double thisAmount = 0;

      // determine amount for each movie
      if (movies.get(r.getMovieId()).getCode().equals("regular")) {
        thisAmount = 2;
        if (r.getDays() > 2) {
          thisAmount = ((r.getDays() - 2) * 1.5) + thisAmount;
        }
      }
      if (movies.get(r.getMovieId()).getCode().equals("new")) {
        thisAmount = r.getDays() * 3;
      }
      if (movies.get(r.getMovieId()).getCode().equals("childrens")) {
        thisAmount = 1.5;
        if (r.getDays() > 3) {
          thisAmount = ((r.getDays() - 3) * 1.5) + thisAmount;
        }
      }

      // add frequent bonus points
      frequentEnterPoints++;
      // add bonus for a two day new release rental
      if (movies.get(r.getMovieId()).getCode() == "new" && r.getDays() > 2)
        frequentEnterPoints++;

      // print figures for this rental
      result += "\t" + movies.get(r.getMovieId()).getTitle() + "\t" + thisAmount + "\n";
      totalAmount = totalAmount + thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }
}
