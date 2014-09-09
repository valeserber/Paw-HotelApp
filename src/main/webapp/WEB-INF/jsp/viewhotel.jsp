<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
		<%@ page import="java.util.*,java.text.*" %>
		<%@ page contentType="text/html" %>
		<%@ page pageEncoding="UTF-8" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		
		<jsp:useBean id="hotel" class="ar.edu.itba.it.paw.model.Hotel" scope="request"/> 
	</head>
	
	<body>
		<!--<jsp:include page="hello.jsp"/>-->

		<div style="overflow: auto;">
			<h1 style="float: left; margin-top: 0;">
				<c:out value="${hotel.name}" />
			</h1>
			
		</div>
		
		<p/>
		
	<strong>Descripción: </strong>
		<c:out value="${hotel.description}"/>
	<br>
	<strong>Comentarios de usuarios: </strong><br>
	<ul>
			<c:forEach var="comment" items="${commentlist}">
			<li>
				<strong><c:out value="${comment.user.name}" /></strong>
				(<c:out value="${comment.user.email}" />):
				<br>
				<c:out value="${comment.text}" />
			</li> 
			<br>
			</c:forEach>
			
	</ul>

	<br>
	<form action="/HotelApp/addComment" method="POST">
		<input type="hidden" name="code" value="${hotel.code}">
		Ingrese su comentario:
		<input type="text" name="comment">
		<input type="submit" value="Enviar" >
		<br>
	</form>
		<br>
		<a href="/HotelApp/logout">Log out</a>
		<div class="footer">HotelApp</div>
	</body>
</html>
