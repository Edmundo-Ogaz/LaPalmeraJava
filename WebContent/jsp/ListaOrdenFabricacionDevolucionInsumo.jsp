<%@page import="java.util.*"%>
<%@page import="unab.com.*"%>
<%
String filordenfabricacion = request.getParameter("filordenfabricacion");
//String filfuncionario = request.getParameter("filfuncionario");
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
  	}else{
  		return (true);   
	}
}
//-->
</script>
</head>
<body>
<form name="formulario" action = "/prueba/jsp/ControlListaOrdenFabricacionDevolucionInsumo.jsp" onSubmit="return validar(this)" target="_self">
<input type="hidden" name="filordenfabricacion" value="<%=filordenfabricacion%>"/>
<!--input type="hidden" name="filfuncionario" value="<%--=filfuncionario--%>"/-->

<table border="1">
<tr>
<th>
Selec
</th>
<th>
Ord.Fab.
</th>
<th>
N&uacute;mero Pedido
</th>
<th>
Fecha Entrega
</th>
<th>
Producto
</th>
<th>
L&iacute;nea Producción
</th>
<th>
Cantidad Programada
</th>
<th>
Cantidad Fabricada
</th>
<th>
Saldo por Fabricar
</th>
<th>
Estado Ord.Fab.
</th>
</tr>	
<%
int i = 1;
EntregaInsumo entregaInsumo = new EntregaInsumo(); 
ArrayList<ProgramaProduccion> arrayProgramaProduccion = new ArrayList<ProgramaProduccion>();
ManejadorProgramaProduccion manProgramaProduccion = new ManejadorProgramaProduccion();

//manProgramaProduccion.setEstadoOrdenFabricacion("A");
manProgramaProduccion.setCodigoOrdenFabricacion(filordenfabricacion);

arrayProgramaProduccion = manProgramaProduccion.listarPorFecha();
Iterator itProgramaProduccion = arrayProgramaProduccion.iterator();
while (itProgramaProduccion.hasNext())
 {
ProgramaProduccion programaProduccion= (ProgramaProduccion) itProgramaProduccion.next();

 entregaInsumo.setCodigoOrdenFabricacion(programaProduccion.getCodigoOrdenFabricacion());
 if (entregaInsumo.buscar())
 {
 %>
<tr>
<td>
<input type = radio name = seleccion value = <%=programaProduccion.getCodigoOrdenFabricacion()%>>
</td>
<td>
&nbsp;
<%=programaProduccion.getCodigoOrdenFabricacion()%>
</td>
<td>
&nbsp;
<%=programaProduccion.getNumeroPedido()%>
</td>
<td>
&nbsp;
<%=programaProduccion.getFechaPedido()%>
</td>
<td>
&nbsp;
<%
Producto producto = new Producto();
producto.setCodigoProducto(programaProduccion.getCodigoProducto());
if (producto.buscar())
{
  out.print(producto.getNombreProducto());
}
%> 
<%--=programaProduccion.getCodigoProducto()--%>
</td>
<td>
&nbsp;
<%
LineaProduccion lineaProduccion = new LineaProduccion();
lineaProduccion.setCodigoLineaProduccion(programaProduccion.getCodigoLineaProduccion());
if (lineaProduccion.buscar())
{
  out.print(lineaProduccion.getNombreLineaProduccion());
}
%> 
<%--=programaProduccion.getCodigoLineaProduccion()--%>
</td>
<!--td>
&nbsp;
<%--=programaProduccion.getRutFuncionario()--%>
</td-->
<td>
&nbsp;
<%=programaProduccion.getCantidadProgramada()%>
</td>
<td>
&nbsp;
<%=programaProduccion.getCantidadFabricada()%>
</td>
<td>
&nbsp;
<%=programaProduccion.getSaldoPorFabricar()%>
</td>
<td>
&nbsp;
<%=programaProduccion.getEstadoOrdenFabricacion()%>
</td>
</tr>
<%i++;}}%>
</table>
<input type="hidden" name="ultimafila" value="<%=i-1%>"/>
<!--input type=submit name=Enviar value = 'Nueva Comuna'-->
<input type=submit name=Enviar value = 'Devolución Insumos'>
<button type="button" onClick="window.open('/prueba/jsp/UsoSistema.jsp?destino=FilDevolucionInsumo.jsp&titulo=Filtrado Devolución de Insumos','_self')">Volver</button>
<!--input type=submit name=Enviar value = 'Volver'-->
</form>
</body>
</html>

