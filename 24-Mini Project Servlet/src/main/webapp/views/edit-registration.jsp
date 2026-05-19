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

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/drop.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>
<body>

	<% if (session.getAttribute("userName") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return;
	} %>

	<div class="circle-form">
		<% if (session.getAttribute("updatregfailemsg") != null) { %>
		<h3 style="color: red;"> <%=session.getAttribute("updatregfailemsg")%> </h3>
		<% } session.removeAttribute("updatregfailemsg"); %>

		<form action="<%=request.getContextPath()%>/updateRegistration"
			method="post">

			<a type="submit" id="button-333"
				href="<%=request.getContextPath()%>/views/registration-list.jsp">
				Back </a> <input type="hidden" name="id"
				value="<%=registration.getRegistrationId()%>">

			<h2>Update Registration Details Here...</h2>

			<div class="dropdown dropdown-5">
				<button type="button" class="dropdown-toggle">
					<%for (Student s : students) {
						if (s.getsId() == registration.getStudentId()) {
					%>
					<%=s.getsName()%>
					<% } } %>
					<i class="fas fa-chevron-down"></i>
				</button>
				<div class="dropdown-menu">
					<%
					for (Student s : students) {
					%>
					<label class="dropdown-item"> <input type="radio"
						name="studentId" value="<%=s.getsId()%>"
						<%=s.getsId() == registration.getStudentId() ? "checked" : ""%>
						required> <%=s.getsName()%>
					</label>
					<% } %>
				</div>
			</div>
			
			<div class="dropdown dropdown-3">

				<button type="button" class="dropdown-toggle">

					<% for (Course c : courses) {
						if (c.getcId() == registration.getCourseId()) {
					%>
					<%=c.getcName()%>
					<% } } %>

					<i class="fas fa-chevron-down"></i>
				</button>
				
				<div class="dropdown-menu">
					<%
					for (Course c : courses) {
					%>

					<label class="dropdown-item"> <input type="radio"
						name="courseId" value="<%=c.getcId()%>"
						<%=c.getcId() == registration.getCourseId() ? "checked" : ""%>
						required> <%=c.getcName()%>
					</label>
					<% } %>
				</div>
			</div>
			<input type="date" name="registrationDate"
				value="<%=registration.getRegistrationDate()%>"
				max="<%=java.time.LocalDate.now()%>" required>

			<div class="dropdown dropdown-1">
				<button type="button" class="dropdown-toggle">
					<%=registration.getStatus()%>
					<i class="fas fa-chevron-down"></i>
				</button>
				<div class="dropdown-menu">
					<label class="dropdown-item"> <input type="radio"
						name="status" value="Active"
						<%=registration.getStatus().equals("Active") ? "checked" : ""%>
						required> Active
					</label> <label class="dropdown-item"> <input type="radio"
						name="status" value="Completed"
						<%=registration.getStatus().equals("Completed") ? "checked" : ""%>>
						Completed
					</label> <label class="dropdown-item"> <input type="radio"
						name="status" value="Cancelled"
						<%=registration.getStatus().equals("Cancelled") ? "checked" : ""%>>
						Cancelled
					</label>
				</div>
			</div>
			<button type="submit">Update Registration</button>
		</form>
	</div>

	<script>

	const studentItems = document.querySelectorAll('input[name="studentId"]');
	const studentBtn = document.querySelectorAll('.dropdown-toggle')[0];

	studentItems.forEach(item => {
		item.addEventListener('change', function() {
			let text = this.parentElement.textContent.trim();
			studentBtn.innerHTML = text + ' <i class="fas fa-chevron-down"></i>';
		});
	});

	const courseItems = document.querySelectorAll('input[name="courseId"]');
	const courseBtn = document.querySelectorAll('.dropdown-toggle')[1];

	courseItems.forEach(item => {
		item.addEventListener('change', function() {
			let text = this.parentElement.textContent.trim();
			courseBtn.innerHTML = text + ' <i class="fas fa-chevron-down"></i>';
		});
	});

	const statusItems = document.querySelectorAll('input[name="status"]');
	const statusBtn = document.querySelectorAll('.dropdown-toggle')[2];
	statusItems.forEach(item => {
		item.addEventListener('change', function() {
			let text = this.parentElement.textContent.trim();
			statusBtn.innerHTML = text + ' <i class="fas fa-chevron-down"></i>';
		});
	});

</script>
</body>
</html>