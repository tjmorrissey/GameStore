<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new User</title>
<script type = "text/javascript">
//Username Validation, only allow letters and numbers and 3-15 length
function validate() {
	var user = document.userForm.username.value;
	var userLength = user.length;
	
	if (userLength <= 3 || userLength >= 15) {
		alert("Username must be between 3 and 15 characters.")
		document.userForm.username.focus();
		return false;
	}
}
</script>
</head>
<body>
<h1>Add New User</h1>
<form action = "createNewUserServlet" name="userForm" method="post" onsubmit="return(validate());">
Username: <input type ="text" name = "username"><br />
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
<a href = "viewAllUsersServlet">View All Users</a>
<br>
<a href = "index.html">Main Menu</a>
</body>
</html>