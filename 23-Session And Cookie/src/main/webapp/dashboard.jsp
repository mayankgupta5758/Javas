<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    HttpSession session = request.getSession(false); 

    if(session != null && session.getAttribute("user") != null) {
%>
	<h2>
		Welcome
		<%= session.getAttribute("user") %></h2>
	<a href="logout">Logout</a>
	<%
    } else {
        response.sendRedirect("login.html");
    }
%>
</body>
</html>