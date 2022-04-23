<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Subject To Teacher</title>
</head>
<body>
	<h2>Assigning Subject To Teacher</h2>
	<br>
	<form action="assignSubjectToTeacher" method="post">
		Enter Subject Id to be Assigned :
		<input type="text" name="subjectId"> <br>
		<br>
		Enter Teacher Id to be Assigned To:
		<input type="text" name="teacherId"> <br>
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>