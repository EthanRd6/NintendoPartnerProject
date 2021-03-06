<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
</head>
<body>
<form action = "editGameServlet" method="post">
Name: <input type = "text" name = "name" value="${gameToEdit.name}"><br>
Year Released: <input type = "text" name = "year" value="${gameToEdit.year}"><br>
Game Type: <input type = "text" name = "type" value="${gameToEdit.type}"><br>
Number of Players: <input type = "text" name = "numPlayers" value="${gameToEdit.numPlayers}"><br>
<input type = "hidden" name = "id" value="${gameToEdit.id}">
<input type = "submit" value = "Save Edited Game">
</form>
</body>
</html>