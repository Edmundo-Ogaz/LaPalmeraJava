package cl.laPalmera.modifica;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unab.com.CabezaPedido;
import unab.com.ConfirmacionPedido;
import unab.com.DespachoPedido;
import unab.com.DetallePedido;
import unab.com.OrdenFabricacion;
import unab.com.ProductoLinea;
import unab.com.ProgramaProduccion;
import unab.com.Stock;


public class ModificaPedido extends HttpServlet
{

    public ModificaPedido()
    {
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException
        {
            
            String confirmacion = httpservletrequest.getParameter("confirmacion");
            String opcion = httpservletrequest.getParameter("Enviar");
      		String enviara = "";
	      	if (opcion.equals("Enviar"))
	          { 
	          enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaConfirmarPedido.jsp&titulo=Pedidos para Confirmar";
	          
	            		        
				CabezaPedido cabezaPedido = new CabezaPedido();
				cabezaPedido.setNumeroPedido(httpservletrequest.getParameter("numeropedido"));
				cabezaPedido.setNombreCliente(httpservletrequest.getParameter("nombre")+" "+httpservletrequest.getParameter("apellido"));
				cabezaPedido.setFechaPedido(httpservletrequest.getParameter("fecha"));
				cabezaPedido.setHoraPedido(httpservletrequest.getParameter("hora"));
				cabezaPedido.setPrecioTotalPedido(httpservletrequest.getParameter("total"));
				cabezaPedido.setConfirmacionPedido(confirmacion);
				cabezaPedido.setObservacionPedido(httpservletrequest.getParameter("comentario"));
				cabezaPedido.modificar();
							
			if (confirmacion.equals("C"))
	        {
			
				DetallePedido detallePedido = new DetallePedido();
				detallePedido.setNumeroPedido(httpservletrequest.getParameter("numeropedido"));
	  			detallePedido.eliminar();
				
				int i = Integer.parseInt(httpservletrequest.getParameter("ultimafilaproducto"));
        		for(int j = 1; j < i; j++)
        		{
				
				  detallePedido.setNumeroPedido(httpservletrequest.getParameter("numeropedido"));
				  detallePedido.setCodigoProducto(httpservletrequest.getParameter("producto" + j));
				  detallePedido.setPrecioProducto(httpservletrequest.getParameter("precioproducto" + j));
				  detallePedido.setCantidadProducto(httpservletrequest.getParameter("cantidadproducto" + j));
				  detallePedido.grabar();
				}
			
			DespachoPedido despachoPedido = new DespachoPedido();
			despachoPedido.setNumeroPedido(httpservletrequest.getParameter("numeropedido"));
			despachoPedido.setDireccionDespacho(httpservletrequest.getParameter("direcciondespacho")); 
			despachoPedido.setFechaEntregaDespacho(httpservletrequest.getParameter("fechaentrega"));
			despachoPedido.setHoraEntregaDespacho(httpservletrequest.getParameter("horaentrega"));
			despachoPedido.modificar();
			
			ConfirmacionPedido confirmacionPedido = new ConfirmacionPedido();
			confirmacionPedido.setNumeroPedido(httpservletrequest.getParameter("numeropedido"));
			confirmacionPedido.setNombreCliente(httpservletrequest.getParameter("nombre"));
			confirmacionPedido.setApellidoCliente(httpservletrequest.getParameter("apellido"));
			confirmacionPedido.setDireccionCliente(httpservletrequest.getParameter("direccion"));
			confirmacionPedido.setTelefonoCliente(httpservletrequest.getParameter("telefono"));
			confirmacionPedido.modificar();
	          
	        
	        	
	        int filai = Integer.parseInt(httpservletrequest.getParameter("ultimafilaproducto"));
        	for(int k = 1; k < filai; k++)
        	{
        	int filaj = Integer.parseInt(httpservletrequest.getParameter("ultimafila"+k));
        	for(int j = 1; j <= filaj; j++)
        	{
        	Stock stock = new Stock();
			stock.setCodigoProducto(httpservletrequest.getParameter("insumo"+k+""+j));
			if (stock.buscar()){
				    
			String stockdisponible = String.valueOf(Float.parseFloat(stock.getStockDisponible())-Float.parseFloat(httpservletrequest.getParameter("cantidadinsumo"+k+""+j)));
			stock.setStockDisponible(stockdisponible);
			String stockcomprometido = String.valueOf(Float.parseFloat(stock.getStockComprometido())+Float.parseFloat(httpservletrequest.getParameter("cantidadinsumo"+k+""+j)));
			stock.setStockComprometido(stockcomprometido);
			stock.modificar();
				}
        	  }
        	}
        		
			int h = Integer.parseInt(httpservletrequest.getParameter("ultimafilaproducto"));
        	for(int j = 1; j < h; j++)
        	{
        		
			OrdenFabricacion ordenFabricacion = new OrdenFabricacion();
			ordenFabricacion.setCodigoOrdenFabricacion(httpservletrequest.getParameter("numeropedido")+"-"+String.valueOf(j));
			ordenFabricacion.setFechaIngresoOrdenFabricacion(new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date()));
			ordenFabricacion.setHoraIngresoOrdenFabricacion(new java.text.SimpleDateFormat("hh:mm:ss").format(new java.util.Date()));
			ordenFabricacion.setNumeroPedido(httpservletrequest.getParameter("numeropedido")); 
			ordenFabricacion.setCodigoProducto(httpservletrequest.getParameter("producto"+j));
			ordenFabricacion.setCantidadProducto(httpservletrequest.getParameter("cantidadproducto"+j));
			ordenFabricacion.grabar();
        	
        	ProgramaProduccion programaProduccion= new ProgramaProduccion();
			programaProduccion.setCodigoOrdenFabricacion(httpservletrequest.getParameter("numeropedido")+"-"+String.valueOf(j));
			programaProduccion.setFechaProgramaProduccion(new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date()));
			programaProduccion.setHoraProgramaProduccion(new java.text.SimpleDateFormat("hh:mm:ss").format(new java.util.Date()));
			programaProduccion.setCodigoProducto(httpservletrequest.getParameter("producto"+j)); 
			
			ProductoLinea productoLinea = new ProductoLinea();
			productoLinea.setCodigoProducto(httpservletrequest.getParameter("producto"+j));
			if (productoLinea.buscar())
			  {
				String lineaproduccion = productoLinea.getCodigoLineaProduccion();
				programaProduccion.setCodigoLineaProduccion(lineaproduccion);
			  }
			
			
			
			programaProduccion.setCantidadProgramada(httpservletrequest.getParameter("cantidadproducto"+j));
			programaProduccion.setCantidadFabricada("0");
			programaProduccion.setSaldoPorFabricar(httpservletrequest.getParameter("cantidadproducto"+j));
			programaProduccion.setEstadoOrdenFabricacion("A");
			programaProduccion.grabar();
        	}
	        }
	        
	          } 
	          else 
	            { 
	            if (opcion.equals("Volver"))
	              { 
	              enviara = "http://localhost:8080/prueba/jsp/UsoSistema.jsp?destino=ListaPedido.jsp&titulo=Listado Pedidos";
	              } 
	              
	             }             
            
            
			
			
			
			//HttpSession session = request.getSession();
			//session.invalidate();				       
		httpservletresponse.sendRedirect(enviara);	
        //RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/jsp/Fin.jsp");
        //requestdispatcher.forward(httpservletrequest, httpservletresponse);
    }
}