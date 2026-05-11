<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>

<body>
	<%
	String userName = (String) request.getSession().getAttribute("userName");
	String firstLetter = userName.substring(0, 1);
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
							<form action="<%= request.getContextPath() %>/logout">
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
								<p>10</p>
							</div>

							<div class="clay-category">
								<p>Total Number of Course</p>
								<p>10</p>
							</div>

							<div class="clay-category">
								<p>Total Number of Registration</p>
								<p>11</p>
							</div>
						</div>
					</div>
				</div>

				<div class="addbutton">
					<div class="">
						<form action="<%=request.getContextPath()%>/seestudent"
							method="post">
							<button type="submit" id="button-333" role="button">
								See All Student</button>
						</form>
					</div>

					<div class="">
						<form action="<%=request.getContextPath()%>/seecourse"
							method="post">
							<button type="submit" id="button-333" role="button">See
								All Course</button>
						</form>
					</div>

					<div class="">
						<form action="<%=request.getContextPath()%>/seeregistration"
							method="post">
							<button type="submit" id="button-333" role="button">Add
								Registration</button>
						</form>
					</div>

				</div>

			</div>

		</div>

	</div>

</body>

</html>