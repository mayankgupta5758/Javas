<%@ page import="java.util.List"%>
<%@ page import="dao.RegistrationDAO"%>
<%@ page import="model.Registration"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/dashboard.css">
</head>

<body>
	<%
	if (session.getAttribute("userName") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return;
	}
	%>
	<%
	List<Registration> list = (List<Registration>) request.getAttribute("list");

	if (list == null) {
		list = new RegistrationDAO().seeAllRegistration();
	}
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
							<h2>Registration's Details Here...</h2>
							<a type="submit" title="Explore"
								href="<%=request.getContextPath()%>/views/registration-form.jsp">
								Add new Registration </a>
						</div>


						<%
						if (session.getAttribute("deleteregepassmsg") != null) {
						%>
						<h3 style="color: green;"><%=session.getAttribute("deleteregepassmsg")%></h3>
						<%
						}
						%>
						<%
						session.removeAttribute("deleteregepassmsg");
						%>

						<%
						if (session.getAttribute("deleteregfailmsg") != null) {
						%>
						<h3 style="color: red;"><%=session.getAttribute("deleteregfailmsg")%></h3>
						<%
						}
						%>
						<%
						session.removeAttribute("deleteregfailmsg");
						%>

						<%
						if (session.getAttribute("addregpassmsg") != null) {
						%>
						<h3 style="color: green;"><%=session.getAttribute("addregpassmsg")%></h3>
						<%
						}
						%>
						<%
						session.removeAttribute("addregpassmsg");
						%>

						<%
						if (session.getAttribute("updateregpassmsg") != null) {
						%>
						<h3 style="color: green;"><%=session.getAttribute("updateregpassmsg")%></h3>
						<%
						}
						%>
						<%
						session.removeAttribute("updateregpassmsg");
						%>
						<div class="featured-clay">

							<%
							if (list.size() > 0) {
								for (int i = 0; i < list.size(); i++) {
							%>
							<div>
								<div></div>
								<div style="color: rgb(20, 188, 138);">

									<h3>
										Registration Id:
										<%=list.get(i).getRegistrationId()%></h3>
									<p>
										Student Name:
										<%=new RegistrationDAO().getNameByStudentId(list.get(i).getStudentId())%>
									</p>

									<p>
										Course Name:
										<%=new RegistrationDAO().getNameByCourseId(list.get(i).getCourseId())%>
									</p>

									<p>
										Registration Date: <br /> <br /> <br /> <br /> <br /> <br />
										<br />
										<%=list.get(i).getRegistrationDate()%>
									</p>

									<p>
										Student Status:<br /> <br /> <br /> <br /> <br /> <br />
										<br />
										<%=list.get(i).getStatus()%>
									</p>
									<form action="<%=request.getContextPath()%>/editRegistration"
										method="get">

										<input type="hidden" name="id"
											value="<%=list.get(i).getRegistrationId()%>">

										<button type="submit">Edit</button>

									</form>
									<form action="<%=request.getContextPath()%>/deleteRegistration"
										method="post">

										<input type="hidden" name="id"
											value="<%=list.get(i).getRegistrationId()%>">

										<button type="submit">Delete</button>

									</form>

								</div>
							</div>
							<%
							}
							} else {
							%>
							<h1>No Registration Yet...</h1>
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