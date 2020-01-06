package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet({ "/EditMovieServlet", "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			String title = request.getParameter("title");
			long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
			boolean active = request.getParameter("inStock").equals("Yes");
			Date dateOfLaunch = DateUtil.convertToDate(request.getParameter("dateOfLaunch"));
			String genre = request.getParameter("genre");
			boolean hasTeaser = request.getParameter("teaser") != null;
			Movie movie = new Movie(id, title, boxOffice, active, dateOfLaunch, genre, hasTeaser);
			MovieDao movieDao = new MovieDaoCollectionImpl();
			movieDao.modifyMovie(movie);
			request.setAttribute("msg", "Movie details saved successfully");
			request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}