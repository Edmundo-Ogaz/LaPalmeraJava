<%@ page import="java.util.*" %>
<%@ page import="unab.com.*" %>

<jsp:useBean id="cabezaPedido" class="CabezaPedido" scope="session"/>
<jsp:useBean id="despachoPedido" class="DespachoPedido" scope="session"/>
<jsp:useBean id="confirmacionPedido" class="ConfirmacionPedido" scope="session"/>
<!--jsp:useBean id="cliente" class="Cliente" scope="session"/-->

<%
String cantidadinsumo = "";
String numeropedido = request.getParameter("seleccion");
String nombreapellido = "";
String fecha = "";
String hora = "";
String preciototal = "";
String confirmacion = "";
String comentario = "";

cabezaPedido.setNumeroPedido(numeropedido);
if (cabezaPedido.buscar()){
nombreapellido = cabezaPedido.getNombreCliente();
fecha = cabezaPedido.getFechaPedido();
hora = cabezaPedido.getHoraPedido();
preciototal = cabezaPedido.getPrecioTotalPedido();
confirmacion = cabezaPedido.getConfirmacionPedido();
comentario = cabezaPedido.getObservacionPedido();
}

//String nombredespacho = "";
String direcciondespacho = "";
//String comunadespacho = "";
//String telefonodespacho = "";
String fechaentrega = "";
String horaentrega = "";

despachoPedido.setNumeroPedido(numeropedido);
if (despachoPedido.buscar()){
//nombredespacho = despachoPedido.getNombreDespacho();
direcciondespacho = despachoPedido.getDireccionDespacho();
//comunadespacho = despachoPedido.getCodigoComuna();
//telefonodespacho = despachoPedido.getTelefonoDespacho();
fechaentrega = despachoPedido.getFechaEntregaDespacho();
horaentrega = despachoPedido.getHoraEntregaDespacho();
}

String nombre ="";
String apellido ="";
String direccion ="";
//String comuna = "";
String fechanacimiento ="";
String telefono ="";
String email ="";
//String paginaweb ="";
//String telefonoconfirmacion = "";
//String fechaconfirmacion = "";
//String horaconfirmacion = "";

confirmacionPedido.setNumeroPedido(numeropedido);
if (confirmacionPedido.buscar()){
nombre = confirmacionPedido.getNombreCliente();
apellido = confirmacionPedido.getApellidoCliente();
direccion = confirmacionPedido.getDireccionCliente();
//comuna = confirmacionPedido.getCodigoComuna();
fechanacimiento = confirmacionPedido.getFechaNacimientoCliente();
telefono = confirmacionPedido.getTelefonoCliente();
email = confirmacionPedido.getEmailCliente();
//paginaweb = confirmacionPedido.getPaginaWebCliente();
//telefonoconfirmacion = confirmacionPedido.getTelefonoConfirmacion();
//fechaconfirmacion = confirmacionPedido.getFechaConfirmacion();
//horaconfirmacion = confirmacionPedido.getHoraConfirmacion();
}

//String tipocliente ="";
//String observacion ="";

//cliente.setRutCliente(rut);
//if (cliente.buscar()){
//tipocliente = cliente.getCodigoTipoCliente();
//observacion = cliente.getObservacionCliente();
//}
%>
<html>
<head>
<title>Pasteleria La Palmera</title>
<!-Hoja de estilos del calendario -->
<link rel="stylesheet" type="text/css" media="all" href="calendar-system.css" title="win2k-cold-1" />
<!-- librería principal del calendario -->
<script type="text/javascript" src="calendar.js"></script>
<!-- librería para cargar el lenguaje deseado -->
<script type="text/javascript" src="lang/calendar-es.js"></script>
<!-- librería que declara la función Calendar.setup, que ayuda a generar un calendario en unas pocas líneas de código -->
<script type="text/javascript" src="calendar-setup.js"></script>
<!-- script que define y configura el calendario-->
<script>
<!--
function ValidaEntrada() {

if (document.pedido.rut.value.length < 1) {
    alert("Escriba el Rut.");
    document.pedido.rut.focus();
    return (false);
  }
  
  if (document.pedido.rut.value.length < 9) {
    alert("Rut Invalido.");
    document.pedido.rut.focus();
    return (false);
  }
  
  var rut=document.pedido.rut.value;suma=0;mul=2;i=0;
  if (rut=="") return (false);
  for (i=rut.length-3;i>=0;i--){
  suma=suma+parseInt(rut.charAt(i)) * mul;
  mul= mul==7 ? 2 : mul+1;
  }

  var dvr = ''+(11 - suma % 11);

  if (dvr=='10') 
    dvr = 'K'; 
  else if (dvr=='11') 
    dvr = '0';
  if (rut.charAt(rut.length-2)!="-"||rut.charAt(rut.length-1)!=dvr) 
    {alert("Rut Invalido");
    //document.pedido.rut.value="";
    document.pedido.rut.focus();
    return (false);
  }
  
  if (document.pedido.nombre.value.length < 1) {
    alert("Escriba el Nombre del Cliente.");
    document.pedido.nombre.focus();
    return (false);
  }
  
    if (document.pedido.direccion.value.length < 1) {
    alert("Escriba la Dirección del Cliente.");
    document.pedido.direccion.focus();
    return (false);
  }
  
    if (document.pedido.comuna.value == -1) {
    alert("Escriba la Comuna del Cliente.");
    document.pedido.comuna.focus();
    return (false);
  }
  
    if (document.pedido.telefono.value.length < 1) {
    alert("Escriba el Teléfono del Cliente.");
    document.pedido.telefono.focus();
    return (false);
  }
  
   if (document.pedido.nombredespacho.value.length < 1) {
    alert("Escriba el nombre a quien se entrega el Producto.");
    document.pedido.nombredespacho.focus();
    return (false);
  }
  
    if (document.pedido.direcciondespacho.value.length < 1) {
    alert("Escriba la Dirección del Despacho.");
    document.pedido.direcciondespacho.focus();
    return (false);
  }
  
    if (document.pedido.comunadespacho.value == -1) {
    alert("Escriba la Comuna del Despacho.");
    document.pedido.comunadespacho.focus();
    return (false);
  }
  
   /*if (document.pedido.fechaentrega.value.length < 1) {
    alert("Escriba la fecha de Entrega.");
    document.pedido.fechaentrega.focus();
    return (false);
  }*/
  
  /*if (document.pedido.horaentrega.value.length < 1) {
    alert("Escriba la Hora de Entrega.");
    document.pedido.horaentrega.focus();
    return (false);
  }*/
  
   if (document.pedido.telefonoconfirmacion.value.length < 1) {
    alert("Escriba el Teléfono de Confirmación.");
    document.pedido.telefonoconfirmacion.focus();
    return (false);
  }
   
    /*if (document.pedido.fechaconfirmacion.value.length < 1) {
    alert("Escriba la fecha de Confirmación.");
    document.pedido.fechaconfirmacion.focus();
    return (false);
  }*
  
   /*if (document.pedido.horaconfirmacion.value.length < 1) {
    alert("Escriba la Hora de Confirmación.");
    document.pedido.horaconfirmacion.focus();
    return (false);
  }*/
  
  var entrar = confirm("¿Desea Continuar?")
	if ( !entrar )
      return (false);
	else
	  return (true);
}
//-->
</script>
</head>
<body>
<form action="/prueba/servlet/ModificaPedido" name="pedido" onSubmit="return ValidaEntrada()">
     <input type="hidden" name="numeropedido" value="<%=numeropedido%>"/>
	 <input type="hidden" name="fecha" value="<%=fecha%>"/>
	 <input type="hidden" name="hora" value="<%=hora%>"/>
	 <!--input type="hidden" name="tipocliente" value="<%--=tipocliente--%>"/-->
	 <!--input type="hidden" name="observacion" value="<%--=observacion--%>"/-->
	 

Datos del Producto

<table border="1">
<tr>
<th>
Producto
</th>
<th>
Cantidad
</th>
<th>
Precio
</th>
<th>
Insumo
</th>
</tr>
<%ArrayList<DetallePedido> arrayDetallePedido = new ArrayList<DetallePedido>();
ManejadorDetallePedido manDetallePedido = new ManejadorDetallePedido();
manDetallePedido.setNumeroPedido(numeropedido);
arrayDetallePedido = manDetallePedido.consultar();
Iterator iteratDetallePedido = arrayDetallePedido.iterator();
int i = 1;
while (iteratDetallePedido.hasNext())
{
DetallePedido detallePedido = (DetallePedido) iteratDetallePedido.next();%>
<tr>
<td>
<%
ArrayList<Producto> arrayProducto= new ArrayList<Producto>();
ManejadorProducto manProducto = new ManejadorProducto();
manProducto.setCodigoProducto(detallePedido.getCodigoProducto());
arrayProducto= manProducto.consultar();
Iterator itProducto= arrayProducto.iterator();
  while (itProducto.hasNext())
  {
  Producto producto= (Producto) itProducto.next();
  %>
  &nbsp;
  <%=producto.getNombreProducto()%>
  <%}%>
<input type="hidden" name=producto<%=i%> value="<%=detallePedido.getCodigoProducto()%>"/>
</td>
<td>
<br>
<%out.println(detallePedido.getCantidadProducto());%>
<input type="hidden" name=cantidad<%=i%> value="<%=detallePedido.getCantidadProducto()%>"/>
</td>
<td>
<br>
<%out.println(detallePedido.getPrecioProducto());%>
<input type="hidden" name=precio<%=i%> value="<%=detallePedido.getPrecioProducto()%>"/>
</td>
<td>
<table border="1">
<tr>
<th>
Insumo</th>
<th>
Cantidad</th>
<th>
Unidad Medida
</th>
<th>
Stock Disponible
</th>
<th>
Unidad Medida
</th>
</tr>					
<%
ArrayList<Ingrediente> arrayIngrediente = new ArrayList<Ingrediente>();
ManejadorIngrediente manIngrediente = new ManejadorIngrediente();
manIngrediente.setCodigoProducto(detallePedido.getCodigoProducto());
arrayIngrediente = manIngrediente.consultar();
Iterator itIngrediente = arrayIngrediente.iterator();
int j = 1;
  while (itIngrediente.hasNext())
  {
  Ingrediente ingrediente = (Ingrediente) itIngrediente.next();
   %>
<tr>
<td>
  &nbsp;
  <%
  ArrayList<Producto> arrayProducto2= new ArrayList<Producto>();
  ManejadorProducto manProducto2 = new ManejadorProducto();
  manProducto2.setCodigoProducto(ingrediente.getCodigoInsumo());
  arrayProducto2 = manProducto2.consultar();
  Iterator itProducto2= arrayProducto2.iterator();
    while (itProducto2.hasNext())
    {
    Producto producto2= (Producto) itProducto2.next();
    %>
    <%=producto2.getNombreProducto()%>
    <%}%>

  
  <%
  ArrayList<Insumo> arrayInsumo = new ArrayList<Insumo>();
  ManejadorInsumo manInsumo = new ManejadorInsumo();
  manInsumo.setCodigoInsumo(ingrediente.getCodigoInsumo());
  arrayInsumo = manInsumo.consultar();
  Iterator itInsumo = arrayInsumo.iterator();
    while (itInsumo.hasNext())
    {
    Insumo insumo = (Insumo) itInsumo.next();
    %>
    <%=insumo.getNombreInsumo()%>
    <%}%>
	
<input type="hidden" name="insumo<%=i%><%=j%>" value="<%=ingrediente.getCodigoInsumo()%>"/>
</td>
<td>
<%cantidadinsumo = String.valueOf(Integer.parseInt(detallePedido.getCantidadProducto())*Integer.parseInt(ingrediente.getCantidadInsumo()));%>
&nbsp;
<%=cantidadinsumo%>
<input type="hidden" name="cantidadinsumo<%=i%><%=j%>" value="<%=cantidadinsumo%>"/>
</td>
<td>
  <%
  ArrayList<UnidadMedida> arrayUnidadMedida = new ArrayList<UnidadMedida>();
  ManejadorUnidadMedida manUnidadMedida = new ManejadorUnidadMedida();
  manUnidadMedida.setCodigoUnidadMedida(ingrediente.getCodigoUnidadMedida());
  arrayUnidadMedida = manUnidadMedida.consultar();
  Iterator itUnidadMedida = arrayUnidadMedida.iterator();
    while (itUnidadMedida.hasNext())
   {
    UnidadMedida unidadMedida = (UnidadMedida) itUnidadMedida.next();
    %>
    &nbsp;
    <%=unidadMedida.getNombreUnidadMedida()%>
    <%}%>
<input type="hidden" name="unidadmedida<%=i%><%=j%>" value="<%=ingrediente.getCodigoUnidadMedida()%>"/>
</td>
<td>
  <%
  ArrayList<Stock> arrayStock = new ArrayList<Stock>();
  ManejadorStock manStock = new ManejadorStock();
  manStock.setCodigoProducto(ingrediente.getCodigoInsumo());
  arrayStock = manStock.consultar();
  Iterator itStock = arrayStock.iterator();
    while (itStock.hasNext())
    { 
    Stock stock= (Stock) itStock.next();
    %>
    &nbsp;
    <%=stock.getStockDisponible()%>
    <%--}--%>
</td>
<td>
&nbsp;

<%
  ArrayList<UnidadMedida> arrayUnidadMedida2 = new ArrayList<UnidadMedida>();
  ManejadorUnidadMedida manUnidadMedida2 = new ManejadorUnidadMedida();
  manUnidadMedida2.setCodigoUnidadMedida(stock.getCodigoUnidadMedida());
  arrayUnidadMedida2 = manUnidadMedida2.consultar();
  Iterator itUnidadMedida2 = arrayUnidadMedida2.iterator();
    while (itUnidadMedida2.hasNext())
   {
    UnidadMedida unidadMedida2 = (UnidadMedida) itUnidadMedida2.next();
    %>
    &nbsp;
    <%=unidadMedida2.getNombreUnidadMedida()%>
    <%}%>
 <%}%>
</td>
</tr>
  <%j++;%>
<%}%>
</table>
<input type="hidden" name=ultimafila<%=i%> value="<%=j-1%>"/>
</td>
</tr>
<%i++;%>
<%}%>
<tr>
<td>
</td>
<td>
Total
</td>
<td>
<%out.println(preciototal);%>
<input type="hidden" name="total" value="<%=preciototal%>"/>
</td>
</tr>
</table>
<input type="hidden" name=ultimafilai value="<%=i-1%>"/>



	  


       		

        
<input name="Enviar" value="Enviar" type="submit">
<input name="Enviar" value="Volver" type="submit">
</form>
</body>
</html>
