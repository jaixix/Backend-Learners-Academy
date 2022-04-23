<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Students Form</title>
</head>
<body>
	<h1>Enter Student Details :</h1>
	<form action="setupStudents" method="post">
		ID :<br>
		<input type="text" name="id">
		<br>
		First Name : <br>
		<input type="text" name="studentFirstName">
		<br>
		Last Name : <br>
		<input type="text" name="studentLastName">
		<br>
		Roll Number :<br>
		<input type="text" name="rollNumber">
		<br><br>
		<input type="submit" value="submit">
	</form>
	<h4>To Return to Homepage, <a href="index.jsp">Click Here</a></h4>
</body>
</html>