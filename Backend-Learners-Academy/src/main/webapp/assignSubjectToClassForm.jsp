<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	String subjectId = request.getParameter("subjectId");
	String classId = request.getParameter("classId");
%>

<body>
	<h2>Assigning Subjects to Classes</h2>
	<br>
	<form action="assignSubjectToClass" method="post">
		Subject Id to be Assigned :
		<input type="text" name="subjectId" value='<%=subjectId%>' readonly> <br>
		<br>
		Enter Class Id to be Assigned To :
		<input type="text" name="classId" value='<%=classId%>' readonly>
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>