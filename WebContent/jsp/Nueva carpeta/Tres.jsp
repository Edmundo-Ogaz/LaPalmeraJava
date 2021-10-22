La suma de:<br>
<%int elementos=Integer.parseInt(request.getParameter("elementos"));
  int resultado = 0;
  for(int i=1;i<= elementos;i++)
	{
	resultado+=Integer.parseInt(request.getParameter("cajita"+i));
%>
<%=i%><br>
<%}%>
<br>
Es: <%=resultado%>	
	 