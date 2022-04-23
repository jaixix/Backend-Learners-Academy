<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Classes Form</title>
</head>
<body>
	<h1>Enter Class Details :</h1>
	<form action="setupClasses" method="post">
		ID :<br>
		<input type="text" name="id">
		<br>
		Class Name (Grade) : <br>
		<input type="text" name="className">
		<br>
		Section :<br>
		<input type="text" name="sectionName">
		<br><br>
		<input type="submit" value="submit">
	</form>
	<h4>To Return to Homepage, <a href="index.jsp">Click Here</a></h4>
</body>
</html>