package cl.laPalmera.graba;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.DevolucionInsumo;
import unab.com.DetalleDevolucionInsumo;
import unab.com.Stock;


public class GrabaDevolucionInsumo extends HttpServlet
{

    public GrabaDevolucionInsumo()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
    {
        
        
        String opcion = httpservletrequest.getParameter("Enviar");
        String filordenfabricacion = httpservletrequest.getParameter("filordenfabricacion");
      	String filfuncionario = httpservletrequest.getParameter("filfuncionario");
      	String ordenfabricacion = httpservletrequest.getParameter("ordenfabricacion");
      	String enviara = "";
	    if (opcion.equals("Enviar"))
	    { 
	    enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaDevolucionInsumo.jsp&titulo=Lista Devoluci�n de Insumos";
        enviara = enviara + "&filordenfabricacion="+filordenfabricacion;
        enviara = enviara + "&filfuncionario="+filfuncionario;
        enviara = enviara + "&seleccion="+ordenfabricacion;
            
		 DevolucionInsumo devolucionInsumo = new DevolucionInsumo();
		
		 devolucionInsumo.setCodigoOrdenFabricacion(httpservletrequest.getParameter("ordenfabricacion"));
         devolucionInsumo.setFechaDevolucionInsumo(new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date()));
         devolucionInsumo.setHoraDevolucionInsumo(new java.text.SimpleDateFormat("hh:mm:ss").format(new java.util.Date()));
         devolucionInsumo.setRutFuncionario(httpservletrequest.getParameter("funcionario"));
         devolucionInsumo.setObservacion(httpservletrequest.getParameter("observacion"));
		 devolucionInsumo.grabar();
		 
		 String correlativodevolucioninsumo = devolucionInsumo.buscarUltimo();
		 
		 DetalleDevolucionInsumo detalleDevolucionInsumo = new DetalleDevolucionInsumo();
		 Stock stock = new Stock();
		 
		 String cantidadinsumo = httpservletrequest.getParameter("cantidadinsumo");
		if (!cantidadinsumo.equals("0"))
          {
          	detalleDevolucionInsumo.setCorrelativoDevolucionInsumo(correlativodevolucioninsumo);
            detalleDevolucionInsumo.setCodigoInsumo(httpservletrequest.getParameter("insumo"));
            detalleDevolucionInsumo.setCantidadDevolucionInsumo(httpservletrequest.getParameter("cantidadinsumo"));
            detalleDevolucionInsumo.setCodigoUnidadMedida(httpservletrequest.getParameter("unidadmedida"));
            detalleDevolucionInsumo.grabar();
		 
		 	/*stock.setCodigoProducto(httpservletrequest.getParameter("insumo"));
			if (stock.buscar())
			  {
			  String stockdisponible = String.valueOf(Float.parseFloat(stock.getStockDisponible())+Float.parseFloat(httpservletrequest.getParameter("cantidadinsumo")));
			  stock.setStockDisponible(stockdisponible);
			  //stock.setCodigoUnidadMedida(httpservletrequest.getParameter("unidadmedida"));
			  stock.modificar();
			  }*/
		 
		  }
		 
		 int i = Integer.parseInt(httpservletrequest.getParameter("cantidaddevolucion"));
        	for(int j = 1; j < i; j++)
        	{
                        
            detalleDevolucionInsumo.setCorrelativoDevolucionInsumo(correlativodevolucioninsumo);
            detalleDevolucionInsumo.setCodigoInsumo(httpservletrequest.getParameter("insumo"+j));
            detalleDevolucionInsumo.setCantidadDevolucionInsumo(httpservletrequest.getParameter("cantidadinsumo"+j));
            detalleDevolucionInsumo.setCodigoUnidadMedida(httpservletrequest.getParameter("unidadmedida"+j));
            detalleDevolucionInsumo.grabar();
            
            /*stock.setCodigoProducto(httpservletrequest.getParameter("insumo"+j));
			if (stock.buscar())
			  {
			  String stockdisponible = String.valueOf(Float.parseFloat(stock.getStockDisponible())+Float.parseFloat(httpservletrequest.getParameter("cantidadinsumo"+j)));
			  stock.setStockDisponible(stockdisponible);
			  //stock.setCodigoUnidadMedida(httpservletrequest.getParameter("unidadmedida"+j));
			  stock.modificar();
			  }*/
            
            }
        } 
	    
	    //HttpSession session = httpservletrequest.getSession();
		//session.invalidate();				       
	    
	    httpservletresponse.sendRedirect(enviara);
        
//httpservletresponse.sendRedirect("http://localhost:8080/LaPalmera/jsp/UsoSistema.jsp?destino=FilProducto.jsp&titulo=Filtrado de Productos");
//RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
//requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}