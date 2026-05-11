<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Details</title>
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
	int roll = (int) request.getAttribute("roll");
	int sub1 = (int) request.getAttribute("sub1");
	int sub2 = (int) request.getAttribute("sub2");
	int sub3 = (int) request.getAttribute("sub3");
	%>

	<h2>Registration Successful.</h2>
	<div>
		<h3>
			Name:
			<%=name%></h3>
	</div>
	<div>
		<h3>
			Roll Number:
			<%=roll%></h3>
	</div>
	<div>
		<h3>
			Subject 1 marks:
			<%=sub1%></h3>
	</div>
	<div>
		<h3>
			Subject 2 marks:
			<%=sub2%></h3>
	</div>
	<div>
		<h3>
			Subject 3 marks:
			<%=sub3%></h3>
	</div>

	<%
	int total = sub1 + sub2 + sub3;
	double percentage = total / 3.0;

	String result;

	if (percentage >= 75) {
		result = "Distinction";
	} else if (percentage >= 60) {
		result = "First Class";
	} else if (percentage >= 40) {
		result = "Pass";
	} else {
		result = "Fail";
	}
	%>

	<div>
		<h3>
			Total Marks:
			<%=total%></h3>
	</div>

	<div>
		<h3>
			Percentage:
			<%=percentage%>%
		</h3>
	</div>

	<div>
		<h3>
			Result Status:
			<%=result%></h3>
	</div>

	<div>
		<form action="welcome.html" method="post">
			<button type="submit">Home</button>
		</form>
	</div>
</body>
</html>