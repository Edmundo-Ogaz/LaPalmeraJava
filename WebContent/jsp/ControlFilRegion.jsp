<html>
<head>
<title>Pasteler�a La Palmera</title>
</head>
<body>
<%String opcion = request.getParameter("Enviar");
  String enviara = "";
  if (opcion.equals("Buscar"))
    { 
    enviara = "/jsp/UsoSistema.jsp?destino=ListaRegion.jsp&titulo=Listado de Regi�n";
	} 
  else 
    { 
    if (opcion.equals("Nueva Regi�n"))
      { 
      enviara = "/jsp/UsoSistema.jsp?destino=NuevaRegion.jsp&titulo=Nueva Regi�n";	
      } 
    } 
%>
   <jsp:forward page="<%=enviara%>"/>

</body>
</html>
