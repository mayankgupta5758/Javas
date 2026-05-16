<%@ page import="java.util.List"%>
<%@ page import="dao.StudentDAO"%>
<%@ page import="dao.CourseDAO"%>
<%@ page import="model.Student"%>
<%@ page import="model.Course"%>

<%
List<Student> students = new StudentDAO().seeAllStudent();
List<Course> courses = new CourseDAO().seeAllCourse();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Registration</title>

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>

<body>
<%if (session.getAttribute("userName") == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return;
} %>
	<div class="circle-form">

		<form action="<%=request.getContextPath()%>/addRegistration"
			method="post">
			<a type="submit" id="button-333"
			href="<%=request.getContextPath()%>/views/registration-list.jsp"> Back
		</a>
				<%
				if (session.getAttribute("addregistrationmsg") != null) {
				%>
				<h3 style="color: red;">
				<%=session.getAttribute("addregistrationmsg")%>
				</h3>
				<%
				session.removeAttribute("addregistrationmsg");
				}
				%>
			<h2>Add Registration Details Here...</h2>

			<select name="studentId" required>
				<option value="">Select Student</option>
				<%
				for (Student s : students) {
				%>
				<option value="<%=s.getsId()%>">
					<%=s.getsName()%>
				</option>
				<%
				}
				%>

			</select> <select name="courseId" required>
				<option value="">Select Course</option>
				<%
				for (Course c : courses) {
				%>
				<option value="<%=c.getcId()%>">
					<%=c.getcName()%>
				</option>
				<%
				}
				%>
			</select> <input type="date" name="registrationDate" required> <select
				name="status" required>
				<option value="">Select Status</option>
				<option value="Active">Active</option>
				<option value="Completed">Completed</option>
				<option value="Cancelled">Cancelled</option>
			</select>

			<button type="submit">Add Registration</button>
		</form>
	</div>
</body>
</html>