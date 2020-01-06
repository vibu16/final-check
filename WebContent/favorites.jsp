<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Favorites</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
</head>
<body>
	<header> <span id="head">Movie Cruiser</span> <img
		src="./images/logo.png" /> <a id="nav-menu" href="ShowFavorites">Favorites</a>
	<a id="nav-menu" href="ShowMovieListCustomer">Movies</a> </header>
	<div>
		<h2 class="text-align">Favorites</h2>
		<p id="center">${msg }</p>
		<table class="text-align">
			<tr>
				<th class="title-name">Title</th>
				<th class="box-office">Box Office</th>
				<th class="title-text">Genre</th>
			</tr>
			<c:forEach items="${movieListCustomer}" var="movie">
				<tr>
					<td class="title-name">${movie.title}</td>
					<td class="box-office"><fmt:formatNumber type="currency"
							value="${movie.boxOffice}" var="formatNumber" />${formatNumber}</td>
					<td class="title-text">${movie.genre}</td>
					<td class="title-text"><a
						href="RemoveFavorites?id=${movie.id}" class="link-color">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td class="align-bot" colspan="4"><b>No. of Favorites:</b>${fn:length(movieListCustomer)}</td>
			</tr>

		</table>

	</div>
	<footer> <span id="text-margin">Copyright © 2019</span> </footer>
	</ body>
</html>