<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Add User</title>
</head>
<body>
	<h1>Add user below</h1>
	
	<div class="container">
		<form action="addUserSerlvet" method= "post">
			<div class="form-group">
				<label for="fName">First Name: </label> <input type="text" name="fName">
			</div>
			
			<div class="form-group">
				<label for="lName">Last Name:</label> <input type="text" name="lName">
			</div>
			
			<div class="form-group">
				<label for="age">Age:</label> <input type="number" name="age">
			</div>
			
			<input type="submit" value="Add User" class="btn btn-primary">
		</form>
		<br/>
		<button type="button" class="btn btn-primary btn-lg" onclick="location.href='viewAllGamesServlet';">View Games List</button>
		<a href="viewAllGamesServlet"></a>
		
		<button type="button" class="btn btn-primary btn-lg" onclick="location.href='viewAllUsersSerlvet';">View All Users</button>
		<a href="viewAllUsersServlet"></a>
		
		<button type="button" class="btn btn-primary btn-lg" onclick="location.href='viewAllListsSerlvet';">View Lists</button>
		<a href="viewAllListsServlet"></a>
	</div>
	
	<a href="index.html">Home</a>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
