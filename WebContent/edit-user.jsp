<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<form action = "editUserServlet" method="post">
Username: <input type ="text" name = "store" value= "${gameToEdit.username}"> <br>
Date Created: ${gameToEdit.create_date} <br>

<input type = "submit" value="Update Username">
</form>
<table>
	<tr>
		<td> </td>
		<td>Game Name</td>
		<td>Price</td>
	</tr>
	<c:forEach var = "gameVal" items = "${currentlist.listOfGames}">
 	<tr>
 		<td><input type="radio" name="id" value="${gameVal.gameId}"> </td>
 		<td>${gameVal.name } </td>
 		<td>\$${gameVal.price } </td>
	</tr>
 	</c:forEach>
</table>


<input type = "hidden" name = "id" value="${gameToEdit.id}">
</body>
</html>