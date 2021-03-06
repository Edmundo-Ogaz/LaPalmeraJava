package cl.laPalmera.graba;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.FichaTecnica;


public class GrabaFichaTecnica extends HttpServlet
{

    public GrabaFichaTecnica()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        String opcion = httpservletrequest.getParameter("Enviar");
        String filproducto = httpservletrequest.getParameter("filproducto");
        String filconceptotecnico = httpservletrequest.getParameter("filconceptotecnico");
        String enviara = "";
        
	    if (opcion.equals("Enviar"))
	      { 
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaFichaTecnica.jsp&titulo=Listado Ficha Tecnica";
	      enviara = enviara + "&filproducto="+filproducto;
          enviara = enviara + "&filconceptotecnico="+filconceptotecnico; 
            
          FichaTecnica fichaTecnica = new FichaTecnica();
          fichaTecnica.setCodigoProducto(httpservletrequest.getParameter("producto"));
          fichaTecnica.setCodigoConceptoTecnico(httpservletrequest.getParameter("conceptotecnico"));
          fichaTecnica.setDescripcionFichaTecnica(httpservletrequest.getParameter("descripcion"));
          fichaTecnica.grabar();
          } 
	                   
            
            						       
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/fichatecnica.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}