package com.cognizant.moviecruiser.dao;

import java.text.NumberFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
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
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		favoriteDao.addFavorite(1, 2L);
		favoriteDao.addFavorite(1, 5L);
	}

	public static void testGetAllFavorite() throws FavoriteEmptyException {
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		try {
			List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
			for (Movie x : movieListCustomer) {
				System.out.println(x.favo());
			}
			System.out.println("Total No.of favorites :" + movieListCustomer.size() + "\n");
		} catch (FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testRemoveFavorite() throws FavoriteEmptyException {
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		favoriteDao.removeFavorite(1, 2);

	}
}
