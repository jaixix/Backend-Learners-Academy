<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
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
	<h1>Enter Admin Credentials :</h1><br>
	<form action="loginFunctionality" method="post">
		<span>Enter Admin Email ID :</span>
		<input type="text" name="emailId"><br><br>
		<span>Enter Admin Password :</span>
		<input type="text" name="password"><br><br>
		<input type="Submit" value="Submit">
	</form>
</body>
</html>