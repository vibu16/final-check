package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorite> userFavorites;

	public FavoriteDaoCollectionImpl() {

		if (userFavorites == null) {
			userFavorites = new HashMap<>();
			userFavorites.put(1l, new Favorite());
		}
	}

	@Override
	public void addFavorite(long userId, long movieId) {
		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			Movie movie = movieDao.getMovie(movieId);
			if (userFavorites.containsKey(userId)) {
				Favorite favorite = userFavorites.get(userId);
				favorite.getMovieList().add(movie);

			} else {
				Favorite favorite = new Favorite();
				favorite.getMovieList().add(movie);
				userFavorites.put(userId, favorite);
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		List<Movie> movieList = userFavorites.get(userId).getMovieList();
		Favorite favorite = userFavorites.get(userId);
		int total = 0;
		if (favorite == null || favorite.getMovieList() == null || movieList.isEmpty()) {
			throw new FavoriteEmptyException();
		} else {
			for (Movie movie : movieList) {
				total += movie.getBoxOffice();

			}

		}
		favorite.setNoOfFavorites(total);
		return movieList;
	}

	@Override
	public void removeFavorite(long userId, long movieId) {
		List<Movie> movieList = userFavorites.get(userId).getMovieList();
		int item = 0;
		for (; item < movieList.size(); item++) {
			if (movieList.get(item).getId() == movieId) {
				movieList.remove(item);
				break;

			}

		}
	}
}
