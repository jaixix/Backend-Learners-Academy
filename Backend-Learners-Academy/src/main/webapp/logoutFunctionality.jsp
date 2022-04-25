<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Functionality</title>
</head>
<body>
	<%
		String emailId = "default";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if (cookie.getName().equals("emailId")) {
					cookie.setMaxAge(0);
	                response.addCookie(cookie);
				}
			}
		}
		response.sendRedirect("LoginForm.jsp");
%>
</body>
</html>