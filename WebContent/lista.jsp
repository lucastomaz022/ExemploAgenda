<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Contatos</title>
	</head>

	<body>
		
		<h2>Contatos Registrados</h2>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>E-mail</th>
				<th>Telefone</th>
			</tr>
			
			<!-- for(int i = 0; i < 10; i++) 
			     for(Usuario usuario : usuarios) -->
			
			<c:forEach var="usuario" items="${ sessionScope.contatos }">
				<tr>
					<td> ${ usuario.id } </td>
					<td> ${ usuario.nome } </td>
					<td> ${ usuario.endereco } </td>
					<td> ${ usuario.email } </td>
					<td> ${ usuario.telefone } </td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>



