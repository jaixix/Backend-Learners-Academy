<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Students Form</title>
<style>
      body{
            font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align:center;
            margin-top:100px !important;
        }
		span {
		  display: inline-block;
		  min-width: 200px;
		}
</style>
</head>
<body>
	<h1>Enter Student Details :</h1><br>
	<form action="setupStudents" method="post">
		<span>Enter ID :</span>
		<input type="text" name="id">
		<br>
		<span>Enter First Name :</span>
		<input type="text" name="studentFirstName">
		<br>
		<span>Enter Last Name :</span>
		<input type="text" name="studentLastName">
		<br>
		<span>Enter Roll Number :</span>
		<input type="text" name="rollNumber">
		<br><br>
		<input type="Submit" value="Submit">
	</form>
	<br>
	<h5>To View Students Table, <a href="DisplayStudentsServlet">Click Here</a></h5>
	<h5>To Return to Homepage, <a href="index.jsp">Click Here</a></h5>
</body>
</html>