<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cars</title>
</head>
<body>
	<jsp:useBean id="details" scope="request" class="model.UserDetails"></jsp:useBean>
	<h1>User ${details.firstName} ${details.lastName} profile</h1>

	<a href="jsp/seller.jsp">back to SELLER page</a>
	<br>
	<br>
	
	<img src = "profilneSlike/${details.firstName}.jfif">

</body>
</html>