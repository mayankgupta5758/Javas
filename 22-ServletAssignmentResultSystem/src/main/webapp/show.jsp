<%@ page import="java.util.*, resultPortal.Student" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	color: bisque;
	background-color: rgb(226, 179, 187);
	text-align: center;
	font-family: 'Times New Roman', Times, serif;
	font-size: 50px;
}
button {
	color: rgb(226, 179, 187);
	background-color: bisque;
	border-radius: 25px;
	width: auto;
	height: 30px;
	cursor: pointer;
	font-weight: 900;
}

</style>
</head>
<body>
<% List<Student> list = (List<Student>) 
request.getAttribute("studentList");

    for(Student s : list) { %>
    
    "Name: "  <%= s.getName() %>
    "Roll No: " <%= s.getRollno() %>
    "Marks1: " <%= s.getMarks1() %>
   "Marks2: " <%= s.getMarks2() %>
   "Marks3: " <%= s.getMarks3() %>
   <br/><br/>
   <% } %>
   
   <form action="welcome.html" method="post">
	<button type="submit">Home</button>
	</form>
</body>
</html>