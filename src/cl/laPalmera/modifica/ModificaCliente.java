package cl.laPalmera.modifica;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.Cliente;


public class ModificaCliente extends HttpServlet
{

    public ModificaCliente()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
       String opcion = httpservletrequest.getParameter("Enviar");
       String filrut = httpservletrequest.getParameter("filrut");
       String filnombre = httpservletrequest.getParameter("filnombre");
       String fildireccion = httpservletrequest.getParameter("fildireccion");
       String filcomuna = httpservletrequest.getParameter("filcomuna");
       String filtelefono = httpservletrequest.getParameter("filtelefono");
       String filfechanacimiento = httpservletrequest.getParameter("filfechanacimiento");
       String filemail = httpservletrequest.getParameter("filemail");
       String filpaginaweb = httpservletrequest.getParameter("filpaginaweb");
       String filtipocliente = httpservletrequest.getParameter("filtipocliente");
       String filobservacion = httpservletrequest.getParameter("filobservacion");
       String enviara = "";
	   
	   if (opcion.equals("Enviar"))
	     { 
	     enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaCliente.jsp&titulo=Listado  Cliente";
         enviara = enviara + "&filrut="+filrut;
         enviara = enviara + "&filnombre="+filnombre; 
         enviara = enviara + "&fildireccion="+fildireccion;
         enviara = enviara + "&filcomuna="+filcomuna; 
         enviara = enviara + "&filtelefono="+filtelefono;
         enviara = enviara + "&filfechanacimiento="+filfechanacimiento; 
         enviara = enviara + "&filemail="+filemail;
         enviara = enviara + "&filpaginaweb="+filpaginaweb; 
         enviara = enviara + "&filtipocliente="+filtipocliente;
         enviara = enviara + "&filobservacion="+filobservacion;
         
         Cliente cliente = new Cliente();
         cliente.setRutCliente(httpservletrequest.getParameter("rut"));
         cliente.setNombreCliente(httpservletrequest.getParameter("nombre"));
         cliente.setDireccionCliente(httpservletrequest.getParameter("direccion"));
         cliente.setCodigoComuna(httpservletrequest.getParameter("comuna"));
         cliente.setFechaNacimientoCliente(httpservletrequest.getParameter("fechanacimiento"));
         cliente.setTelefonoCliente(httpservletrequest.getParameter("telefono"));
         cliente.setEmailCliente(httpservletrequest.getParameter("email"));
         cliente.setPaginaWebCliente(httpservletrequest.getParameter("paginaweb"));
         cliente.setCodigoTipoCliente(httpservletrequest.getParameter("tipocliente"));
         cliente.setObservacionCliente(httpservletrequest.getParameter("observacion"));
         cliente.modificar();
         } 
	          
		httpservletresponse.sendRedirect(enviara);
        //httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/cliente.jsp");
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}