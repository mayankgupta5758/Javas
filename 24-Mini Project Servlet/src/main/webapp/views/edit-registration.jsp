<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Registration"%>
<%@ page import="dao.StudentDAO"%>
<%@ page import="dao.CourseDAO"%>
<%@ page import="model.Student"%>
<%@ page import="model.Course"%>
<%@ page import="java.util.List"%>

<%
Registration registration = (Registration) request.getAttribute("registration");
List<Student> students = new StudentDAO().seeAllStudent();
List<Course> courses = new CourseDAO().seeAllCourse();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Updated Registration Details</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
<%if (session.getAttribute("userName") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return;
	} %>
	<div class="circle-form">
		<%
		if (request.getAttribute("updatregistrationemsg") != null) {
		%>
		<h3 style="color: red;">
			<%=request.getAttribute("updatregistrationemsg")%>
		</h3>
		<%
		}
		%>
		<% session.removeAttribute("updatregistrationemsg"); %>
		<form action="<%=request.getContextPath()%>/updateRegistration"
			method="post">
			<a type="submit" id="button-333"
			href="<%=request.getContextPath()%>/views/registration-list.jsp"> Back
		</a>
			<input type="hidden" name="id"
				value="<%=registration.getRegistrationId()%>">
			<h2>Update Registration Details Here...</h2>

			<select name="studentId" required>
				<%
				for (Student s : students) {
				%>
				<option value="<%=s.getsId()%>"
					<%=s.getsId() == registration.getStudentId() ? "selected" : ""%>>
					<%=s.getsName()%>
				</option>
				<%
				}
				%>
			</select> <select name="courseId" required>
				<%
				for (Course c : courses) {
				%>
				<option value="<%=c.getcId()%>"
					<%=c.getcId() == registration.getCourseId() ? "selected" : ""%>>
					<%=c.getcName()%>
				</option>
				<%
				}
				%>
			</select> <input type="date" name="registrationDate"
				value="<%=registration.getRegistrationDate()%>" required> <select
				name="status" required>
				<option value="Active"
					<%=registration.getStatus().equals("Active") ? "selected" : ""%>>
					Active</option>
				<option value="Completed"
					<%=registration.getStatus().equals("Completed") ? "selected" : ""%>>
					Completed</option>
				<option value="Cancelled"
					<%=registration.getStatus().equals("Cancelled") ? "selected" : ""%>>
					Cancelled</option>
			</select>

			<button type="submit">Update Registration</button>
		</form>
	</div>

</body>
</html>