<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seller page</title>
</head>
<body>
	<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
	<h1>Dobrodosao prodavac ${user.userName}</h1>
	
	<a href = "logout.jsp">LOGOUT</a>
	
	<a href = "editProfile.jsp">edit profile</a>
	<form action = "../ProfileController" method="post">
		<input type="hidden" name = "idUser" value="${user.idUser}">
		<input type="submit" value = "view profile"/>
	</form>
	
	
	<form action = "../AddCarController" method="get">
		<input type="hidden" name = "idUser" value="${user.idUser}"><br>
		Manufacturer: <input type="text" name="manufacturer"><br>
		Model: <input type="text" name="model"><br>
		Price: <input type="text" name="price"><br>
		Year: <input type="text" name="year"><br>
		Register: <input type="checkbox" name="isRegister"><br>
		<input type="submit" value = "ADD CAR">
	</form>

</body>
</html>