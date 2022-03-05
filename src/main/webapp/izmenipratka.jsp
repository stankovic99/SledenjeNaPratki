<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Change shipment</title>
	<link rel="stylesheet" href="project.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session != null)
		{
		if (session.getAttribute("username") == null) 
			{
				response.sendRedirect("login.jsp");
			}
		}
	%>
	<div class="nadvoresenDiv2">
		<h1>User: ${fullname}</h1>     
		<form action="LogoutApi" method="GET">
			<input id="logout" type="submit" name="logout" value="Logout">
		</form>
		<a href="home.jsp"><button class="backShipment">Back to shipment</button></a><br>
		<div class="nadvoresenDiv">
			<form action="PratkaApi" method="POST">
				<label>Id</label><input type="text" name="id" value="${id }" readonly><br>
				<label>Date from</label><input type="date" name="datumOd" value="${datumOd }" readonly><br>
				<label>Date to</label><input type="date" name="datumDo" value="${datumDo }"><br>
				<label>Status</label><input placeholder="Enter status" type="text" name="status"><br>
				<label>Location</label><input placeholder="Enter location" type="text" name="lokacija"><br>
				<input hidden type="text" name="id" value="${id}"><br>
				<button type="submit">Change</button>
			</form>
		</div>
	</div>
</body>
</html>