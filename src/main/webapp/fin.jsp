<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fin</title>
</head>
<body>
	<h1>País: ${nom}</h1>
	<br>
	<br>
	<h1>Idioma combobox:${idio}</h1>
	<br>
	<br>
	<h1>Idioma que no está en el combobox:${insertidio}</h1>


	 <!-- No me funcion así y he puesto el tag del menor
	 y el porcentaje pero si lo dejo no me deja comentarlo

	 if("idioma" == ""){
			out.println("<h1>Idioma:${idio}</h1>");
		}else
			out.println("<h1>Idioma:${insertidio}</h1>");
	-->


	<input type="button" onclick="window.location.href='insertar.jsp'"  value="Volver">
	<br>
</body>
</html>