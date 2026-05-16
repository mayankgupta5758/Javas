<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.CourseDAO"%>
<%@ page import="dao.StudentDAO"%>
<%@ page import="dao.RegistrationDAO"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>

<body>
	<%
	String userName = (String) request.getSession().getAttribute("userName");
	if (userName == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return;
	}
	String firstLetter = userName.substring(0, 1);
	CourseDAO courseDAO = new CourseDAO();
	StudentDAO studentDAO = new StudentDAO();
	RegistrationDAO regDAO = new RegistrationDAO();
	int totalStd = studentDAO.totalNumberOfStudent();
	int totalCourse = courseDAO.totalNumberOfCourse();
	int totalReg = regDAO.totalNumberOfRegistration();
	%>

	<div class="dashboard-river">

		<div class="dashboard-container">

			<div class="dashboard">

				<div class="ui-row-1">

					<div class="logo-comp">
						<p>
							Welcome
							<%=userName%></p>
					</div>

					<div class="search">
						<input>
					</div>

					<div class="logout">
						<div>
							<form action="<%=request.getContextPath()%>/logout">
								<button type="submit" id="button-333" role="button">Logout</button>
							</form>
						</div>
					</div>
				</div>



				<div class="ui-row-2">
					<div class="main-content">

						<div class="header">

							<div class="page-display">
								<h1>Home</h1>
								<h2>Explore Our Services</h2>
							</div>

							<div class="clay-category">
								<p>Total Number of Students</p>
								<p><%=totalStd%></p>
							</div>

							<div class="clay-category">
								<p>Total Number of Course</p>
								<p><%=totalCourse%></p>
							</div>

							<div class="clay-category">
								<p>Total Number of Registration</p>
								<p><%= totalReg %></p>
							</div>
						</div>
					</div>
				</div>

				<div class="addbutton">
					<div class="">
						<form
							action="<%=request.getContextPath()%>/views/student-list.jsp"
							method="post">
							<button type="submit" id="button-333" role="button">See
								All Student</button>
						</form>
					</div>

					<div class="">
						<form
							action="<%=request.getContextPath()%>/views/course-list.jsp"
							method="get">
							<button type="submit" id="button-333" role="button">See
								All Course</button>
						</form>
					</div>

					<div class="">
						<form action="<%=request.getContextPath()%>/views/registration-list.jsp"
							method="post">
							<button type="submit" id="button-333" role="button">See
								All Registration</button>
						</form>
					</div>
					
					<div class="">
						<form action="<%=request.getContextPath()%>/views/filter-list.jsp"
							method="post">
							<button type="submit" id="button-333" role="button">Apply Filter</button>
						</form>
					</div>

				</div>

			</div>

		</div>

	</div>

</body>

</html>