<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Teacher to a Class</title>
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
<body>
	<h2>Assigning Teacher to a Class</h2>
	<br>
	<%
   		String teacherId = request.getParameter("teacherId");
		String subjectId = request.getParameter("subjectId");
	%>
	<form action="assignTeacherToClass" method="post">
		<span>Teacher Id to be Assigned :</span>
		<input type="text" name="teacherId" value='<%=teacherId%>' readonly> <br>
		<br>
		<span>Teacher Id to be Assigned for Subject Id :</span>
		<input type="text" name="subjectId" value='<%=subjectId%>' readonly> <br>
		<br>
		<span>Enter Class Id to be Assigned To :</span>
		<input type="text" name="classId">
		<br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>