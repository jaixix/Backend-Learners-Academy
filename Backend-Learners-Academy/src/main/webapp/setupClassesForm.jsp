<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Classes Form</title>
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
	<h1>Enter Class Details :</h1><br>
	<form action="setupClasses" method="post">
		<span>Enter ID :</span>
		<input type="text" name="id">
		<br>
		<span>Enter Class Name (Grade) :</span>
		<input type="text" name="className">
		<br>
		<span>Enter Section :</span>
		<input type="text" name="sectionName">
		<br><br>
		<input type="Submit" value="Submit">
	</form>
	<br>
	<h5>To View Classes Table, <a href="DisplayClassesServlet">Click Here</a></h5>
	<h5>To Return to Homepage, <a href="index.jsp">Click Here</a></h5>
</body>
</html>