<%@ page import="java.util.*" %>
<%@page import="unab.com.*"%>
<%ManejadorOtraCaracteristica manotraCaracteristica = new ManejadorOtraCaracteristica();%>

<table  WIDTH="100%"  border = 1 CELLPADDING="3">
<th>Código Familia</th><th>Nombre Familia</th>
<%Vector vecRep;
vecRep = manotraCaracteristica.consultar();%>
<%=vecRep.size()%>
<%Enumeration enumRep = vecRep.elements();

  while (enumRep.hasMoreElements())
    {
     OtraCaracteristica otraCaracteristica = (OtraCaracteristica) enumRep.nextElement();%>
     <tr>
     <td>
     <%=otraCaracteristica.getCodigoOtraCaracteristica()%>
     </td>
     <td>
     <%=otraCaracteristica.getNombreOtraCaracteristica()%>
     </td>
     </tr>
   <%}%>
</table>
<br> 

