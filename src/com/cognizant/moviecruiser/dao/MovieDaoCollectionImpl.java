package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() throws ParseException {
		if (movieList == null) {
			movieList = new ArrayList<>();
			movieList.add(new Movie(1, "Avatar", 2787965087L, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2, "The Avengers", 1518812988L, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", true));
			movieList.add(
					new Movie(3, "Titanic", 2187463944L, true, DateUtil.convertToDate("21/08/2017"), "Romance", true));
			movieList.add(new Movie(4, "Jurassic World", 1671713208L, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(5, "Avengers: End Game", 2750760348L, true, DateUtil.convertToDate("02/11/2022"),
					"Superhero", true));

		}

	}

	@Override
	public List<Movie> getMovieListAdmin() {

		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		List<Movie> customerList = new ArrayList<>();
		Date today = new Date();
		for (Movie x : movieList) {
			if (x.isActive() && x.getDateOfLaunch().before(today)) {
				customerList.add(x);
			}
		}
		return customerList;

	}

	@Override
	public void modifyMovie(Movie movie) {
		Movie x = getMovie(movie.getId());
		x.setTitle(movie.getTitle());
		x.setBoxOffice(movie.getBoxOffice());
		x.setActive(movie.isActive());
		x.setDateOfLaunch(movie.getDateOfLaunch());
		x.setGenre(movie.getGenre());
		x.setHasTeaser(movie.isHasTeaser());

	}

	@Override
	public Movie getMovie(long movieId) {
		Movie movie = null;
		for (Movie x : movieList) {
			if (x.getId() == movieId) {
				movie = x;
				break;
			}
		}

		return movie;
	}
}
