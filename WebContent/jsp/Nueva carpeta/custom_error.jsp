<%@ page contentType="text/html" %>
<%@ page import="unab.com.UserException" %>
<html>
<head><title>Validar Usuario</title></head>
<body>
<p>validacion de usuario</p>

<jsp:useBean id="myUser" class="unab.com.ImprovedUser" scope="page"/>
<jsp:setProperty name="myUser" property="*"/>

<%
   out.print(" " + myUser.getUsername() + " ");
   try {
     myUser.validateUser();
     out.print("el Usuario: " + myUser.getUsername() + " esta registrado.");
   } catch( UserException e) {
     out.print("usuario no valido: " + e.toString());
   }
%>
</body>
</html>
