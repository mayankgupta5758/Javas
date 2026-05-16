<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="dao.StudentDAO"%>
	<%@ page import="model.Student"%>
	<%@ page import="dao.CourseDAO"%>
	<%@ page import="model.Course"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Filter Details</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
<%if (session.getAttribute("userName") == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return;
} %>
	<div class="circle-form">
	
		<form action="<%=request.getContextPath()%>/filterRegistration"
	method="get">
<a type="submit" id="button-333"
			href="<%=request.getContextPath()%>/views/dashboard.jsp"> Back
		</a>
	<select name="studentId">

		<option value="">All Students</option>

		<%
		for(Student s : new StudentDAO().seeAllStudent()){
		%>

		<option value="<%=s.getsId()%>">
			<%=s.getsName()%>
		</option>

		<%
		}
		%>

	</select>

	<select name="courseId">

		<option value="">All Courses</option>

		<%
		for(Course c : new CourseDAO().seeAllCourse()){
		%>

		<option value="<%=c.getcId()%>">
			<%=c.getcName()%>
		</option>

		<%
		}
		%>

	</select>

	<select name="status">

		<option value="">All Status</option>
		<option value="Active">Active</option>
		<option value="Completed">Completed</option>
		<option value="Cancelled">Cancelled</option>

	</select>

	<button type="submit">Filter</button>

</form>
	</div>
</body>
</html>