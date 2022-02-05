<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>User SignUp Page</title>
<link href="CSS1/SignUpUser.css" rel="stylesheet" type="text/css">
</head>

<div id="main">
<h1>User SignUp</h1>
<div id="login">
<form action="Passvalidate" method="post">


<label>UserName :</label>
<input id="name" name="username" placeholder="username" type="text">

<label>Password :</label>
<input id="password" name="password" placeholder="**********" type="password">

<label>Please Confirm Password Again:</label>
<input id="password" name="password2" placeholder="**********" type="password">

<input name="submit" type="submit" value=" Login ">

</form>
</div>
</div>

</html>