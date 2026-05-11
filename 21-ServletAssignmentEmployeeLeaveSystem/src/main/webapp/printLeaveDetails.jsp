<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Details</title>
<style type="text/css">
body {
	color: bisque;
	background-color: rgb(226, 179, 187);
	text-align: center;
	font-family: 'Times New Roman', Times, serif;
}

button {
	color: rgb(226, 179, 187);
	background-color: bisque;
	border-radius: 25px;
	width: auto;
	height: 28px;
	cursor: pointer;
	font-weight: 900;
}
</style>
</head>
<body>
	<%
	String name = (String) request.getAttribute("name");
	int id = (int) request.getAttribute("id");
	int days = (int) request.getAttribute("days");
	String dept = (String) request.getAttribute("dept");
	String leaveType = (String) request.getAttribute("leave");
	String reason = (String) request.getAttribute("reason");
	%>

	<h2>Registration Successful.</h2>
	<div>
		<h3>
			Name:
			<%=name%></h3>
	</div>
	<div>
		<h3>
			Id:
			<%=id%></h3>
	</div>
	<div>
		<h3>
			Department:
			<%=dept%></h3>
	</div>
	<div>
		<h3>
			Days:
			<%
		if (days <= 5) {
		%>
			This leave request can be processed normally
			<%
		} else {
		%>
			This leave request requires manager approval
			<%
		}
		%>
		</h3>
	</div>
	<div>
		<h3>
			Leave Type:
			<%=leaveType%></h3>
	</div>
	<div>
		<h3>
			Reason:
			<%=reason%></h3>
	</div>
</body>
</html>