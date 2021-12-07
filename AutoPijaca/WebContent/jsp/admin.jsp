<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>admin page</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="../mojCss/style.css" />
</head>
<body>
	<div class="container, prviDivAdmin">
		<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>

		<h1>Dobrodošao ${user.userName}</h1>
		
		<a href = "logout.jsp" class="logoutLink">LOGOUT</a>
		<div class="row">
			<div class="col">
				<label for="prikaziUsereForma" class="nasloviAdmin">Prikazi usere:</label>
				<form id="prikaziUsereForma" action="../AdminPrikaziController"
					method="get" class="dodajBalanceAdmin">
					<select name="userType" id="users"
						class="form-select form-select-sm"
						aria-label=".form-select-sm example">
						<option selected>Useri</option>
						<option value="seller">Prodavce</option>
						<option value="buyer">Kupce</option>
						<option value="all">Sve</option>
					</select>

					<div class="col" style="margin: 5px;">
						<button type="submit" class="btn btn-primary">Prikazi</button>
					</div>


				</form>

				<br> <label for="dodajBalanceForma" class="nasloviAdmin">Dodaj Balance:</label>


				<form id="dodajBalanceForma" action="../DodajBalanceController"
					method="get" class="dodajBalanceAdmin">
					<div class="row g-3">
						<div class="col">
							<input type="text" class="form-control" placeholder="User name"
								aria-label="First name" name="userName">
						</div>
						<div class="col" style="margin-left: 5px">
							<input type="text" class="form-control" placeholder="Balance"
								aria-label="Last name" name="balance">
						</div>

						<div class="col" style="margin-left: 5px">
							<button type="submit" class="btn btn-primary">Dodaj</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col">
				<img src="../slike/adminPage.jfif" / class="slikaAdmin">
			</div>

		</div>
		<!-- Optional JavaScript; choose one of the two! -->

		<!-- Option 1: Bootstrap Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"></script>

		<!-- Option 2: Separate Popper and Bootstrap JS -->
		<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
	</div>
</body>
</html>