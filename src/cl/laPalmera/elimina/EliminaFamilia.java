package cl.laPalmera.elimina;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EliminaFamilia extends HttpServlet
{

    public EliminaFamilia()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
      	String filcodigo = httpservletrequest.getParameter("filcodigo");
        String filnombre = httpservletrequest.getParameter("filnombre");
      	String enviara = "";
	    if (opcion.equals("Eliminar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaFamilia.jsp&titulo=Listado Familia";
          enviara = enviara + "&filcodigo="+filcodigo;
          enviara = enviara + "&filnombre="+filnombre; 
          
          Familia familia = new Familia();
          familia.setCodigoFamilia(httpservletrequest.getParameter("seleccion"));
          familia.eliminar();
        } 
	                   
        httpservletresponse.sendRedirect(enviara);
    }
}