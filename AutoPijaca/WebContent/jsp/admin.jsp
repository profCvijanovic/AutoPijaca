<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin page</title>
</head>
<body>

	<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>

	<h1>Dobrodosao ${user.userName}</h1>

	<form action="../AdminPrikaziController" method="get">
		Odaberite sta zelite da vidite: 
		<select name="userType" id="users">
			<option value="seller">Prodavce</option>
			<option value="buyer">Kupce</option>
			<option value="all">Sve</option>
		</select>
		
		<input type="submit" value="PRIKAZI">

	</form>


</body>
</html>