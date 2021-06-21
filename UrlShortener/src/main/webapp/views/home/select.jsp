<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
<head>
<meta charset="UTF-8">
<title>Select Page</title>
</head>
<body>
	<p>Select Page</p>

	<a href="/home">User Home Page</a><br>



	<table style="width: 100%">


		<tr>
			<th>id</th>
			<th>user_id</th>
			<th>short_url</th>
			<th>url</th>
		</tr>


		<c:forEach var="urls" items="${urlsList}">
			<tr>
				<td><c:out value="${urls.id}"></c:out></td>
				<td><c:out value="${urls.user_id}"></c:out></td>
				<td><a href="https://<c:out value="${urls.url}"></c:out>" target="_blank"><c:out value="${urls.short_url}"></c:out> </a></td>
				<td><c:out value="${urls.url}"></c:out></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>