<%@page import="java.util.*"%>
<%@page import="unab.com.*"%>
<%
String filregion = request.getParameter("filregion");
//String nombre = request.getParameter("nombre");
%>
<html>
<head>
<script language="JavaScript">
<!--
function validar(formulario) {
var j
var aux = 0;    
		
	if (typeof(document.formulario.seleccion.length) != "undefined"){
		for (j=0;j<document.formulario.seleccion.length;j++){
       		if (document.formulario.seleccion[j].checked){
	   	  		aux = 1;	
          		break;
    		}
		}
	}else{
		if (document.formulario.seleccion.checked){
		    aux = 1;
		}
	}
	if (aux == 0 ){ 
    	alert("Seleccione un Registro.");
    	return (false);
  	}
	
	var entrar = confirm("¿Desea continuar?")
    if ( !entrar )
  	  return (false);
    else
      return (true);
    
}
//-->
</script>
</head>
<body>
<form name = formulario action = "/prueba/jsp/ControlListaRegion.jsp" onSubmit="return validar(this)" target="_self">
<input type="hidden" name="filregion" value="<%=filregion%>"/>
<table border="1">
<tr>
<th>
Selec
</th>
<th>
Código
</th>
<th>
Nombre
</th>
</tr>	
<%
int i = 1;
ArrayList<Region> arrayRegion= new ArrayList<Region>();
ManejadorRegion manRegion= new ManejadorRegion();

manRegion.setCodigoRegion(filregion);
//manRegion.setNombreRegion(nombre);

arrayRegion= manRegion.consultar();
Iterator itRegion= arrayRegion.iterator();
while (itRegion.hasNext())
 {
Region region= (Region) itRegion.next();
 %>
<tr>
<td>
<input type = radio name = seleccion value = <%=region.getCodigoRegion()%>>
</td>
<td>
&nbsp;
<%=region.getCodigoRegion()%>
</td>
<td width =150  align="right">
&nbsp;
<%=region.getNombreRegion()%>
</td>
</tr>
<%i++;}%>
</table>
<input type="hidden" name="ultimafila" value="<%=i-1%>"/>
<!--input type=submit name=Enviar value = 'Nueva Comuna'-->
<button type="button" onClick="window.open('/prueba/jsp/UsoSistema.jsp?destino=NuevaRegion.jsp&titulo=Nueva Región&filregion=<%=filregion%>','_self')">Nueva Región</button>
<input type=submit name=Enviar value = 'Modificar'>
<input type=submit name=Enviar value = 'Eliminar'>
<button type="button" onClick="window.open('/prueba/jsp/UsoSistema.jsp?destino=FilRegion.jsp&titulo=Filtrado Región','_self')">Volver</button>
<!--input type=submit name=Enviar value = 'Volver'-->
</form>
</body>
</html>

