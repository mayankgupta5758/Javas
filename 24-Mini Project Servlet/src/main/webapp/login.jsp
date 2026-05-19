<%@ page import="jakarta.servlet.http.Cookie"%>

<%
String rememberedUser = "";

Cookie[] cookies = request.getCookies();

if (cookies != null) {
	for (Cookie c : cookies) {
		if (c.getName().equals("rememberUser")) {
	rememberedUser = c.getValue();
		}
	}
}
%>

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

			<h3 style="color: red;">
				<%
				if (session.getAttribute("adminfailmsg") != null) {
				%>
				<%=session.getAttribute("adminfailmsg")%>
				<%
				}
				session.removeAttribute("adminfailmsg");
				%>
			</h3>

			<h2>Welcome</h2>

			<input name="userName" placeholder="UserName"
				value="<%=rememberedUser%>" required> <input type="password"
				name="password" placeholder="Password" required>

			<div style="margin: 10px 0;">
				<input type="checkbox" name="remember"
					<%=!rememberedUser.isEmpty() ? "checked" : ""%>> Remember
				Username
			</div>

			<button type="submit">Sign In</button>

		</form>

	</div>

</body>
</html>