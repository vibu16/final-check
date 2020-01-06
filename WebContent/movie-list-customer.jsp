<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Customer</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
</head>
<body>
	<header> <span id="head">Movie Cruiser</span> <img
		src="./images/logo.png" /> <a id="nav-menu" href="ShowFavorites">Favorites</a>
	<a id="nav-menu" href="ShowMovieListCustomer">Movies</a> </header>
	<div>
		<h2 class="text-align">Movies</h2>
		<p id="center">${msg }</p>
		<table class="text-align">
			<tr>
				<th class="title-name">Title</th>
				<th class="box-office">Box Office</th>
				<th class="title-price">Genre</th>
				<th class="title-text">Has Teaser</th>
				<th class="title-text">Action</th>
			</tr>
			<c:forEach items="${customerList}" var="movie">
				<tr>
					<td class="title-name">${movie.title}</td>
					<td class="box-office"><fmt:formatNumber type="currency"
							value="${movie.boxOffice}" var="formatNumber" />${formatNumber}</td>
					<td class="title-text">${movie.genre}</td>
					<td class="title-text"><c:if test="${movie.hasTeaser}">yes</c:if>
						<c:if test="${!movie.hasTeaser}">No</c:if></td>
					<td class="title-text"><a href="AddToFavorites?id=${movie.id}"
						class="link-color">Add to Favorite</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer> <span id="text-margin">Copyright@ 2019</span> </footer>
</body>
</html>
