package com.cognizant.moviecruiser.dao;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImplTest {

	public static void main(String[] args) {

		try {
			System.out.println("*********Admin Movie List********");
			testGetMovieListAdmin();
			System.out.println("*********Customer Movie List********");
			testGetMovieListCustomer();
			System.out.println("*********Modified Movie List********");
			testModifyMovie();
			testGetMovieListAdmin();

		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public static void testGetMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}

	}

	public static void testGetMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> customerList = movieDao.getMovieListCustomer();
		NumberFormat box = NumberFormat.getInstance();
		box.setGroupingUsed(true);
		for (Movie x : customerList) {

			System.out.printf("%-20s $%-7s %-20s %-5s   Add to Favorie \n", x.getTitle(), box.format(x.getBoxOffice()),
					x.getGenre(), x.isHasTeaser() ? "Yes" : "No");
		}

	}

	public static void testModifyMovie() throws ParseException {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = (new Movie(1, "Iron Man", 1234567873L, true, DateUtil.convertToDate("12/03/2012"), "Superhero",
				true));
		movieDao.modifyMovie(movie);
	}

}
