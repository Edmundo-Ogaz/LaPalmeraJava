<%@page import="java.util.*"%>
<%@page import="unab.com.*"%>
<html>
<head>
</head>
<form action = "/prueba/jsp/ControlFilTipoCliente.jsp">
<table border = 0>
<tr>
<td>
C�digo TipoCliente</td>
<td>
<input type=text name=filcodigo value = '' size = 25 maxlength = 25></td>
</tr>
<tr>
<td>
Nombre TipoCliente</td>
<td>
<input type=text name=filnombre value = '' size = 70 maxlength = 70></td>
</tr>
</table>
<input type=submit name=Enviar value = 'Buscar'>
<input type=submit name=Enviar value = 'Nuevo Tipo de Cliente'>
</form>
</body>
</html>
