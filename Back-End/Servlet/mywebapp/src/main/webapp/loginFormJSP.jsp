<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page session="false" %>

<%String msg =(String) request.getAttribute("msg"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% if (msg != null && !msg.isEmpty()) {%>
	<%= msg %>
	<%} %>
	<fieldset>
	<legend>Employee Login</legend>
	<form action="./findlogin" method="post">
	<table>
		<tr>
			<td>Id</td>
			<td>:</td>
			<td> <input type ="number" name = "empId" required=> </td>
		</tr>
		
		<tr>
			<td>Password</td>
			<td>:</td>
			<td> <input type ="password" name = "password" required=> </td>
		</tr>
		
		<tr>
			<td colspan="3" align="center">
			<input type="submit" value="Login">
			</td>
		</tr>
		
	</table>
	</form>
</fieldset>
<h3>Its JSP</h3>
</body>
</html>