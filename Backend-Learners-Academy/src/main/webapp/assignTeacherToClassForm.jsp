<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Teacher to a Class</title>
</head>
<body>
	<h2>Assigning Teacher to a Class</h2>
	<br>
	<%
   		String teacherId = request.getParameter("teacherId");
		String subjectId = request.getParameter("subjectId");
	%>
	<form action="assignTeacherToClass" method="post">
		Teacher Id to be Assigned :
		<input type="text" name="teacherId" value='<%=teacherId%>' readonly> <br>
		<br>
		Teacher Id to be Assigned for Subject Id :
		<input type="text" name="subjectId" value='<%=subjectId%>' readonly> <br>
		<br>
		Enter Class Id to be Assigned To :
		<input type="text" name="classId">
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>