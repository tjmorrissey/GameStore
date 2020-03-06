<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Game</title>
</head>
<body>
<h2>Add a Game</h2>
<form action = "addGameServlet" method="post">
Game Name: <input type ="text" name = "name"> <br>
Price: <input type="text" name="price"> <br>
<input type = "submit" value="Add Game">
</form>
</body>
</html>