<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Class Table</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Subject Name</th>
			<th>Grade Points</th>
		</tr>
		
		<tr>
			<td>rs.getString(2)</td>
			<td>rs.getInt(3)</td>
		</tr>
	</table>
</body>
</html>