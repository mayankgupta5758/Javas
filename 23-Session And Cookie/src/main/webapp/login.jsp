<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="circle-form">
        <form action="login" method="post">
            <h2>Welcome</h2>
            <input type="username" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Sign In</button>
        </form>
    </div>
</body>
</html>