package cl.laPalmera.elimina;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.Area;

public class EliminaArea extends HttpServlet
{

    public EliminaArea()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
      	String filarea = httpservletrequest.getParameter("filarea");
      	String enviara = "";
	    
	    if (opcion.equals("Eliminar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaArea.jsp&titulo=Listado Area";
          enviara = enviara + "&filarea="+filarea;
          Area area = new Area();
          area.setCodigoArea(httpservletrequest.getParameter("seleccion"));
          area.eliminar();
          } 
	          
		httpservletresponse.sendRedirect(enviara);
    }
}