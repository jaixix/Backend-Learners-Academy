<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Subject to a Class</title>
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
	String subjectId = request.getParameter("subjectId");
	String classId = request.getParameter("classId");
%>

<body>
	<h2>Assigning Subjects to Classes</h2>
	<br>
	<form action="assignSubjectToClass" method="post">
		<span>Subject Id to be Assigned :</span>
		<input type="text" name="subjectId" value='<%=subjectId%>' readonly> <br>
		<br>
		<span>Enter Class Id to be Assigned To :</span>
		<input type="text" name="classId" value='<%=classId%>' readonly>
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>