<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
	<div class="row">
	<div class="col-md-6 m-auto">
	<h1 align="center">Employee Details</h1>
			<table class="table">
			<tr>
			<th>Id</th>
			<th>Uname</th>
			<th>Email</th>
			<th>Password</th>
			<th>Phone</th>
			<th>Action</th>
			</tr>
			
		
		
		<c:forEach var="e" items="${data}">
		<tr>
				<td>${e.getId()}</td>
				<td>${e.getUname()}</td>
				<td>${e.getEmail()}</td>
				<td>${e.getPass()}</td>
				<td>${e.getPhone()}</td>
				<td><a href="update?action=edit&uid=${e.getId()}" class="btn btn-primary">Edit</a></td>
				<td><a href="update?action=delete&uid=${e.getId()}" class="btn btn-danger">Delete</a></td>
		</tr>	
		</c:forEach>
		</table>
		</div>
		</div>
		</div>
		
</body>
</html>