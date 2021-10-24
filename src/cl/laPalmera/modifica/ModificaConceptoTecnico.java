package cl.laPalmera.modifica;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModificaConceptoTecnico extends HttpServlet
{

    public ModificaConceptoTecnico()
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
	      enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaConceptoTecnico.jsp&titulo=Listado Concepto T�cnico";
          enviara = enviara + "&filcodigo="+filcodigo;
          enviara = enviara + "&filnombre="+filnombre; 
          
          ConceptoTecnico conceptoTecnico = new ConceptoTecnico();
          conceptoTecnico.setCodigoConceptoTecnico(httpservletrequest.getParameter("codigo"));
          conceptoTecnico.setNombreConceptoTecnico(httpservletrequest.getParameter("nombre"));
          conceptoTecnico.modificar();
          } 
	          
		httpservletresponse.sendRedirect(enviara);

        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/conceptotecnico.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}