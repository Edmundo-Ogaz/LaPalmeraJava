<%@page import="java.util.*"%>
<%@page import="unab.com.*"%>
<html>
<head>
</head>
<form action = "/prueba/jsp/ControlFilRegion.jsp">
<table border = 0>
<tr>
<td>
Región</td>
<td>
<SELECT size=1 name=filregion> 
<OPTION VALUE="">TODOS</OPTION>
<% {
ArrayList<Region> arrayRegion= new ArrayList<Region>();
ManejadorRegion manRegion= new ManejadorRegion();
arrayRegion=manRegion.consultar();
%>

<%Iterator itRegion= arrayRegion.iterator();
while (itRegion.hasNext())
    {
Region region= (Region) itRegion.next();
%>
<OPTION VALUE=<%=region.getCodigoRegion()%>> <%=region.getNombreRegion()%></OPTION>
<%}}%>
</SELECT>
</td>
</tr>
</table>
<input type=submit name=Enviar value = 'Buscar'>
<input type=submit name=Enviar value = 'Nueva Región'>
</form>
</body>
</html>
