<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>User List</title>
</head>
<body>
	<h4>Select your name</h4>
	<br>
	<form method="post" action = "userNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allUsers}" var="currentUser">
	<tr>
	<td><input type="radio" name="id" value="${currentUser.UserId}"></td> 
		<td><h2>${currentUser.fName}</h2></td>
		<td><h2>${currentUser.lName}</h2></td></tr>
<%-- 		<c:forEach var="gameVal" items="currentUser.listOfGames"> --%>
<%-- 			<tr><td></td><td colspan="3">${gameVal.name}, ${gameVal.year}</td></tr> --%>
<%-- 			</c:forEach> --%>
	</c:forEach> 
	</table>
	<input type="submit" value="edit" name="doThisToUser">
	<input type="submit" value="delete" name="doThisToUser">
	<input type="submit" value="add" name="doThisToUser">
	</form>
	<a href="index.html">Home</a>
	<br>
	<a href="add-user.jsp">Add a new user</a>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>