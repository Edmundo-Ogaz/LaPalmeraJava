<%@ page import="unab.com.Usuario" %>
<jsp:useBean id="pepito" scope="application" class="Usuario"/>
Bienvenido <%=pepito.getNombre()%>