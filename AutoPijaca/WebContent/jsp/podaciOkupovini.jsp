<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<%@ page import="model.Car"%>
<%@ page import="model.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>kupovina</title>
</head>
<body>

<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
<jsp:useBean id="car" scope="request" class="model.Car"></jsp:useBean>
<jsp:useBean id="details" scope="request" class="model.UserDetails"></jsp:useBean>
	<h1>PODACI O KUPOVINI</h1>
	
	<p>PODACI O KUPCU:</p>
	<p>Kupac: ${user.userName}</p>
	<p>Balance: ${details.balance}</p>
	
	<p>PODACI O AUTOMOBILU:</p>
	<p>Marka: ${car.manufacturer}</p>
	<p>Model: ${car.model}</p>
	<p>Cena: ${car.price}</p>
	
	<p>PODACI O PRODAVCU:</p>
	<p>Ime i prezime: ${car.userDetails.firstName}  ${car.userDetails.lastName} </p>
	<p>KONTAKT:</p>
	<p>Telefon: ${car.userDetails.contact.phone}</p>
	<p>Email: ${car.userDetails.contact.email}</p>
	<p>ADRESA:</p>
	<p>DRZAVA: ${car.userDetails.address.country}</p>
	<p>GRAD: ${car.userDetails.address.city}</p>
	<p>ULICA: ${car.userDetails.address.street}</p>
	
	<form action="BuyCarController" method="post">
		<input type="hidden" name = "idCar" value = "${car.idCar}">
		<input type="hidden" name = "idBuyerUserDetails" value = "${details.idUserDetails}">
		<input type="submit" value = "POTVRDI KUPOVINU">
	</form>

</body>
</html>