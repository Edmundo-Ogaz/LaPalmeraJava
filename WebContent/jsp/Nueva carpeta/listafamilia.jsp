<!--jsp:useBean id="mansubfamilia" scope="page" class="ManejadorSubfamilia"/-->
<%@ page import="java.util.*" %>
<%@page import="unab.com.*"%>
<%ManejadorFamilia manfamilia = new ManejadorFamilia();%>

<table  WIDTH="100%"  border = 1 CELLPADDING="3">
<th>Código Familia</th><th>Nombre Familia</th>
<%Vector vecRep;
vecRep = manfamilia.consultar();%>
<%Enumeration enumRep = vecRep.elements();
  while (enumRep.hasMoreElements())
    {
     Familia familia = (Familia) enumRep.nextElement();%>
     <tr>
     <td>
     <%=familia.getCodigoFamilia()%>
     </td>
     <td>
     <%=familia.getNombreFamilia()%>
     </td>
     </tr>
   <%}%>
</table>
<br> 

