<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Page</title>
</head>
<body>
	<p>Add Page</p>
	<a href="/home">User Home Page</a>

	<form action="/home/add" method="post">
		<input type="text" name="url" placeholder="url"><br> 
		<input name="submit" type="submit" value="submit" />
	</form>
	<br> ${err}
</body>
</html>