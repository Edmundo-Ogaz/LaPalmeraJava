package cl.laPalmera.graba;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import unab.com.EspecificarProduccion;
import unab.com.ProgramaProduccion;

public class GrabaEspecificarProduccion extends HttpServlet
{

    public GrabaEspecificarProduccion()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
        {
            
            String opcion = httpservletrequest.getParameter("Enviar");
      		String enviara = "";
	      	if (opcion.equals("Enviar"))
	          { 
	          enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=FilEspecificarProduccion.jsp&titulo=Filtrado Especificar Producción";
	          

				EspecificarProduccion especificarProduccion = new EspecificarProduccion();
				especificarProduccion.setCodigoOrdenFabricacion(httpservletrequest.getParameter("ordenfabricacion"));
				especificarProduccion.setFechaEspecificarProduccion(new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date()));
				especificarProduccion.setHoraEspecificarProduccion(new java.text.SimpleDateFormat("hh:mm:ss").format(new java.util.Date()));
				especificarProduccion.setCodigoProducto(httpservletrequest.getParameter("producto")); 
				especificarProduccion.setCodigoLineaProduccion(httpservletrequest.getParameter("lineaproduccion"));
				especificarProduccion.setRutFuncionario(httpservletrequest.getParameter("funcionario"));
				especificarProduccion.grabar();
				
				ProgramaProduccion programaProduccion= new ProgramaProduccion();
				programaProduccion.setCodigoOrdenFabricacion(httpservletrequest.getParameter("ordenfabricacion"));
				programaProduccion.setFechaProgramaProduccion(httpservletrequest.getParameter("fecha"));
				programaProduccion.setHoraProgramaProduccion(httpservletrequest.getParameter("hora"));
				programaProduccion.setCodigoProducto(httpservletrequest.getParameter("producto")); 
				programaProduccion.setCodigoLineaProduccion(httpservletrequest.getParameter("lineaproduccion"));
				programaProduccion.setCantidadProgramada(httpservletrequest.getParameter("cantidadprogramada"));
				programaProduccion.setCantidadFabricada("0");
				programaProduccion.setSaldoPorFabricar(httpservletrequest.getParameter("cantidadprogramada"));
				programaProduccion.setEstadoOrdenFabricacion("A");
				programaProduccion.modificar();
 				} 
	          /*else 
	            { 
	            if (opcion.equals("Volver"))
	              { 
	              enviara = "http://localhost:8080/LaPalmera/jsp/UsoSistema.jsp?destino=ListaPedido.jsp&titulo=Listado Pedidos";
	              } 
	              
	             }*/             
            
            
			
			
			
			//HttpSession session = request.getSession();
			//session.invalidate();				       
		httpservletresponse.sendRedirect(enviara);	
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/Fin.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}