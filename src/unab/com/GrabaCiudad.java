package unab.com;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GrabaCiudad extends HttpServlet
{

    public GrabaCiudad()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
         String opcion = httpservletrequest.getParameter("Enviar");
         String filciudad = httpservletrequest.getParameter("filciudad");
         String filregion = httpservletrequest.getParameter("filregion");
      	 String enviara = "";
	     
	     if (opcion.equals("Enviar"))
	       { 
	       enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaCiudad.jsp&titulo=Listado Ciudad";
	       enviara = enviara + "&filciudad="+filciudad;
           enviara = enviara + "&filregion="+filregion; 
	          
           Ciudad ciudad = new Ciudad();
           ciudad.setCodigoCiudad(httpservletrequest.getParameter("codigo"));
           ciudad.setNombreCiudad(httpservletrequest.getParameter("nombre"));
           ciudad.setCodigoRegion(httpservletrequest.getParameter("region"));
           ciudad.grabar();
        } 
	                   
            
            						       
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/ciudad.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}