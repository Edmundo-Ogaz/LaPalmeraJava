<form action = "Tres.jsp">
<%int elementos = Integer.parseInt(request.getParameter("oper"));
  for(int i = 1;i <= elementos;i++)
	{
	%>
Operador<%=i%>: <input type=text name=cajita<%=i%> value = ""><br>
<%}%>
<input type=hidden name=elementos value=<%=elementos%>>
<input type=submit name=Sumar value=Sumar>
</form>