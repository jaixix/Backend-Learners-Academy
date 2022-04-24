<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Students to a Class</title>
<style>
      body{
            font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align:center;
            margin-top:140px !important;
        }
		span {
		  display: inline-block;
		  min-width: 310px;
		}
</style>
</head>
<%
	String studentId = request.getParameter("id");
%>
<body>
	<h2>Assigning Students to Classes</h2>
	<br>
	<form action="assignStudentToClass" method="post">
		<span>Enter Student Id to be Assigned :</span>
		<input type="text" name="studentId" value='<%=studentId%>' readonly> <br>
		<br>
		<span>Enter Class Id to be Assigned To :</span>
		<input type="text" name="classId">
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>