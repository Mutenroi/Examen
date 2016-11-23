<%@page import="servlet.Repositorio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.io.*,java.util.*,servlet.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insertar</title>
</head>
<body>
<form method="post" action="Servlet1">
	<table width="40%" align="center">
		<tr>
			<td colspan="2" align="center"><h2>Dar de alta el país</h2><hr></td>
		</tr>
		<tr>
			<td><p>Nombre:</p></td>
			<td><input type="text" id="name" name="name" size="30"></td>
		</tr>
		<tr>
			<td><p>Idioma:</p></td>
			<td>
				<select name="Idioma" id="Idioma">
					<%
						Repositorio servicio = new Repositorio();
						List<Idiomas> verIdiomas = servicio.listarIdiomas();
						for (int i=0;i<verIdiomas.size();i++){
						   out.println("<option value ='"+verIdiomas.get(i).getIdiomas()+"'>"+verIdiomas.get(i).getIdiomas()+"</option>");
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td><p>Insertar idioma:</p></td>
			<td><input type="text" id="insertidioma" name="insertidioma" size="30"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="Enviar"></td>
		</tr>
		<tr>
			<td colspan="2" align="left"><input type="button" onclick="window.location.href='mostrar.jsp'"  value="Mostrar"></td>
		</tr>
	</table>
</form>
</body>
</html>