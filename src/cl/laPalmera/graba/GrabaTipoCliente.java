package cl.laPalmera.graba;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.TipoCliente;


public class GrabaTipoCliente extends HttpServlet
{

    public GrabaTipoCliente()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
      	String filcodigo = httpservletrequest.getParameter("filcodigo");
        String filnombre = httpservletrequest.getParameter("filnombre");
      	String enviara = "";
	    
	    if (opcion.equals("Enviar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaTipoCliente.jsp&titulo=Listado Tipo de Cliente";
          enviara = enviara + "&filcodigo="+filcodigo;
          enviara = enviara + "&filnombre="+filnombre; 
            
          TipoCliente tipoCliente = new TipoCliente();
          tipoCliente.setCodigoTipoCliente(httpservletrequest.getParameter("codigo"));
          tipoCliente.setNombreTipoCliente(httpservletrequest.getParameter("nombre"));
          tipoCliente.grabar();
          } 
	            
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/tipocliente.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}