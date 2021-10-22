<%@page import="unab.com.Usuario"%>
<%Usuario u = new Usuario();
  u.setUsuario(request.getParameter("username"));
  u.setPassword(request.getParameter("password"));
  if (u.validaUsuario())
	{
%>
	<%
	response.sendRedirect("pagina_inicio.jsp");
	%>
<%	}
	else
	{
%>
	NO es bienvenido
<%}%>
