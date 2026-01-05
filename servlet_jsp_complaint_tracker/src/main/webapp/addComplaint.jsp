<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Complaint Form </title>
</head>
<body>
	<h2> Raise Complaint. </h2>
	<form method = "post" action = "addComplaint">
		Title: <input type="text" name = "title" /> <br/> <br/>
		Description: <br />
		<textarea name="description"></textarea> <br/> <br/>
		<input type = "submit" value = "Submit Complaint" />
	</form>
	
	<a href = "viewComplaints"> View Complaints </a>
	<a href="./admin/complaints"> Admin Complaints </a>
</body>
</html>