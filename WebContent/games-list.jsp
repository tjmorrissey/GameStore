<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Games List</title>
</head>
<body>

<form action = "navigateGamesServlet" method="post">
<table>
<tr>
	<td></td>
	<td>Game Name</td>
	<td>Game Price</td>
</tr>
<c:forEach items="${requestScope.allGames}" var="currentgame">
 <tr>
 	<td><input type="radio" name="id" value="${currentgame.gameId}"></td>
 	<td><h3>${currentgame.name}</h3></td>
 	<td><h3>/$${currentgame.price}</h3></td>
 </tr>
</c:forEach>
</table>
<br/>
<input type = "Submit" value="Edit">
<input type = "submit" value="Add Game(s)">
<input type = "submit" value="Delete">
</form>
<br><br><br>
<a href = "add-game.html">Create New Game</a>
<br>

</body>
</html>