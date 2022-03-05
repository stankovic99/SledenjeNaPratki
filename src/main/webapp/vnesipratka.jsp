<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert shipment</title>
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
		<h1>User: ${fullname }</h1>
		<form action="LogoutApi" method="GET">
			<input id="logout" type="submit" name="logout" value="Logout">
		</form>
		<a href="home.jsp"><button class="backShipment">Back to shipment</button></a>
		<br><br><br>
    	<div class="nadvoresenDiv">
			<form action="PratkaApi" method="get">
				<label>Date from: </label><input type="date" name="datumod"> <br>
				<label>Date to: </label><input type="date" name="datumdo"> <br>
				<label>Location: </label><input placeholder="Enter location" type="text" name="lokacija"> <br>
				<button type="submit">Enter shipment</button>
			</form>
        </div>
	</div>
</body>
</html>