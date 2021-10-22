<%@page import="unab.com.Usuario"%>
<%Usuario u = new Usuario();
  u.setUser(request.getParameter("usuario"));
  u.setClave(request.getParameter("clave"));
  if (u.validaUsuario())
	{
%>
	Bienvenido <%=u.getNombre()%>
<%	}
	else
	{
%>
	NO es bienvenido
<%}%>

