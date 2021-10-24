package cl.laPalmera.graba;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GrabaProductoLinea extends HttpServlet
{

    public GrabaProductoLinea()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
      	//String filproducto = httpservletrequest.getParameter("filproducto");
        //String fillineaproduccion = httpservletrequest.getParameter("fillineaproduccion");
      	String filproducto = "";
        String fillineaproduccion = "";
      	String enviara = "";
	    
	    if (opcion.equals("Enviar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaProductoLinea.jsp&titulo=Listado Porducto por Linea";
	      enviara = enviara + "&filproducto="+filproducto;
          enviara = enviara + "&fillineaproduccion="+fillineaproduccion; 
              
          ProductoLinea productoLinea = new ProductoLinea();
          productoLinea.setCodigoLineaProduccion(httpservletrequest.getParameter("lineaproduccion"));
          productoLinea.setCodigoProducto(httpservletrequest.getParameter("producto"));
          productoLinea.grabar();
          } 
	                   
            
            						       
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/area.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}