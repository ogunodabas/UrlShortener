<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user home page</title>
</head>
<body>
	<p>User Home Page</p>
	<p>user.toString():</p> ${user} <br>
	<p>user2.toString():</p> ${user2} <br>
	<form action="logout" method="post">
		<input type="submit" value="Sign Out" />
	</form>

	<a href="home/add">add link</a>
	<a href="home/select">select link</a>
	<a href="home/delete">delete link</a>
	
</body>
</html>