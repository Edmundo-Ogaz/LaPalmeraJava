package cl.laPalmera.elimina;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.Stock;

public class EliminaStock extends HttpServlet
{

    public EliminaStock()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
      	String filproducto= httpservletrequest.getParameter("filproducto");
        //String filnombre= httpservletrequest.getParameter("filnombre");
      	String enviara = "";
	    if (opcion.equals("Eliminar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaStock.jsp&titulo=Listado Stock";
          enviara = enviara + "&filproducto="+filproducto;
          //enviara = enviara + "&filnombre="+filnombre; 
            
          Stock stock = new Stock();
          stock.setCodigoProducto(httpservletrequest.getParameter("seleccion"));
          stock.eliminar();
          } 
	           
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/UsoSistema.jsp?destino=FilUbicacion.jsp&titulo=Filtrado de Ubicacion");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/Fin.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}