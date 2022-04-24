<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Subject To Teacher</title>
<style>
      body{
            font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align:center;
            margin-top:140px !important;
        }
		span {
		  display: inline-block;
		  min-width: 250px;
		}
</style>
</head>
<body>
	<h2>Assigning Subject To Teacher</h2>
	<br>
	<form action="assignSubjectToTeacher" method="post">
		<span>Enter Subject Id to be Assigned :</span>
		<input type="text" name="subjectId"> <br>
		<br>
		<span>Enter Teacher Id to be Assigned To:</span>
		<input type="text" name="teacherId"> <br>
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>