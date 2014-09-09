<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
		<%@ page import="java.util.*,java.text.*" %>
		<%@ page contentType="text/html" %>
		<%@ page pageEncoding="UTF-8" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<jsp:useBean id="user" class="ar.edu.itba.it.paw.model.User" scope="session"/>
	</head>
	
	<body>
		<c:if test="${sessionScope.authentication == false}">
			<strong>Los datos ingresados son incorrectos</strong><br>
		</c:if>

		<h1>Ingrese al sitio</h1>
		<br>
		<form action="/HotelApp/login" method="POST">
			Usuario:
			<input type="text" name="user"><br>
			Contrasenia:
			<input type="password" name="pass"><br>
			<input type="submit" value="Ingresar" >
		</form>
		<br>
		<a href="/HotelApp/register" method="GET">Registrese aqui</a>

		<div class="footer">HotelApp</div>
	</body>
</html>

	