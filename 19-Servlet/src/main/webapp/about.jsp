<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About Page</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>

<body>
	<h1>This is About Page.</h1>
	<h5>Your Details Here...</h5>
	
	<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String branch = request.getParameter("branch");
	%>

	<p>
		Name:
		<%=name%>
	</p>
	<p>
		Age:
		<%=age%>
	</p>
	<p>
		Branch:
		<%=branch%>
	</p>
</body>

</html>