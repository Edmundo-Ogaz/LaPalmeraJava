<%@ page import="java.util.*" %>
<%@ page import="unab.com.*" %>
<jsp:useBean id="manSec" scope="application" class="ManejadorSeccion"/>
<form action="/unabv/servlet/GrabaAsigna">
Listado de Reportes Recibidos
<br>
<table  WIDTH="100%"  border = 1 CELLPADDING="3">
<th>
Código Sección
</th>
<th>
Asignatura
</th>
<th>
Profesor
</th>
<th>
Estado
</th>
<%Vector vecRep;
String horarioBuscar = request.getParameter("dia")+request.getParameter("bloque");
manSec.setSecHorario(horarioBuscar);
vecRep = manSec.listar();%>
<%Enumeration enumRep = vecRep.elements();
  int i = 1;
  while (enumRep.hasMoreElements())
    {
     Seccion seccion = (Seccion) enumRep.nextElement();%>
     <tr>
     <td>
     <input type = hidden value = <%=seccion.getSecCodigo()%> name = fila<%=i%>>
     <%=seccion.getSecCodigo()%>
     </td>
     <td>
     <%=seccion.getAsiNombre()%>
     </td>
     <td>
     <%=seccion.getProNombre()%>
     </td>
     <td>
     <SELECT size="1" name="estado<%=i%>">
     <OPTION VALUE="0"> Sin Informaciòn </OPTION>
     <OPTION VALUE="1"> Asiste </OPTION>
     <OPTION VALUE="2"> No Asiste con aviso </OPTION>
     <OPTION VALUE="3"> No Asiste sin aviso </OPTION>
     <OPTION VALUE="4"> Asiste con atraso </OPTION>
     </SELECT>
     </td>
     /tr>
   <% i++; }%>
</table>
<input type = hidden value = <%=i-1%> name = ultimafila>
<input type = submit name = aplica value = Grabar>
</form>
<br> 

