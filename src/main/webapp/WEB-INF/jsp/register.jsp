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
		<% Boolean aux= (Boolean)session.getAttribute( "authentication"); 
			if(!aux){
		%>
			<strong>Ese usuario ya existe</strong><br>
		<%
		}
		%>
		<h1>Registro</h1><br>
		<br><form action="/HotelApp/register" method="POST">
		Usuario:
		<input type="text" name="user"><br>
		Contrasenia:
		<input type="password" name="pass"><br>
		Email:
		<input type="text" name="email"><br>
		<input type="submit" value="Enviar">
		</form><br>
		
		<div class="footer">HotelApp</div>
	</body>
</html>

	