<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Teachers Form</title>
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
	<h1>Enter Teacher Details </h1><br>
	<form action="setupTeachers" method="post">
		<span>Enter ID :</span>
		<input type="text" name="id">
		<br>
		<span>Enter First Name :</span>
		<input type="text" name="teacherFirstName">
		<br>
		<span>Enter Last Name :</span>
		<input type="text" name="teacherLastName">
		<br>
		<span>Enter Email ID :</span>
		<input type="text" name="emailId">
		<br><br>
		<input type="Submit" value="Submit">
	</form>
	<br>
	<h5>To View Teachers Table, <a href="DisplayTeachersServlet">Click Here</a></h5>
	<h5>To Return to Homepage, <a href="index.jsp">Click Here</a></h5>
</body>
</html>