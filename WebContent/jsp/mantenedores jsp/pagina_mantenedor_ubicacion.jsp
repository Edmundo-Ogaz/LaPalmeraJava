<html>
<head>
	<title>Your Company Name</title>
	<link rel="stylesheet" type="text/css" href="Template037.css">
	<script language="JavaScript">
<!--
function validar(formulario) {
  if (formulario.codigo.value.length < 1) {
    alert("Escriba el c�digo de la ubicaci�n.");
    formulario.codigo.focus();
    return (false);
  }
var checkOK = "0123456789";
  var checkStr = formulario.codigo.value;
  var allValid = true;
  var decPoints = 0;
  var allNum = "";
  for (i = 0; i < checkStr.length; i++) {
    ch = checkStr.charAt(i);
    for (j = 0; j < checkOK.length; j++)
      if (ch == checkOK.charAt(j))
        break;
    if (j == checkOK.length) {
      allValid = false;
      break;
    }
    allNum += ch;
  }
  if (!allValid) {
    alert("Escriba s�lo n�meros en el campo \"C�digo\" de la ubicaci�n.");
    formulario.codigo.focus();
    return (false);
  }    
  if (formulario.nombre.value.length < 1) {
    alert("Escriba el nombre de la ubicaci�n.");
    formulario.nombre.focus();
    return (false);
  }
  if (formulario.cantidad.value.length < 1) {
    alert("Escriba la canidad a guardar.");
    formulario.cantidad.focus();
    return (false);
  }
var checkOK = "0123456789";
  var checkStr = formulario.cantidad.value;
  var allValid = true;
  var decPoints = 0;
  var allNum = "";
  for (i = 0; i < checkStr.length; i++) {
    ch = checkStr.charAt(i);
    for (j = 0; j < checkOK.length; j++)
      if (ch == checkOK.charAt(j))
        break;
    if (j == checkOK.length) {
      allValid = false;
      break;
    }
    allNum += ch;
  }
  if (!allValid) {
    alert("Escriba s�lo n�meros en el campo \"Cantidad\" de la ubicaci�n.");
    formulario.cantidad.focus();
    return (false);
  }  
  return (true);
}
//-->
</script>
<script language="JavaScript1.2" src="mm_menu.js"></script>
<script language="JavaScript1.2" src="menu_administrador.js"></script>
</head>
<%@ page import="java.util.*" %>
<%@page import="unab.com.*"%>
<body topmargin="0" leftmargin="0" onLoad="MM_preloadImages('menu_pasteleria/im�genes/menu_pasteleria_r1_c1.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c2_f2.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c2.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c4_f2.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c4.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c6_f2.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c6.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c8_f2.gif','menu_pasteleria/im�genes/menu_pasteleria_r1_c8.gif');">
<script language="JavaScript1.2">mmLoadMenus();</script>
<table cellpadding="0" cellspacing="0" width="752" class="Top">
	<tr>
		<td><img src="images/logo pasteleria la palmera.png" width="750" height="101"></td>
	</tr>
</table>
<table cellpadding="0" cellspacing="0" width="752" class="Middle">
	<tr>
		<td width="106"><img src="menu_pasteleria/im�genes/menu_pasteleria_r1_c1.gif" width="106" height="26"></td>
		<td width="115"><a href="#" onMouseOut="MM_swapImage('menu20pasteleria_r1_c2','','menu_pasteleria/im�genes/menu_pasteleria_r1_c2.gif',1);" onMouseOver="MM_swapImage('menu20pasteleria_r1_c2','','menu_pasteleria/im�genes/menu_pasteleria_r1_c2_f2.gif',1);"><img name="menu20pasteleria_r1_c2" src="menu_pasteleria/im�genes/menu_pasteleria_r1_c2.gif" width="115" height="26" border="0" usemap="#m_menu20pasteleria_r1_c2" alt=""></a></td>
		<td width="35"><img src="menu_pasteleria/im�genes/menu_pasteleria_r1_c1.gif" width="35" height="26"></td>
		<td width="123"><a href="#" onMouseOut="MM_swapImage('menu20pasteleria_r1_c4','','menu_pasteleria/im�genes/menu_pasteleria_r1_c4.gif',1);" onMouseOver="MM_swapImage('menu20pasteleria_r1_c4','','menu_pasteleria/im�genes/menu_pasteleria_r1_c4_f2.gif',1);"><img name="menu20pasteleria_r1_c4" src="menu_pasteleria/im�genes/menu_pasteleria_r1_c4.gif" width="123" height="26" border="0" usemap="#m_menu20pasteleria_r1_c4" alt=""></a></td>
		<td width="35"><img src="menu_pasteleria/im�genes/menu_pasteleria_r1_c1.gif" width="35" height="26"></td>
		<td width="185"><a href="#" onMouseOut="MM_swapImage('menu20pasteleria_r1_c6','','menu_pasteleria/im�genes/menu_pasteleria_r1_c6.gif',1);" onMouseOver="MM_swapImage('menu20pasteleria_r1_c6','','menu_pasteleria/im�genes/menu_pasteleria_r1_c6_f2.gif',1);"><img name="menu20pasteleria_r1_c6" src="menu_pasteleria/im�genes/menu_pasteleria_r1_c6.gif" width="185" height="26" border="0" usemap="#m_menu20pasteleria_r1_c6" alt=""></a></td>
		<td width="35"><img src="menu_pasteleria/im�genes/menu_pasteleria_r1_c1.gif" width="35" height="26"></td>
		<td width="89"><a href="#" onMouseOut="MM_swapImage('menu20pasteleria_r1_c8','','menu_pasteleria/im�genes/menu_pasteleria_r1_c8.gif',1);" onMouseOver="MM_swapImage('menu20pasteleria_r1_c8','','menu_pasteleria/im�genes/menu_pasteleria_r1_c8_f2.gif',1);"><img name="menu20pasteleria_r1_c8" src="menu_pasteleria/im�genes/menu_pasteleria_r1_c8.gif" width="54" height="26" border="0" usemap="#m_menu20pasteleria_r1_c8" alt=""></a></td>
		<td width="62"><img src="menu_pasteleria/im�genes/menu_pasteleria_r1_c1.gif" width="62" height="26"></td>
	</tr>
</table>
<table background="images/pasteleria_fondo3.3.png" cellpadding="0" cellspacing="0" width="752"  height="582"class="Middle">
	<tr height="1">
		<td><img src="_blank.gif" width="20" height="1"></td>
		<td valign="top">
			<table cellpadding="0" cellspacing="0" height="100%">
				<tr>
					<td height="5%">
					</td>
				</tr>
				<tr>
				<td valign="top">
				<h1>Mantenedor Ubicaci�n</h1>
				<!--form action="custom_error.jsp" method="post"-->
				<form method = "get" name = "registro" onSubmit = "return validar(this)" action = "/la-palmera/servlet/GrabaBodega">
  <table>
   <tr>
      <td>C�digo Producto :</td>
	  <%ManejadorProducto manProducto = new ManejadorProducto();%>
<%Vector vecRep;
vecRep = manProducto.consultar();%>
<%Enumeration enumRep = vecRep.elements();%>
   <td><SELECT size="1" name="codigoproducto">
  <%while (enumRep.hasMoreElements())
    {
     Producto producto = (Producto) enumRep.nextElement();%>
     <OPTION VALUE="<%=producto.getCodigoProducto()%>"> <%=producto.getNombreProducto()%></OPTION>
   <%}%>
	  </SELECT></td>
       </tr>
    <tr>
      <td>C�digo Bodega :</td>
	  <%ManejadorBodega manBodega = new ManejadorBodega();%>
<%Vector vecRep1;
vecRep1 = manBodega.consultar();%>
<%Enumeration enumRep1 = vecRep1.elements();%>
   <td><SELECT size="1" name="codigoBodega">
  <%while (enumRep1.hasMoreElements())
    {
     Bodega bodega = (Bodega) enumRep1.nextElement();%>
     <OPTION VALUE="<%=bodega.getCodigoBodega()%>"> <%=bodega.getNombreBodega()%></OPTION>
   <%}%>
	  </SELECT></td>
    </tr>
    <tr>
      <td>Tipo Producto</td>
	  <td><input name = "tipoproducto" type="type" /></td>
    </tr>
    <tr>
      <td>Fecha de Ingreso</td>
	  <td> Dia <select name="diaingreso">
          <option>1
		  <option>2
          <option>3
          <option>4
          </select>
		  Mes <select name="mesingreso">
          <option>1
		  <option>2
          <option>3
          <option>4
          </select>
		  A�o <select name="a�oingreso">
          <option>1
		  <option>2
          <option>3
          <option>4
          </select>
		  </td>
	    <tr>
	<tr>
      <td>Fecha de Vensimiento</td>
	  <td> Dia <select name="diavens">
          <option>1
		  <option>2
          <option>3
          <option>4
          </select>
		  Mes <select name="mesvens">
          <option>1
		  <option>2
          <option>3
          <option>4
          </select>
		  A�o <select name="a�ovens">
          <option>1
		  <option>2
          <option>3
          <option>4
          </select>
		  </td>
	    <tr>
		  <td>Cantidad</td>		  
      <td><input name = "Cantidad" type="type" size="10"/></td>
    </tr>
    <tr>
      <td colspan="2">
	  <table>
	  <tr>
	  <td valign="top">Nota</td>
      <td><textarea name="nota" rows = 5 cols = 60></textarea></td>
	  </tr>
	  </table>
	  </td>
    </tr>
    <tr>
      <td></td>
      <td>
	  <table>
	  <tr>
	  <td align="right" width="168"><input name="enviar" value="Enviar" type="submit"></td>
      <td align="right" width="77"><input name="cancelar" value="Cancelar" type="reset"></td>
	  </tr>
	  </table>
	  </td>
    </tr>
  </table>
</form>
				</td>
				</tr>
			</table>
		</td>
		<td>
			</td>
		<td>&nbsp;</td>
	</tr>
</table>
<table cellpadding="0" cellspacing="0" width="752" class="Bottom">
	<tr>
		<td><img src="images/Copyright.gif" width="363" height="37"></td>
		<td><a href="index.html"><img src="images/ButtonWhoWeAre.gif" border="0" width="78" height="37"></a></td>
		<td><a href="index.html"><img src="images/ButtonOurKitchen.gif" border="0" width="77" height="37"></a></td>
		<td><a href="index.html"><img src="images/ButtonEvents.gif" border="0" width="60" height="37"></a></td>
		<td><a href="index.html"><img src="images/ButtonReservations.gif" border="0" width="79" height="37"></a></td>
		<td><a href="index.html"><img src="images/ButtonContactUs.gif" border="0" width="72" height="37"></a></td>
		<td><img src="images/Back4.gif" width="21" height="37"></td>
	</tr>
</table>
<map name="m_null">
<area shape="poly" coords="35,2,153,2,153,26,35,26,35,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_0,35,26,null,'nmenu_pasteleria_1_1');"  >
</map>
<map name="m_menu20pasteleria_r1_c2">
<area shape="poly" coords="-3,2,115,2,115,26,-3,26,-3,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_0,-3,26,null,'menu20pasteleria_r1_c2');"  >
</map>
<map name="m_menu20pasteleria_r1_c4">
<area shape="poly" coords="1,2,122,2,122,26,1,26,1,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_1,1,26,null,'menu20pasteleria_r1_c4');"  >
</map>
<map name="m_menu20pasteleria_r1_c6">
<area shape="poly" coords="0,2,187,2,187,26,0,26,0,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_2,0,26,null,'menu20pasteleria_r1_c6');"  >
</map>
<map name="m_null">
<area shape="poly" coords="9,2,66,2,66,26,9,26,9,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_3,9,26,null,'nmenu_pasteleria_1_7');"  >
<area shape="poly" coords="-185,2,2,2,2,26,-185,26,-185,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_2,-185,26,null,'nmenu_pasteleria_1_7');"  >
</map>
<map name="m_menu20pasteleria_r1_c8">
<area shape="poly" coords="-1,2,56,2,56,26,-1,26,-1,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_3,-1,26,null,'menu20pasteleria_r1_c8');"  >
</map>
<map name="m_null">
<area shape="poly" coords="-55,2,2,2,2,26,-55,26,-55,2" href="#" alt="" onMouseOut="MM_startTimeout();"  onMouseOver="MM_showMenu(window.mm_menu_0328002410_3,-55,26,null,'nmenu_pasteleria_1_9');"  >
</map>
</body>
</html>
