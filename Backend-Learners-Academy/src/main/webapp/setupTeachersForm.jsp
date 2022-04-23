<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Teachers Form</title>
</head>
<body>
	<h1>Enter Teacher Details :</h1>
	<form action="setupTeachers" method="post">
		ID :<br>
		<input type="text" name="id">
		<br>
		First Name : <br>
		<input type="text" name="teacherFirstName">
		<br>
		Last Name : <br>
		<input type="text" name="teacherLastName">
		<br>
		Email ID : <br>
		<input type="text" name="emailId">
		<br><br>
		<input type="submit" value="submit">
	</form>
	<h4>To Return to Homepage, <a href="index.jsp">Click Here</a></h4>
</body>
</html>