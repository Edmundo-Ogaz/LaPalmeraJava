<html>
<head>
<title>Pastelería La Palmera</title>
</head>
<body>
<%String opcion = request.getParameter("Enviar");
  String enviara = "";
  if (opcion.equals("Especificar Producción"))
    { 
    enviara = "/jsp/UsoSistema.jsp?destino=EspecificarProduccion.jsp&titulo=Especificar Producción";
	} 
 /* else 
    { 
    if (opcion.equals("Modificar"))
      { 
      enviara = "/jsp/UsoSistema.jsp?destino=ModificaEspecificarProduccion.jsp&titulo=Modificar Especificación de Producción";
      }
	  else 
      { 
      if (opcion.equals("Volver"))
        { 
        enviara = "/jsp/UsoSistema.jsp?destino=FilEspecificarProduccion.jsp&titulo=Filtrado Especificar Producción";
        } 
      }
	}*/ 
%>
   <jsp:forward page="<%=enviara%>"/>

</body>
</html>
