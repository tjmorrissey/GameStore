<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new User</title>
</head>
<body>
<form action = "createNewUserServlet" method="post">
Username: <input type ="text" name = "listName"><br />
<h5>Choose Owned Games:</h5><br>
Games Items:<br />
<select name="allGamesToAdd" multiple size="6">
<c:forEach items="${requestScope.allGames}" var="currentgame">
 <option value = "${currentgame.gameId}">${currentgame.name} | \$${currentgame.price}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create User and Add Games">
</form>
<br><br><br>
<a href = "add-game.html">Create New Game</a>
<br>
<a href = "index.html">Main Menu</a>
</body>
</html>