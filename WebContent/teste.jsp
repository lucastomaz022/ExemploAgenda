<!-- Diretiva @ -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Primeiro JSP</title>
	</head>

	<body>
		<h2>Olá, JSP!!!</h2>
		
		<!-- Scriptlet -->
		<% 
		int a = 10;
		int b = a * 2;
		int c = b + 5;
		
		out.print(c);
		%>
		
		<!-- Expressão -->
		<%= c %> <br />
		
		<%= "Olá, expressão!!!" %>
		
	</body>
</html>









