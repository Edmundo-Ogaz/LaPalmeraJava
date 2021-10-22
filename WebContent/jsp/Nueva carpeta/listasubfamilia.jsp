<%@page import="java.util.*"%>
<%@page import="unab.com.ManejadorSubfamilia"%>
<%@page import="unab.com.Subfamilia"%>
<%ManejadorSubfamilia manSubfamilia = new ManejadorSubfamilia();%>
<table  WIDTH="100%"  border = 1 CELLPADDING="3">
<th>Código Familia</th><th>Nombre Familia</th>
<%Vector vecSub;
vecSub = manSubfamilia.consultar();%>
<%Enumeration enumSub = vecSub.elements();
while (enumSub.hasMoreElements())
{
Subfamilia subFamilia = (Subfamilia) enumSub.nextElement();
%>

     <tr>
     <td>
<%=subFamilia.getCodigoSubfamilia()%>
     </td>
     <td>
<%=subFamilia.getNombreSubfamilia()%>
     </td>
     </tr>
<%}%>
</table>
<br> 
