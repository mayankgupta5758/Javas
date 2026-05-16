<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
	<div class="circle-form">
        <form action="login" method="post">
        <h3 style="color: red;"><% if(request.getAttribute("adminmsg") != null) { %> <%= request.getAttribute("adminmsg") %> <% } %></h3>
        <% session.removeAttribute("adminmsg"); %>
            <h2>Welcome</h2>
            <input name="userName" placeholder="UserName" required>
            <input name="password" placeholder="Password" required>
            <button type="submit">Sign In</button>
        </form>
    </div>
</body>
</html>