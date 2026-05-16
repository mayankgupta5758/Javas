<%@ page import="java.util.List"%>
<%@ page import="dao.StudentDAO"%>
<%@ page import="model.Student"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/dashboard.css">
</head>

<body>
<%if (session.getAttribute("userName") == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return;
} %>
	<%
	List<Student> list = new StudentDAO().seeAllStudent();
	%>
	<div class="dashboard-river">
		<div class="dashboard-container">
			<div class="dashboard">
				<div class="ui-row-2">
					<div class="main-content">
					<a type="submit" id="button-333"
								href="<%=request.getContextPath()%>/views/dashboard.jsp">
								 Back </a>
						<div class="large-banner">
							<h2>Student's Details Here...</h2>
							<a type="submit" title="Explore"
								href="<%=request.getContextPath()%>/views/student-form.jsp">
								Add new Student </a>
						</div>
						<hr>

						<%
						if (request.getAttribute("deletestdmsg") != null) {
						%>
						<h3 style="color: red;"><%=request.getAttribute("deletestdmsg")%></h3>
						<%
						}
						%>
<% session.removeAttribute("deletestdmsg"); %>
						<div class="featured-clay">

							<%
							if (list.size() > 0) {
								for (int i = 0; i < list.size(); i++) {
							%>
							<div>
								<div></div>
								<div style="color: rgb(20, 188, 138);">

									<h3>
										Name:
										<%=list.get(i).getsName()%></h3>
									<p>
										Id:
										<%=list.get(i).getsId()%></p>
									<p>
										Email: <br /> <br /> <br /> <br /> <br /> <br /> <br />
										<%=list.get(i).getEmail()%></p>
									<p>
										Age:
										<%=list.get(i).getAge()%></p>
									<p>
										City:<br /> <br /> <br /> <br /> <br /> <br /> <br />
										<%=list.get(i).getCity()%></p>
									<p>
										Phone: +91
										<%=list.get(i).getPhone()%></p>

									<form action="<%=request.getContextPath()%>/editStudent"
										method="get">

										<input type="hidden" name="id"
											value="<%=list.get(i).getsId()%>">

										<button type="submit">Edit</button>

									</form>
									<form action="<%=request.getContextPath()%>/deleteStudent"
										method="post">

										<input type="hidden" name="id"
											value="<%=list.get(i).getsId()%>">

										<button type="submit">Delete</button>

									</form>

								</div>
							</div>
							<%
							}
							} else {
							%>
							<h1>No Student Yet...</h1>
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