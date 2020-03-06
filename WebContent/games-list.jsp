<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 	<td><input type="radio" name="gameId" value="${currentgame.gameId}"></td>
 	<td><h3>${currentgame.name}</h3></td>
 	<td><h3>$${currentgame.price}</h3></td>
 </tr>
</c:forEach>
</table>
<br/>
<input type = "Submit" value="Edit" name="doThisToGame">
<input type = "submit" value="Add Game(s)" name="doThisToGame">
<input type = "submit" value="Delete" name="doThisToGame">
</form>
<br><br><br>
<br>
<a href = "index.html">Main Menu</a>
<br>

</body>
</html>