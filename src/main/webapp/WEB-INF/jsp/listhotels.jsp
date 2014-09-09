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
			<h1 style="float: left; margin-top: 0;">Lista de hoteles</h1>
			
		</div>
		
		<p/>
		
		<ul>
			<c:forEach var="hotel" items="${hotellist}">
			<li>
				<a href="/HotelApp/viewHotel?code=${hotel.code}">
					<c:out value="${hotel.name}" />
				</a>
				<c:out value="${hotel.code}" />
				<c:out value="${hotel.description}" />
			</li> 
			</c:forEach>
			
		</ul>
		<br>
		<a href="/HotelApp/logout">Log out</a>
		<div class="footer">HotelApp</div>
	</body>
</html>