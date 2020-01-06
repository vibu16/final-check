package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;

/**
 * Servlet implementation class RemoveFavoritesServlet
 */
@WebServlet({ "/RemoveFavoritesServlet", "/RemoveFavorites" })
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
            long movieId = Long.parseLong(request.getParameter("id"));
            favoriteDao.removeFavorite(1, movieId);
            request.setAttribute("msg", "Movie removed from the Favorites successfully");
            RequestDispatcher rd = request.getRequestDispatcher("ShowFavorites");
            rd.forward(request, response);
} catch (Exception ex) {
            request.getRequestDispatcher("cart-empty.jsp").forward(request, response);

}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}