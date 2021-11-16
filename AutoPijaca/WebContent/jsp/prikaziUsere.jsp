<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>users</title>
</head>
<body>

	<jsp:useBean id="users" scope="request" class="java.util.ArrayList"></jsp:useBean>

	<a href="jsp/admin.jsp"> back to ADMIN page </a>

	<h1>TABELA USERA</h1>

	<table border=1>

		<tr>
			<th>USER NAME</th>
			<th>PASSWORD</th>
			<th>USER TYPE</th>
		</tr>

		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.userName}</td>
				<td>${u.password}</td>
				<td>${u.userType}</td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>