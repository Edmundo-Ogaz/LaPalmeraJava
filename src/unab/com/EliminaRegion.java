package unab.com;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EliminaRegion extends HttpServlet
{

    public EliminaRegion()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
      	String filregion = httpservletrequest.getParameter("filregion");
      	String enviara = "";
	    
	    if (opcion.equals("Eliminar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaRegion.jsp&titulo=Listado Regi�n";
          enviara = enviara + "&filregion="+filregion;
          
          Region region = new Region();
          region.setCodigoRegion(httpservletrequest.getParameter("seleccion"));
          region.eliminar();
          } 
	          
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/region.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}