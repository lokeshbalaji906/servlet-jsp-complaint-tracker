<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> View Complaints </title>
</head>
<body>
	<h2> Your Complaints </h2>
	
	<table border = "1">
		<tr>
			<th> ID </th>
			<th> Title </th>
			<th> Description </th>
			<th> Status </th>
			<th> Date </th>
		</tr>
		
		<c:forEach var="c" items = "${complaints}">
			<tr>
				<td> ${c.complaintId} </td>
				<td> ${c.title} </td>
				<td>${c.description}</td>
    			<td>${c.status}</td>
    			<td>${c.createdAt}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="addComplaint.jsp"> Add New Complaint </a>
	
</body>
</html>