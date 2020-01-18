package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;



public class MovieDaoSqlImplTest {

	public static void main(String[] args) throws ParseException, ClassNotFoundException {
		System.out.println("*********Admin List*******");
		testGetMovieListAdmin();
		System.out.println("*********Customer List*******");
		testGetMovieListCustomer();
		testModifyMovie();
		System.out.println("*********Modified List*******");
		testGetMovieListAdmin();

	}
	public static void testGetMovieListAdmin() throws ParseException {
		MovieDaoSqlImpl movieDao = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}

	}
	public static void testGetMovieListCustomer() throws ClassNotFoundException {
		MovieDaoSqlImpl movieDao = new MovieDaoSqlImpl();
		List<Movie> L = movieDao.getMovieListCustomer();
		for (Movie m : L) {
			System.out.println(m);
		}
	}
	public static void testModifyMovie() throws ParseException {
		MovieDaoSqlImpl movieDao = new MovieDaoSqlImpl();
		Movie movie = new Movie(2, "Avengers: Age of Ultron", 2750760348L, true, DateUtil.convertToDate("02/11/2022"),
				"Superhero", true);
		movieDao.modifyMovie(movie);
	}

	

}
