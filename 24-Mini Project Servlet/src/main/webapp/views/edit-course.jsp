<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Course"%>

<%
Course course = (Course) request.getAttribute("course");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Updated Course Details</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
		<%if (session.getAttribute("userName") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return; } %>
	<div class="circle-form">
		<%if (request.getAttribute("updatcourseefailmsg") != null) { %>
			<h3 style="color: red;"> <%=request.getAttribute("updatcourseefailmsg")%></h3>
			<%} session.removeAttribute("updatcourseefailmsg"); %>
			
		<form action="<%=request.getContextPath()%>/updateCourse"
			method="post">
		<a type="submit" id="button-333"
			href="<%=request.getContextPath()%>/views/course-list.jsp"> Back
		</a>
			<h2>Update Course Details Here...</h2>

			<input type="hidden" name="id" value="<%=course.getcId() %>">
			<input type="text" name="name" value="<%=course.getcName()%>"
				placeholder="Enter Name" required> 
				<input type="duration"
				name="duration" value="<%=course.getDuration()%>"
				placeholder="Enter Duration" required>
				 <input type="number"
				name="fees" value="<%=course.getFees()%>" placeholder="Enter Fees"
				required>
				 <input type="text" name="trainerName"
				value="<%=course.getTrainerName()%>" placeholder="Enter Trainer Name"
				required> 

			<button type="submit">Update Course</button>
		</form>
	</div>

</body>
</html>