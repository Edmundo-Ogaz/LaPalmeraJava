package cl.laPalmera.modifica;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.Familia;


public class ModificaFamilia extends HttpServlet
{

    public ModificaFamilia()
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
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaFamilia.jsp&titulo=Listado Familia";
          enviara = enviara + "&filcodigo="+filcodigo;
          enviara = enviara + "&filnombre="+filnombre; 
          
          Familia familia = new Familia();
          familia.setCodigoFamilia(httpservletrequest.getParameter("codigo"));
          familia.setNombreFamilia(httpservletrequest.getParameter("nombre"));
          familia.modificar();
          } 
	       
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/familia.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}