package favoritemovies;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

	private ArrayList<String> favMoviesList = new ArrayList<String>();
	
	public void setList(String newFav) {
		
		favMoviesList.add(newFav);
		
	}
	
	public ArrayList<String> getList(){
		
		return favMoviesList;
		
	}
	
}
