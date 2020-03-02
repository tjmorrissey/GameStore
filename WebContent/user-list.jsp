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
<form method = "post" action = "">
<table>
<c:forEach items="${requestScope.allUsers}" var="currentuser">
<tr>
 <td><input type="radio" name="id" value="${currentuser.id}"></td>
 <td><h2>${currentlist.username}</h2></td></tr>
 <tr><td colspan="3">Created Date: ${currentlist.tripDate}</td></tr>
 <c:forEach var = "gameVal" items = "${currentlist.listOfGames}">
 <tr><td></td>
 <td colspan="3"> 
 ${gameVal.name} | \$${gameVal.price}
 </td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<br><br><br>
<a href = "add-game.html">Create New Game</a>
<br>
<a href = "index.html">Main Menu</a>
</body>
</html>