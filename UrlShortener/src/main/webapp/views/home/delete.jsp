<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Page</title>
</head>
<body>
	<p>Delete Page</p>
	<a href="/home">User Home Page</a>
	<br>
	<table style="width: 90%">
		<tr>
			<th>id</th>
			<th>user_id</th>
			<th>short_url</th>
			<th>url</th>
			<th>delete buttons</th>
		</tr>
		<c:forEach var="urls" items="${urlsList}">
			<tr>
				<td><c:out value="${urls.id}"></c:out></td>
				<td><c:out value="${urls.user_id}"></c:out></td>
				<td><c:out value="${urls.short_url}"></c:out></td>
				<td><c:out value="${urls.url}"></c:out></td>
				<td>
					<form action="/home/delete/<c:out value="${urls.id}"></c:out>"
						method="get">
						<input type="submit" value="Delete"/>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>