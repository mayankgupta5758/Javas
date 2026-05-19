<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Student"%>

<%
Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Updated Student Details</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
<%if (session.getAttribute("userName") == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return; } %>
	<div class="circle-form">

		<form action="<%=request.getContextPath()%>/updateStudent"
			method="post">
				<% if (session.getAttribute("updatestdfailmsg") != null) { %>
				<h3 style="color: red;"><%=session.getAttribute("updatestdfailmsg")%></h3>
				<% } session.removeAttribute("updatestdfailmsg"); %>
				
			<a type="submit" id="button-333"
				href="<%=request.getContextPath()%>/views/student-list.jsp">
				Back </a>
			<h2>Update Student Details Here...</h2>

			<input type="hidden" name="id" value="<%=student.getsId()%>">
			<input type="text" name="name" value="<%=student.getsName()%>"
				placeholder="Enter Name" required> <input type="email"
				name="email" value="<%=student.getEmail()%>"
				placeholder="Enter Email" required> <input type="number"
				name="age" value="<%=student.getAge()%>" placeholder="Enter Age"
				required> <input type="text" name="phone"
				value="<%=student.getPhone()%>" placeholder="Enter Phone Number"
				required> <input type="text" name="city"
				value="<%=student.getCity()%>" placeholder="Enter City" required>

			<button type="submit">Update Student</button>
		</form>
	</div>

</body>
</html>