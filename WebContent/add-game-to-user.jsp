<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Game To User</title>
</head>
<body>
<h1>Add Game To User:</h1>
<form action = "addGamesToUserServlet" method="post">
Username: ${userToAddGame.username}<br />
Choose Game(s) to Add:<br />
<select name="allGamesToAdd" multiple size="6">
<c:forEach items="${requestScope.gamesNotOwned}" var="currentgame">
 <option value = "${currentgame.gameId}">${currentgame.name} | \$${currentgame.price}</option>
</c:forEach>
</select>
<br />
<input type = "hidden" name = "userId" value="${userToEdit.userId}">
<input type = "submit" value="Add Game(s) to User">
</form>
<br><br><br>
<a href = "add-game.html">Create New Game</a>
<br>
<a href = "index.html">Main Menu</a>
</body>
</html>