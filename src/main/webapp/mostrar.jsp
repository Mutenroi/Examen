<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,servlet.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostrar</title>
</head>
<body>

<form method="post" action="Servlet2">
		<input type="submit"  value="Mostrar">
		<input type="button" onclick="window.location.href='insertar.jsp'"  value="Volver">
</form>
<br>
<br>
<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Idioma</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pais1" items="${listAllPaises}">
				<tr>
					<td><c:out value="${pais1.nombre}"/> </td>
					<td><c:out value="${pais1.idioma}"/> </td>
					<td><a name="user" href="Servlet3?idioma=${pais1.idioma}">Borrar todos los paises de este idioma</a></td>
		    	</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>