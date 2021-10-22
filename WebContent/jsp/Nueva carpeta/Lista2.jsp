<%@ page import="java.util.*" %>
<%@ page import="unab.com.*" %>
<jsp:useBean id="manSec" scope="application" class="ManejadorSeccion"/>
<form action="/unabv/servlet/GrabaAsigna">
Listado de Reportes Recibidos
<br>
<table  WIDTH="100%"  border = 1 CELLPADDING="3">
<th>

</th>
<th>
Asignatura
</th>
<th>
seccion
</th>

<%Vector vecRep;
String horarioBuscar = request.getParameter("profesor");
manSec.setProNombre(horarioBuscar);
vecRep = manSec.listar();%>
<%Enumeration enumRep = vecRep.elements();
  int i = 1;
  while (enumRep.hasMoreElements())
    {
     Seccion seccion = (Seccion) enumRep.nextElement();%>
     <tr>
     <td>
     <input type = hidden value = <%=seccion.getSecCodigo()%> name = fila<%=i%>>
  	<INPUT type = radio name = eleccion<%=i%> value = <%=i%> > 

     </td>
     <td>
     <%=seccion.getAsiNombre()%>
     <input type=text name=asignatura value=<%=seccion.getAsiNombre()%>>
     </td>
     
     <td>
     <%=seccion.getSecCodigo()%>
     <input type=text name=seccion value=<%=seccion.getSecCodigo()%>>
     </td>
    
     /tr>
   <% i++; }%>
</table>
<input type = hidden value = <%=i-1%> name = ultimafila>
<input type = submit name = aplica value = Detalle>
</form>
<br> 