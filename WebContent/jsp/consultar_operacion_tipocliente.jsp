<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>
<%@page import="java.util.*"%>
<%@page import="unab.com.*"%>
<body>
<jsp:useBean id="tipoCliente" class="TipoCliente" scope="session"/>
<%
String button = request.getParameter("modificar");
if (button != null){
%>
<jsp:forward page="tipocliente_modificar.jsp"/>
<% }
else
{
%>
<%
tipoCliente.setCodigoTipoCliente(request.getParameter("cod"));
//tipoCliente.eliminar();
%>
<!--%=producto.getCodigoProducto()%-->
<jsp:forward page="/servlet/EliminaTipoCliente"/>
<%
}
%>
</body>
</html>
