<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<%@ page import="model.Car"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chosen cars page</title>
</head>
<body>
<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
<jsp:useBean id="listaAutomobila" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<h1>Dobrodošao ${user.userName} na izbor automobila za kupovinu </h1>
	
	<p> U listi ima: ${listaAutomobila.size()} redova</p>
	
	<a href="jsp/buyer.jsp">back to BUYER page</a> 
	<br><br>
	
	<table border="1px">
		<tr>
			<th>MANUFACTURER</th>
			<th>MODEL</th>
			<th>PRICE</th>
			<th>YEAR</th>
			<th>REGISTER</th>
			<th>BUY</th>
		</tr>
		
		<c:forEach var = "la" items="${listaAutomobila}">
			<tr>
				<td>${la.manufacturer}</td>
				<td>${la.model}</td>
				<td>${la.price}</td>
				<td>${la.year}</td>
				<td>${la.isRegister}</td>			
				<td>
					<c:url var="linkKaKupovini" value="PodaciOkupoviniController">
						<c:param name="idCar" value="${la.idCar}"/>
						<c:param name="idUser" value="${user.idUser}"/>
					</c:url>
					
					<a href="${linkKaKupovini}"><button>BUY</button></a>
				</td>
			</tr>
		</c:forEach>
		
	</table>

	
	
</body>
</html>