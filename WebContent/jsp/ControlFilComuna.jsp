<html>
<head>
<title>Pastelerķa La Palmera</title>
</head>
<body>
<%String opcion = request.getParameter("Enviar");
  String enviara = "";
  if (opcion.equals("Buscar"))
    { 
    enviara = "/jsp/UsoSistema.jsp?destino=ListaComuna.jsp&titulo=Listado de Comuna";
	} 
  else 
    { 
    if (opcion.equals("Nueva Comuna"))
      { 
      enviara = "/jsp/UsoSistema.jsp?destino=NuevaComuna.jsp&titulo=Nueva Comuna";	
      } 
    } 
%>
   <jsp:forward page="<%=enviara%>"/>

</body>
</html>
