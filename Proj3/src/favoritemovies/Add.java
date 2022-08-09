package favoritemovies;

public class Add {

	private MovieList list = new MovieList();

	public void AddMovie(String newFav) {
		// adds user entered item into list
		list.setList(newFav);
	}

}
