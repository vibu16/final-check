<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Movie</title>
<link rel="stylesheet" type="text/CSS" href="./style/style.css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span id="head">Movie Cruiser</span> <img
		src="./images/logo.png" /> <a id="nav-menu"
		href="ShowMovieListAdmin">Movies</a> </header>
	<div>
		<h2 class="text-align">Edit Movies</h2>
		<form class="text-align" name="form" method="post"
			onsubmit="return validation()" action="EditMovie?id=${movie.id}">
			<table>
				<tr>
					<td><label for="name-left"><b>Title</b></label>
					<td>
				</tr>
				<tr>
					<td colspan="4"><input type="text" name="title" id="name-left"
						value="${movie.title}"></td>
				</tr>
				<tr>
					<td class="menu-space"><label for="al-right"><b>Gross($)</b></label></td>
					<td class="menu-space"><b>Active</b></td>
					<td class="menu-space"><label for="dol"><b>Date of
								Launch</b></label></td>
					<td class="menu-space"><label for="genre"><b>Genre</b></label></td>
				</tr>
				<tr>
					<td><input type="text" name="boxOffice" id="al-right"
						value="${movie.boxOffice}" /></td>
					<td><input type="radio" name="inStock" value="Yes" id="Yes"
						<c:if test="${movie.active eq 'true'}">Checked</c:if>><label
						for="Yes">Yes </label> <label for="No"><input type="radio"
							name="inStock" value="No" id="No"
							<c:if test="${movie.active eq 'false'}">Checked</c:if>>No</label>
					</td>
					<td><input type="text" id="dol" name="dateOfLaunch"
						value=<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}" />></td>
					<td><select name="genre" id="genre">
                                  <option  <c:if test="${movie.genre eq 'Science Fiction'}">Selected</c:if>>Science Fiction</option>
                                  <option <c:if test="${movie.genre eq 'Superhero'}">Selected</c:if>>Superhero</option>
                                  <option  <c:if test="${movie.genre eq 'Romance'}">Selected</c:if>>Romance</option>
                                  <option <c:if test="${movie.genre eq 'Comedy'}">Selected</c:if>>Comedy</option>
                                  <option <c:if test="${movie.genre eq 'Adventure'}">Selected</c:if>>Adventure</option>
                                  <option <c:if test="${movie.genre eq 'Thriller'}">Selected</c:if>>Thriller</option>
                        </select></td>
					
				</tr>
				<tr>
					<td><label for="teaser"><input type="checkbox"
							id="teaser" name="teaser"
							<c:if test="${movie.hasTeaser eq 'true'}">Checked</c:if>
							<c:if test="${movie.hasTeaser eq 'false'}"></c:if>>Has Teaser</label></td>
							
						
						
				<tr>
					<td><input type="submit" id="btn-color" value="Save"></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> <span id="text-margin">Copyright @ 2019</span> </footer>
</body>
</html>
