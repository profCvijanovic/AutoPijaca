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

	
	
</body>
</html>