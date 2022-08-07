package favoritemovies;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

	private static ArrayList<String> favMoviesList = new ArrayList<String>();
	
	public void setList(String newFav) {
		
		favMoviesList.add(newFav);
		System.out.println(favMoviesList);
		
	}
	
	public ArrayList<String> getList(){

		return favMoviesList;
		
	}
	
}
