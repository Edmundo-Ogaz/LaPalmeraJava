package unab.com;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EliminaComuna extends HttpServlet
{

    public EliminaComuna()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
       String opcion = httpservletrequest.getParameter("Enviar");
       String filcomuna = httpservletrequest.getParameter("filcomuna");
       String filciudad = httpservletrequest.getParameter("filciudad");
       String enviara = "";
	   
	   if (opcion.equals("Eliminar"))
	     { 
	     enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaComuna.jsp&titulo=Listado Comuna";
         enviara = enviara + "&filcomuna="+filcomuna;
         enviara = enviara + "&filciudad="+filciudad;   
         
         Comuna comuna = new Comuna();
         comuna.setCodigoComuna(httpservletrequest.getParameter("seleccion"));
         comuna.eliminar();
         } 
	                   
        httpservletresponse.sendRedirect(enviara);
    }
}