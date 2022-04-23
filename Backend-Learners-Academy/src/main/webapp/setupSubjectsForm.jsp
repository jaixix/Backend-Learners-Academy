<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Subjects Form</title>
</head>

<body>
	<h1>Enter Subject Details :</h1>
	<form action="setupSubjects" method="post">
		ID :<br>
		<input type="text" name="id">
		<br>
		Name : <br>
		<input type="text" name="subjectName">
		<br>
		Total Grade Points : <br>
		<input type="text" name="gradePoints"> <br>
		<br>
		<input type="submit" value="submit">
	</form>
	<h4>To Return to Homepage, <a href="index.jsp">Click Here</a></h4>
</body>
</html>