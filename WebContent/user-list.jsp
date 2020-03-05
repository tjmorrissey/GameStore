<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
<h1>User List</h1>
<form method = "post" action = "navigationUserServlet">
<table>
<c:forEach items="${requestScope.allUsers}" var="currentuser">
<tr>
 <td><input type="radio" name="id" value="${currentuser.userId}"></td>
 <td><h2>${currentuser.username}</h2></td></tr>
 <tr><td colspan="3">Created Date: ${currentuser.create_date}</td></tr>
 <c:forEach var = "gameVal" items = "${currentuser.gamesOwned}">
 <tr>
 <td colspan="3"> 
 ${gameVal.name} | \$${gameVal.price}
 </td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<br><br>
Select a User to:
<input type = "submit" value = "Edit" name="doThisToGame">
<input type = "submit" value = "Delete" name="doThisToGame">
<input type="submit" value = "Add" name = "doThisToGame">
</form>
<br><br><br>
<a href = "add-game.html">Create New Game</a>
<br>
<a href = "index.html">Main Menu</a>
</body>
</html>