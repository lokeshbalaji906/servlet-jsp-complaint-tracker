<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Admin Complaints </title>
</head>
<body>
	<h2> All Complaints </h2>
	
	<table border="1">
		<tr>
			<th> ID </th>
			<th>Title</th>
    		<th>Description</th>
    		<th>Status</th>
    		<th>Action</th>
		</tr>
		
		<c:forEach var="c" items="${complaints}">
			<tr>
				<td> ${c.complaintId} </td>
				<td>${c.title}</td>
    			<td>${c.description}</td>
    			<td>${c.status}</td>
    			<td>
    				<form method="post" action = "updateStatus">
    					<input type="hidden" name = "complaintId" value="${c.complaintId}" />
    					<select name="status">
    						<option> Open </option>
    						<option> IN_PROGRESS </option>
    						<option> RESOLVED </option>
    					</select>
    					<input type="submit" value="upate" />
    				</form>
    			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>