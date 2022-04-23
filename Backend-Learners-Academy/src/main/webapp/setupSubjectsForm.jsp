<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setup Subjects Form</title>
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
	<h1>Enter Subject Details</h1><br><br>
	<form action="setupSubjects" method="post">
		<span>Enter ID :</span>  
		<input type="text" name="id">
		<br>
		<span>Enter Subject Name :</span>  
		<input type="text" name="subjectName">
		<br>
		<span>Enter Subject Grade Points :</span>  
		<input type="text" name="gradePoints"> <br>
		<br>
		<input type="Submit" value="Submit">
	</form>
	<br><br>
	<h5>To View Subjects Table, <a href="DisplaySubjectsServlet">Click Here</a></h5>
	<h5>To Return to Homepage, <a href="index.jsp">Click Here</a></h5>
</body>
</html>