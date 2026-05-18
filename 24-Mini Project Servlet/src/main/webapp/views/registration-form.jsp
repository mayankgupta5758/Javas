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

<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/drop.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<%
if (session.getAttribute("userName") == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return;
}
%>

<div class="circle-form">

	<form action="<%=request.getContextPath()%>/addRegistration"
		method="post">

		<a type="submit" id="button-333"
			href="<%=request.getContextPath()%>/views/registration-list.jsp">
			Back
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

		<!-- STUDENT DROPDOWN -->
		<div class="dropdown dropdown-5">

			<button type="button" class="dropdown-toggle">
				Select Student
				<i class="fas fa-chevron-down"></i>
			</button>

			<div class="dropdown-menu">

				<%
				for (Student s : students) {
				%>

				<label class="dropdown-item">

					<input type="radio" name="studentId"
						value="<%=s.getsId()%>" required>

					<%=s.getsName()%>

				</label>

				<%
				}
				%>

			</div>

		</div>

		<!-- COURSE DROPDOWN -->
		<div class="dropdown dropdown-3">

			<button type="button" class="dropdown-toggle">
				Select Course
				<i class="fas fa-chevron-down"></i>
			</button>

			<div class="dropdown-menu">

				<%
				for (Course c : courses) {
				%>

				<label class="dropdown-item">

					<input type="radio" name="courseId"
						value="<%=c.getcId()%>" required>

					<%=c.getcName()%>

				</label>

				<%
				}
				%>

			</div>

		</div>

		<input type="date" name="registrationDate" required>

		<!-- STATUS DROPDOWN -->
		<div class="dropdown dropdown-1">

			<button type="button" class="dropdown-toggle">
				Select Status
				<i class="fas fa-chevron-down"></i>
			</button>

			<div class="dropdown-menu">

				<label class="dropdown-item">
					<input type="radio" name="status"
						value="Active" required>
					Active
				</label>

				<label class="dropdown-item">
					<input type="radio" name="status"
						value="Completed">
					Completed
				</label>

				<label class="dropdown-item">
					<input type="radio" name="status"
						value="Cancelled">
					Cancelled
				</label>

			</div>

		</div>

		<button type="submit">Add Registration</button>

	</form>

</div>


<script>

	// STUDENT
	const studentItems = document.querySelectorAll(
			'input[name="studentId"]');

	const studentBtn = document.querySelectorAll(
			'.dropdown-toggle')[0];

	studentItems.forEach(item => {

		item.addEventListener('change', function() {

			let text = this.parentElement.textContent.trim();

			studentBtn.innerHTML = text
					+ ' <i class="fas fa-chevron-down"></i>';

		});

	});

	// COURSE
	const courseItems = document.querySelectorAll(
			'input[name="courseId"]');

	const courseBtn = document.querySelectorAll(
			'.dropdown-toggle')[1];

	courseItems.forEach(item => {

		item.addEventListener('change', function() {

			let text = this.parentElement.textContent.trim();

			courseBtn.innerHTML = text
					+ ' <i class="fas fa-chevron-down"></i>';

		});

	});

	// STATUS
	const statusItems = document.querySelectorAll(
			'input[name="status"]');

	const statusBtn = document.querySelectorAll(
			'.dropdown-toggle')[2];

	statusItems.forEach(item => {

		item.addEventListener('change', function() {

			let text = this.parentElement.textContent.trim();

			statusBtn.innerHTML = text
					+ ' <i class="fas fa-chevron-down"></i>';

		});

	});

</script>

</body>
</html>