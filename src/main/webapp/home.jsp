<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Home page</title>
        <link rel="stylesheet" href="project.css">
    </head>
<body>
    <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/SledenjeNaPratki" user="root" password = "123456"/>
    <sql:query var="rs" dataSource="${db}">select * from pratka</sql:query>
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
       		<a href="vnesipratka.jsp"><button class="enterShipment">Enter new shipment</button></a>
        	<form action="LogoutApi" method="GET">
           		<input id="logout" type="submit" name="logout" value="Logout">
       		</form>
       		<table>
	       	<tr>
	       		<th>ID</th>
	       		<th>Date from</th>
	       		<th>Date to</th>
	       		<th>Status</th>
	       		<th>Location</th>
	       		<th></th>
	       		<th></th>
	       	</tr><br>
	       	<c:forEach items="${rs.rows}" var="pratka">
	       	<tr>
	       		<td><c:out value="${pratka.id}"></c:out></td>
	       		<td><c:out value="${pratka.datumOd}"></c:out></td>
	       		<td><c:out value="${pratka.datumDo}"></c:out></td>
	       		<td><c:out value="${pratka.status}"></c:out></td>
	       		<td><c:out value="${pratka.lokacija}"></c:out></td>
	       		<td>
	       			<form action="IzbrisiPratkaApi" action="GET">
	       				<input hidden type="text" value="<c:out value="${pratka.id}"></c:out>"  name="izbrisi">
	       				<input id="delete" type="submit" value="Delete">
	       			</form>
	       		</td>
	       		<td>
	       			<form action="IznemiPratkaApi" action="GET">
	       				<input hidden type="text" value="<c:out value="${pratka.id}"></c:out>"  name="id">
	       				<input hidden type="text" value="<c:out value="${pratka.datumOd}"></c:out>"  name="datumOd">
	       				<input hidden type="text" value="<c:out value="${pratka.datumDo}"></c:out>"  name="datumDo">
	       				<input id="change" type="submit" value="Change shipment">
	       			</form>
	       		</td>
	       	</tr>
	       	</c:forEach>
       		</table>
		</div>
    </body>
</html>