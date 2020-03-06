<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
</head>
<body>
<h3>Edit Game</h3>
<form action = "editGameServlet" method="post">
Game Name: <input type ="text" name = "name" value= "${gameToEdit.name}">
Game Price: <input type ="text" name = "price" value= "${gameToEdit.price}">
<input type = "hidden" name = "gameId" value="${gameToEdit.gameId}">
<input type = "submit" value="Save Edited Item">
<br>
<a href = "index.html">Main Menu</a>
</form>
</body>
</html>