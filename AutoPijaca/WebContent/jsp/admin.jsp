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

	<label for="prikaziUsereForma">Prikazi usere:</label>
	<form id= "prikaziUsereForma" action="../AdminPrikaziController" method="get">
		Odaberite sta zelite da vidite: <select name="userType" id="users">
			<option value="seller">Prodavce</option>
			<option value="buyer">Kupce</option>
			<option value="all">Sve</option>
		</select> <input type="submit" value="PRIKAZI">

	</form>

	<br>
	<br>
	<label for="dodajBalanceForma">Dodaj Balance:</label>
	<form id = "dodajBalanceForma" action="../DodajBalanceController" method="get" >

		User name:<input type="text" name="userName">
		Balance: <input type="text" name="balance">
		<input type="submit" value="DODAJ">

	</form>



</body>
</html>