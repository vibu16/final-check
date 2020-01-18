package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavorite(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "insert into favorites values(default,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<Movie> movieList = new ArrayList<Movie>();
		PreparedStatement ps;
		ResultSet resultSet;
		boolean activeVg, hasTeaserVg;
		Movie movie = null;
		try {
			Favorite favorite = new Favorite();
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer
					.append("SELECT movie_list.mo_id, " + "movie_list.mo_title  , " + "movie_list.mo_box_office ," + "movie_list.mo_active," + "movie_list.mo_date_of_launch,"
							+ "movie_list.mo_genre, " + "movie_list.mo_has_teaser " + "FROM movie_list ")

					.append("INNER JOIN favorites on movie_list.ft_pr_id=movie_list.mo_id + where movie_list.ft_us_id= ?");
			ps = con.prepareStatement(sqlBuffer.toString());
			ps.setLong(1, userId);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int movieId = resultSet.getInt(1);
				String title = resultSet.getString(2);
				long boxOffice = resultSet.getLong(3);
				String active = resultSet.getString(4);
				Date date_of_launch = resultSet.getDate(5);
				String genre = resultSet.getString(6);
				String hasTeaser = resultSet.getString(7);
				if (active != null && active.equals("Yes"))
					activeVg = true;
				else
					activeVg = false;
				if (hasTeaser != null && hasTeaser.equals("Yes"))
					hasTeaserVg = true;
				else
					hasTeaserVg = false;
				movie = new Movie(movieId, title, boxOffice, activeVg, date_of_launch, genre, hasTeaserVg);
				movieList.add(movie);
			}
			favorite.setMovieList(movieList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (movieList.size() == 0) {
			throw new FavoriteEmptyException("Favorite is Empty");
		}
		return movieList;
	}

	@Override
	public void removeFavorite(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();
		try {
			String sql = "delete from favorites where ft_us_id=? and ft_pr_id=? limit 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, movieId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
