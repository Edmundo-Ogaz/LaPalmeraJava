package cl.laPalmera.modifica;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModificaBodega extends HttpServlet
{

    public ModificaBodega()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
        String filcodigo= httpservletrequest.getParameter("filcodigo");
        String filnombre= httpservletrequest.getParameter("filnombre");
        String enviara = "";
        
	    if (opcion.equals("Enviar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaBodega.jsp&titulo=Listado Bodega";
	      enviara = enviara + "&filcodigo="+filcodigo;
          enviara = enviara + "&filnombre="+filnombre; 
          
          Bodega bodega = new Bodega();
          bodega.setCodigoBodega(httpservletrequest.getParameter("codigo"));
          bodega.setNombreBodega(httpservletrequest.getParameter("nombre"));
          bodega.modificar();
        } 
	                               						       
		httpservletresponse.sendRedirect(enviara);
		
        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/bodega.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}