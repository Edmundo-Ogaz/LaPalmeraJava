<html>
<head>
<title>Pastelería La Palmera</title>
</head>
<body>
<%String opcion = request.getParameter("Enviar");
  String enviara = "";
  if (opcion.equals("Buscar"))
    { 
    enviara = "/jsp/UsoSistema.jsp?destino=ListaRegion.jsp&titulo=Listado de Región";
	} 
  else 
    { 
    if (opcion.equals("Nueva Región"))
      { 
      enviara = "/jsp/UsoSistema.jsp?destino=NuevaRegion.jsp&titulo=Nueva Región";	
      } 
    } 
%>
   <jsp:forward page="<%=enviara%>"/>

</body>
</html>
