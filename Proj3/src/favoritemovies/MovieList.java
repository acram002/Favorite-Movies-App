package favoritemovies;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

	private static ArrayList<String> favMoviesList = new ArrayList<String>();

	public void setList(String newFav) {
		// set the list of movies by adding new items
		favMoviesList.add(newFav);

	}

	public ArrayList<String> getList() {
		// returns the list of movies to be displayed
		return favMoviesList;

	}

}
