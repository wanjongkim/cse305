<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Moon Travel: Airline Tickets</title>
</head>
<body>
	<jsp:useBean id="account" class="entities.Account" scope="session" />
	<c:if test = "${account.loggedIn == false}">
		<a href="signin">Account</a>
		<p>Register</p>
	</c:if>
	<c:if test = "${account.loggedIn == true}">
		<p>Welcome ${account.username}!</p>
	</c:if>
	<form>
		Origin:<br>
		<input type="text" name="origin"><br>
		Destination:<br>
		<input type="text" name="destination"><br>
	</form>
</body>
</html>