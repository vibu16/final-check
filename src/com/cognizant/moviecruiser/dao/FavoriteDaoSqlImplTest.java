package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImplTest {

	public static void main(String[] args)throws FavoriteEmptyException {
		System.out.println("**********Favorites***********");
		testGetAllFavorite();
		System.out.println("===========Favorite Movie==========");
		testAddFavorite();
		testGetAllFavorite();
		System.out.println("==========Movie list after Remove===========");
		testRemoveFavorite();
		testGetAllFavorite();

	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
		favoriteDao.addFavorite(1, 2);
		favoriteDao.addFavorite(1, 5);
		List<Movie> movie = favoriteDao.getAllFavorite(1);
	}

	public static void testGetAllFavorite() throws FavoriteEmptyException {
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		FavoriteDao favoriteDao = favoriteDaoSqlImpl;
		List<Movie> movie = favoriteDao.getAllFavorite(1);
	}

	public static void testRemoveFavorite() throws FavoriteEmptyException {
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		FavoriteDao favoriteDao = favoriteDaoSqlImpl;
		try {
			favoriteDao.removeFavorite(1, 2);
			List<Movie> movie = favoriteDao.getAllFavorite(1);
		} catch(Exception e) {
			throw new FavoriteEmptyException("Favotite is Empty");
		}
		

	}
}