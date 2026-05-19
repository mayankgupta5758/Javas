<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Course Details</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
	<div class="circle-form">

		
			<%
			if (session.getAttribute("userName") == null) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				return;
			}
			%>
			<%
			if (session.getAttribute("addcoursefaildmsg") != null) {
			%>
			<h3 style="color: red;">
			<%= session.getAttribute("addcoursefaildmsg")%>
			</h3>
			<%
			}
			%>
		
		<% session.removeAttribute("addcoursefaildmsg"); %>

		<form action="<%=request.getContextPath()%>/addCourse" method="post">
			<a type="submit" id="button-333"
				href="<%=request.getContextPath()%>/views/course-list.jsp"> Back
			</a>
			<h2>Add Course Details Here...</h2>
			<input name="name" placeholder="Enter Name" required> <input
				name="duration" placeholder="Enter Duration(in Weeks)" required>
			<input name="fees" placeholder="Enter Fees" required> <input
				name="trainerName" placeholder="Enter Trainer Name" required>

			<button type="submit">Add Course</button>
		</form>
	</div>
</body>
</html>