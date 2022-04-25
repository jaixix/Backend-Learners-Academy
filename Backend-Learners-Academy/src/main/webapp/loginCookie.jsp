<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loginCookieSetter</title>
</head>
<body>
	<%
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
	%>
	
	<%response.sendRedirect("loginFunctionality");%>
</body>
</html>