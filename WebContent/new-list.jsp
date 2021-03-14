<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>New List</title>
</head>
<body>
    <form action = "createNewListServlet" method="post">
        User List Name: <input type="text" name="listName"><br/>
        User First Name: <input type="text" name="fName"><br/>
        User Last Name: <input type="text" name="lName"><br/>
        User Age: <input type="text" name="age"><br/>
        Available Bikes: <br/>
    <select name="allGamesToAdd" multiple size="6">
    <c:forEach items="${requestScope.allBikes}" var="currentgame">
        <option value="${currentgame.game_Id}">${currentgame.name}|${currentgame.year}|${currentgame.type}${currentgame.numPlayers}</option>
    </c:forEach>
    </select>
    <br/>
    <input type="submit" value="Create List and Add Games">
    </form>
    <a href="Index.html">Home</a>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>