<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Student Details</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
	<div class="circle-form">
	<h3><% if(request.getSession().getAttribute("addstdmsg") != null) { %> <%= request.getSession().getAttribute("addstdmsg") %> <% } %></h3>
	
		<form action="<%=request.getContextPath()%>/addStudent" method="post">
			<h2>Add Student Details Here...</h2>
			<input name="name" placeholder="Enter Name" required>
			<input name="email" placeholder="Enter Email" required>
			<input name="age" placeholder="Enter Age" required>
			<input name="phone" placeholder="Enter Phone Number" required>
			<input name="city" placeholder="Enter City" required>
			
			<button type="submit">Add Student</button>
		</form>
	</div>
</body>
</html>