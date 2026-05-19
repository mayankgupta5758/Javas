<%@ page import="java.util.List"%>
<%@ page import="dao.CourseDAO"%>
<%@ page import="model.Course"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Course</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/dashboard.css">
</head>

<body>
	<% List<Course> list = new CourseDAO().seeAllCourse();
	if (session.getAttribute("userName") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return;
	} %>
	<div class="dashboard-river">
		<div class="dashboard-container">
			<div class="dashboard">
				<div class="ui-row-2">
					<div class="main-content">
						<a type="submit" id="button-333"
							href="<%=request.getContextPath()%>/views/dashboard.jsp">
							Back </a>
						<div class="large-banner">
							<h2>Course's Details Here...</h2>
							<a type="submit" title="Explore"
								href="<%=request.getContextPath()%>/views/course-form.jsp">
								Add new Course </a>
						</div>
						<hr>

						<% if (session.getAttribute("deletecoursepassmsg") != null) { %>
						<h3 style="color: green;"><%=session.getAttribute("deletecoursepassmsg")%></h3>
						<% } session.removeAttribute("deletecoursepassmsg"); %>
						
						<% if (session.getAttribute("addcoursepassmsg") != null) { %>
						<h3 style="color: green;"><%=session.getAttribute("addcoursepassmsg")%></h3>
						<% } session.removeAttribute("addcoursepassmsg"); %>
						
						<% if (session.getAttribute("updatecoursepassmsg") != null) { %>
						<h3 style="color: green;"><%=session.getAttribute("updatecoursepassmsg")%></h3>
						<% } session.removeAttribute("updatecoursepassmsg"); %>

						<div class="featured-clay">

							<% if (list.size() > 0) {
								for (int i = 0; i < list.size(); i++) {
							%>
							<div>
								<div></div>
								<div style="color: rgb(20, 188, 138);">
									<h3>
										Name:
										<%=list.get(i).getcName()%></h3>
									<p>
										Id:
										<%=list.get(i).getcId()%></p>
									<p>
										Duration:
										<%=list.get(i).getDuration()%></p>
									<p>
										Fees:
										<%=list.get(i).getFees()%></p>
									<p>
										Trainer Name:
										<%=list.get(i).getTrainerName()%></p>

									<form action="<%=request.getContextPath()%>/editCourse"
										method="get">

										<input type="hidden" name="id"
											value="<%=list.get(i).getcId()%>">

										<button type="submit">Edit</button>

									</form>
									<form action="<%=request.getContextPath()%>/deleteCourse"
										method="post">

										<input type="hidden" name="id"
											value="<%=list.get(i).getcId()%>">

										<button type="submit">Delete</button>

									</form>

								</div>
							</div>
							<%
							}
							} else {
							%>
							<h1>No Course Yet...</h1>
							<%
							}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>