<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.demo.complaint.model.User" %>
    
<% 
	User user = (User) session.getAttribute("loggedUser");
	
	if(user == null) {
		response.sendRedirect("login.jsp");
		return;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Dashboard </title>
</head>
<body>

	<h2> Welcome to <%= user.getName() %> </h2>
	<p> Role: <%= user.getRole() %>> </p>
	
	<ul>
		<li> <a href="addComplaint.jsp"> Raise Complaint </a> </li>
		<li> <a href="viewComplaints"> My Complaints </a>
		
		<% 
			if("ADMIN".equals(user.getRole())) {
		%>
			<li> <a href="admin/complaints"> Admin Panel </a> </li>
		<%
			}
		%>
		
		<li> <a href="logout"> Logout </a> </li> 
	</ul>
</body>
</html>