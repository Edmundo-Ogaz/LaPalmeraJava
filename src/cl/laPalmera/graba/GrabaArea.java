package cl.laPalmera.graba;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.Area;

public class GrabaArea extends HttpServlet
{

    public GrabaArea()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
        String filarea = httpservletrequest.getParameter("filarea");
      	String enviara = "";
	    
	    if (opcion.equals("Enviar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaArea.jsp&titulo=Listado Area";
	      enviara = enviara + "&filarea="+filarea;
	          
          Area area = new Area();
          area.setCodigoArea(httpservletrequest.getParameter("codigo"));
          area.setNombreArea(httpservletrequest.getParameter("nombre"));
          area.grabar();
          } 
	                   
            
            						       
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/area.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}