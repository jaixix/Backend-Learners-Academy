<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page - LA</title>
<style>
      body{
            font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
      .header{
            font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background:url("https://www.xmple.com/wallpaper/blue-gradient-white-linear-1920x1080-c2-87cefa-ffffff-a-105-f-14.svg");
            background-repeat: no-repeat;
            background-position:center;
            background-size: cover;
        }
</style>
</head>
<body>
	<div class="header">
	<hr>
	<h1 align="center">Welcome to Learner's Academy - Backend</h1>
	<h2 align="center">Action Menu</h2>
	<br>
	<hr>
	</div>
	<br>
	<table border="1" align="center">
		<tr>
			<th>Action</th>
			<th>Description</th>
			<th>Link To Proceed</th>
		</tr>
		<tr>
			<td>Setup Master List for 'Subjects'</td>
			<td>In order to populate Subjects Table.</td>
			<td><a href="setupSubjectsForm.jsp">Setup Subjects Master</a></td>
		</tr>
		<tr>
			<td>Setup Master List for 'Classes'</td>
			<td>In order to populate Classes Table.</td>
			<td><a href="setupClassesForm.jsp">Setup Classes Master</a></td>
		</tr>
		<tr>
			<td>Setup Master List for 'Teachers'</td>
			<td>In order to populate Teachers Table.</td>
			<td><a href="setupTeachersForm.jsp">Setup Teachers Master</a></td>
		</tr>
		<tr>
			<td>Setup Master List for 'Students'</td>
			<td>In order to populate Students Table.</td>
			<td><a href="setupStudentsForm.jsp">Setup Masters</a></td>
		</tr>
		<tr>
			<td>
				Assign a 'Subject' to a 'Teacher'<br>
				(Also Assigns Teacher To Class)
			</td>
			<td>In order to assign a Subject to a Teacher
				<br>and in continuation assign them to a Class. </td>
			<td><a href="assignSubjectToTeacherForm.jsp">Assign</a></td>
		</tr>
		<!--<tr>
			<td>Assign a 'Subject' to a 'Class'</td>
			<td>In order to assign a subject to a class.</td>
			<td><a href="assignSubjectToClassForm.jsp">Assign</a></td>
		</tr>-->
		<!--<tr>
			<td>Assign a 'Teacher' to a 'Class'</td>
			<td>In order to assign a teacher to a class.</td>
			<td><a href="assignTeacherToClassForm.jsp">Assign</a></td>
		</tr>-->
		<!--<tr>
			<td>Assign a 'Student' to a 'Class'</td>
			<td>In order to assign a subject to a teacher.</td>
			<td><a href="assignStudentToClassForm.jsp">Assign</a></td>
		</tr>-->
		<tr>
			<td>Erase Data from 'Subjects' Table</td>
			<td>In order to clear records of a specific table.</td>
			<td><a href="deleteSubjects">Delete All Records</a></td>
		</tr>
		<tr>
			<td>Erase Data from 'Teachers' Table</td>
			<td>In order to clear records of a specific table.</td>
			<td><a href="deleteTeachers">Delete All Records</a></td>
		</tr>
		<tr>
			<td>Erase Data from 'Classes' Table</td>
			<td>In order to clear records of a specific table.</td>
			<td><a href="deleteClasses">Delete All Records</a></td>
		</tr>
		<tr>
			<td>Erase Data from 'Students' Table</td>
			<td>In order to clear records of a specific table.</td>
			<td><a href="deleteStudents">Delete All Records</a></td>
		</tr>
		<tr>
			<td>Change Password</td>
			<td>In order to change your current password.</td>
			<td><a href="changePasswordForm.html">Change Password</a></td>
		</tr>
	</table>
</body>
</html>