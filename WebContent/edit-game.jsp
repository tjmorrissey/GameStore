<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<input type = "hidden" name = "gameId" value="${gameToEdit.gameId}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>