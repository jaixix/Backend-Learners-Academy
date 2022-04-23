<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Students to a Class</title>
</head>
<%
	String studentId = request.getParameter("id");
%>
<body>
	<h2>Assigning Students to Classes</h2>
	<br>
	<form action="assignStudentToClass" method="post">
		Enter Student Id to be Assigned :
		<input type="text" name="studentId" value='<%=studentId%>' readonly> <br>
		<br>
		Enter Class Id to be Assigned To :
		<input type="text" name="classId">
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>