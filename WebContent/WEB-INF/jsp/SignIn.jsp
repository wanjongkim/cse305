<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sign In</title>
</head>
<body>
	<form action="login" method="POST">
		Username:<br>
		<input type="text" name="username"><br>
		Password:<br>
		<input type="text" name="password"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>