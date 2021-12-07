<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<!doctype html>
<html lang="en">
<head>
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
<title>buyer page</title>
</head>
<body>
	<div id="glavniDiv" class="container">
		<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
		<h1>Dobrodošao kupac ${user.userName}</h1>
		<div class="row">
			<div class="col"></div>
			<div class="col"></div>
			<div class="col"></div>
			<div class="col">
				<a href="logout.jsp" class="logoutLink">
					<button type="button"
							class="btn btn-outline-info">Log out
					</button>
				</a>
			</div>
		</div>
		<div class="row"  style="margin-left: 10px;">
			<div class="col">
				<a href="editProfile.jsp"><button type="button"
						class="btn btn-outline-warning">Edit profile</button></a>
				<form action="../ProfileController" method="post"
					style="display: inline;">
					<input type="hidden" name="idUser" value="${user.idUser}">
					<button type="submit" class="btn btn-outline-warning">View
						profile</button>
				</form>
			</div>

		</div>
		<br>
		<div style="width: 75%;">
			<div class="col" style="margin-left: 10px;">
				<img src="../slike/buyer.png">
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="prikaziUsereForma" class="nasloviAdmin">Automobili
						pretraga:</label>
					<form id="prikaziUsereForma" action="../ChosenCarsController"
						method="get" class="dodajBalanceAdmin">
						<div class="row">
							<div class="col">
								<input type="text" class="form-control"
									placeholder="Manufacturer" aria-label="manufacturer"
									name="manufacturer">
							</div>
							<div class="col">
								<input type="text" class="form-control" placeholder="Model"
									aria-label="model" name="model">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col">
								<input type="text" class="form-control" placeholder="Price from"
									aria-label="priceFrom" name="priceFrom">
							</div>
							<div class="col">
								<input type="text" class="form-control" placeholder="Price to"
									aria-label="priceTo" name="priceTo">
							</div>
						</div>

						<br>
						<div class="row">
							<div class="col">
								<label for="yf" class="form-label">Year from:</label> <select
									name="yearFrom" class="form-select"
									aria-label="Default select example" id="yf">
									<option selected value="0"></option>
									<c:forEach var="i" begin="2000" end="2021">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col">
								<label for="yt" class="form-label">Year to:</label> <select
									name="yearTo" class="form-select"
									aria-label="Default select example" id="yt">
									<option selected value="0"></option>
									<c:forEach var="i" begin="2000" end="2021">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<br>
						<div class="row" style="width: 50%;">
							<div class="col">
								<label for="reg" class="form-label">Registration:</label> <select
									name="registration" class="form-select"
									aria-label="Default select example" id="reg">
									<option value="2">sve</option>
									<option value="1">registrovani</option>
									<option value="0">neregistrovani</option>
								</select>
							</div>
						</div>
						<br>
						<div class="row" style = "width: 99%; margin-left: 5px;">
							<button type="submit" class="btn btn-primary">Pretrazi</button>
						</div>
					</form>
				</div>
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