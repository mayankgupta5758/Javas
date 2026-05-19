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
	<%
	if (session.getAttribute("userName") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return;
	}
	%>
	<div class="circle-form">
		<form action="<%=request.getContextPath()%>/addStudent" method="post">
			<h3 style="color: red;">
				<%
				if (session.getAttribute("addstdfailmsg") != null) {
				%>
				<%=session.getAttribute("addstdfailmsg")%>
				<%
				}
				%>
			</h3>
			<%
			session.removeAttribute("addstdfailmsg");
			%>
			<a type="submit" id="button-333"
				href="<%=request.getContextPath()%>/views/student-list.jsp">
				Back </a>
			<h2>Add Student Details Here...</h2>
			<input name="name" placeholder="Enter Name" required> <input
				name="email" placeholder="Enter Email" required> <input
				name="age" placeholder="Enter Age" required> <input
				name="phone" placeholder="Enter Phone Number" required> <input
				name="city" placeholder="Enter City" required>

			<button type="submit">Add Student</button>
		</form>
	</div>
</body>
</html>