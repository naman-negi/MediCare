
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link href="CSS1/UserLoginSheet.css" rel="stylesheet" type="text/css">
</head>

<div id="main">
	<h1>User Login</h1>
	<div id="login">
		<form action="Existinguser" method="post">
			<label>UserName :</label> <input id="name" name="username"
				placeholder="username" type="text"> <label>Password
				:</label> <input id="password" name="password" placeholder="**********"
				type="password"> <input name="submit" type="submit"
				value=" Login ">

		</form>
		<a href="SignupUser.jsp">Or To create an account click here</a>
	</div>
</div>

</html>
