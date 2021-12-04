<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyer page</title>
</head>
<body>
	<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
	<h1>Dobrodošao kupac ${user.userName}</h1>
	
	<a href = "logout.jsp">LOGOUT</a>

	<a href="editProfile.jsp">edit profile</a>
	<form action="../ProfileController" method="post">
		<input type="hidden" name="idUser" value="${user.idUser}"> <input
			type="submit" value="view profile" />
	</form>

	<p>Automobili pretraga:</p>
	<form action="../ChosenCarsController" method="get">

		Manufacturer: <input type="text" name="manufacturer"> <br>
		Model: <input type="text" name="model"> <br> 
		Cena od: <input type="text" name="priceFrom"> <br> 
		Cena do: <input type="text" name="priceTo"> <br> 

		Year from: <select name="yearFrom">
			<option value = "0"> </option>
			<c:forEach var="i" begin="2000" end="2021">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select> 
		Year to: <select name="yearTo">
			<option value = "0"> </option>
			<c:forEach var="i" begin="2000" end="2021">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
		
		<br>
		Registration: <select name = "registration">
						<option value="1"> registrovani</option>
						<option value="0">neregistrovani</option>
						<option value="2">sve</option>
					</select>
		<br>
		<input type="submit" value="PRETRAZI">
		
	</form>

</body>
</html>