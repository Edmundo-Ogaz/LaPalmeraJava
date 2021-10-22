<%@page import="java.util.*"%>
<%@page import="unab.com.*"%>
<html>
<head>
</head>
<form action = "/prueba/jsp/ControlFilComuna.jsp">
<table border = 0>
<tr>
<td>
Comuna
</td>
<td>
<SELECT size=1 name=filcomuna> 
<OPTION VALUE="">TODOS</OPTION>
<% {
ArrayList<Comuna> arrayComuna= new ArrayList<Comuna>();
ManejadorComuna manComuna= new ManejadorComuna();
arrayComuna=manComuna.consultar();
%>

<%Iterator itComuna= arrayComuna.iterator();
while (itComuna.hasNext())
    {
Comuna comuna= (Comuna) itComuna.next();
%>
<OPTION VALUE=<%=comuna.getCodigoComuna()%>> <%=comuna.getNombreComuna()%></OPTION>
<%}}%>
</SELECT>
<!--input type=text name=codigo value = '' size = 25 maxlength = 25-->
</td>
</tr>
<!--tr>
<td>
Nombre Comuna</td>
<td>
<input type=text name=nombre value = '' size = 70 maxlength = 70></td>
</tr-->
<tr>
<td>
Ciudad</td>
<td>
<SELECT size=1 name=filciudad> 
<OPTION VALUE="">TODOS</OPTION>
<% {
ArrayList<Ciudad> arrayCiudad= new ArrayList<Ciudad>();
ManejadorCiudad manCiudad= new ManejadorCiudad();
arrayCiudad=manCiudad.consultar();
%>

<%Iterator itCiudad= arrayCiudad.iterator();
while (itCiudad.hasNext())
    {
Ciudad ciudad= (Ciudad) itCiudad.next();
%>
<OPTION VALUE=<%=ciudad.getCodigoCiudad()%>> <%=ciudad.getNombreCiudad()%></OPTION>
<%}}%>
</SELECT>
<!--input type=text name=nombre value = '' size = 70 maxlength = 70-->
</td>
</tr>
</table>
<input type=submit name=Enviar value = 'Buscar'>
<input type=submit name=Enviar value = 'Nueva Comuna'>
</form>
</body>
</html>
