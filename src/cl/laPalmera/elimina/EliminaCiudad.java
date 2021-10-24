package cl.laPalmera.elimina;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.Ciudad;


public class EliminaCiudad extends HttpServlet
{

    public EliminaCiudad()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
        String filciudad = httpservletrequest.getParameter("filciudad");
        String filregion = httpservletrequest.getParameter("filregion");
      	String enviara = "";
	    
	    if (opcion.equals("Eliminar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaCiudad.jsp&titulo=Listado Ciudad";
          enviara = enviara + "&filciudad="+filciudad;
          enviara = enviara + "&filregion="+filregion; 
          
          Ciudad ciudad = new Ciudad();
          ciudad.setCodigoCiudad(httpservletrequest.getParameter("seleccion"));
          ciudad.eliminar();
          }

		httpservletresponse.sendRedirect(enviara);
    }
}