package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorProgramaProduccion {
   private String codigoOrdenFabricacion = "";
   private String fechaProgramaProduccion = "";
   private String horaProgramaProduccion = "";
   private String codigoProducto = "";
   private String codigoLineaProduccion = "";
   private String cantidadProgramada = "";
   private String cantidadFabricada = "";
   private String saldoPorFabricar = "";
   private String estadoOrdenFabricacion = "";
   private String numeroPedido = "";
   private String fechaPedido = "";
   private String fechaInicio = "";
   private String fechaTermino = "";

   public void setCodigoOrdenFabricacion(String var1) {
      this.codigoOrdenFabricacion = var1;
   }

   public void setFechaProgramaProduccion(String var1) {
      this.fechaProgramaProduccion = var1;
   }

   public void setHoraProgramaProduccion(String var1) {
      this.horaProgramaProduccion = var1;
   }

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoLineaProduccion(String var1) {
      this.codigoLineaProduccion = var1;
   }

   public void setCantidadProgramada(String var1) {
      this.cantidadProgramada = var1;
   }

   public void setCantidadFabricada(String var1) {
      this.cantidadFabricada = var1;
   }

   public void setSaldoPorFabricar(String var1) {
      this.saldoPorFabricar = var1;
   }

   public void setEstadoOrdenFabricacion(String var1) {
      this.estadoOrdenFabricacion = var1;
   }

   public void setNumeroPedido(String var1) {
      this.numeroPedido = var1;
   }

   public void setFechaPedido(String var1) {
      this.fechaPedido = var1;
   }

   public void setFechaInicio(String var1) {
      this.fechaInicio = var1;
   }

   public void setFechaTermino(String var1) {
      this.fechaTermino = var1;
   }

   public String getCodigoOrdenFabricacion() {
      return this.codigoOrdenFabricacion;
   }

   public String getFechaProgramaProduccion() {
      return this.fechaProgramaProduccion;
   }

   public String getHoraProgramaProduccion() {
      return this.horaProgramaProduccion;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoLineaProduccion() {
      return this.codigoLineaProduccion;
   }

   public String getCantidadProgramada() {
      return this.cantidadProgramada;
   }

   public String getCantidadFabricada() {
      return this.cantidadFabricada;
   }

   public String getSaldoPorFabricar() {
      return this.saldoPorFabricar;
   }

   public String getEstadoOrdenFabricacion() {
      return this.estadoOrdenFabricacion;
   }

   public String getNumeroPedido() {
      return this.numeroPedido;
   }

   public String getFechaPedido() {
      return this.fechaPedido;
   }

   public String getFechaInicio() {
      return this.fechaInicio;
   }

   public String getFechaTermino() {
      return this.fechaTermino;
   }

   public ArrayList consultar() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "select * from ProgramaProduccion where 1 = 1 ";
            if (!this.codigoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and codigoOrdenFabricacion = '" + this.codigoOrdenFabricacion + "'";
            }

            if (!this.fechaProgramaProduccion.equals("")) {
               var7 = var7 + "     and fechaProgramaProduccion = '" + this.fechaProgramaProduccion + "'";
            }

            if (!this.horaProgramaProduccion.equals("")) {
               var7 = var7 + "     and horaProgramaProduccion = '" + this.horaProgramaProduccion + "'";
            }

            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.codigoLineaProduccion.equals("")) {
               var7 = var7 + "     and codigoLineaProduccion = '" + this.codigoLineaProduccion + "'";
            }

            if (!this.cantidadProgramada.equals("")) {
               var7 = var7 + "     and cantidadProgramada = " + this.cantidadProgramada;
            }

            if (!this.cantidadFabricada.equals("")) {
               var7 = var7 + "     and cantidadFabricada = " + this.cantidadFabricada;
            }

            if (!this.saldoPorFabricar.equals("")) {
               var7 = var7 + "     and saldoPorFabricar = " + this.saldoPorFabricar;
            }

            if (!this.estadoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and estadoOrdenFabricacion = '" + this.estadoOrdenFabricacion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               ProgramaProduccion var9 = new ProgramaProduccion();
               var9.setCodigoOrdenFabricacion(var8.getString(1));
               var9.setFechaProgramaProduccion(var8.getString(2));
               var9.setHoraProgramaProduccion(var8.getString(3));
               var9.setCodigoProducto(var8.getString(4));
               var9.setCodigoLineaProduccion(var8.getString(5));
               var9.setCantidadProgramada(var8.getString(6));
               var9.setCantidadFabricada(var8.getString(7));
               var9.setSaldoPorFabricar(var8.getString(8));
               var9.setEstadoOrdenFabricacion(var8.getString(9));
               var5.add(var9);
            }

            var6.close();
            var4.close();
         }
      } catch (Exception var10) {
         System.out.println(var10);
      }

      return var5;
   }

   public ArrayList listarPorFecha() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "   select";
            var7 = var7 + "     programaproduccion.codigoOrdenFabricacion,";
            var7 = var7 + "     despachopedido.numeropedido,";
            var7 = var7 + "     despachopedido.fechaentregadespacho,";
            var7 = var7 + "     programaproduccion.codigoProducto,";
            var7 = var7 + "     programaproduccion.codigoLineaProduccion,";
            var7 = var7 + "     programaproduccion.cantidadProgramada,";
            var7 = var7 + "     programaproduccion.cantidadFabricada,";
            var7 = var7 + "     programaproduccion.saldoPorFabricar,";
            var7 = var7 + "     programaproduccion.estadoOrdenFabricacion";
            var7 = var7 + "     from ProgramaProduccion, OrdenFabricacion, DespachoPedido where ";
            var7 = var7 + "     ProgramaProduccion.codigoOrdenFabricacion = OrdenFabricacion.codigoOrdenFabricacion";
            var7 = var7 + "     and OrdenFabricacion.numeropedido = Despachopedido.numeropedido";
            if (!this.codigoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.codigoOrdenFabricacion = '" + this.codigoOrdenFabricacion + "'";
            }

            if (!this.fechaProgramaProduccion.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.fechaProgramaProduccion = '" + this.fechaProgramaProduccion + "'";
            }

            if (!this.horaProgramaProduccion.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.horaProgramaProduccion = '" + this.horaProgramaProduccion + "'";
            }

            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.codigoLineaProduccion.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.codigoLineaProduccion = '" + this.codigoLineaProduccion + "'";
            }

            if (!this.cantidadProgramada.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.cantidadProgramada = " + this.cantidadProgramada;
            }

            if (!this.cantidadFabricada.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.cantidadFabricada = " + this.cantidadFabricada;
            }

            if (!this.saldoPorFabricar.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.saldoPorFabricar = " + this.saldoPorFabricar;
            }

            if (!this.estadoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and ProgramaProduccion.estadoOrdenFabricacion = '" + this.estadoOrdenFabricacion + "'";
            }

            if (!this.fechaInicio.equals("") || !this.fechaTermino.equals("")) {
               var7 = var7 + "     and despachopedido.fechaentregadespacho >= '" + this.fechaInicio + "' and despachopedido.fechaentregadespacho <= '" + this.fechaTermino + "'";
            }

            var7 = var7 + "     order by despachopedido.fechaentregadespacho";
            var7 = var7 + "     , programaproduccion.horaprogramaproduccion";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               ProgramaProduccion var9 = new ProgramaProduccion();
               var9.setCodigoOrdenFabricacion(var8.getString(1));
               var9.setNumeroPedido(var8.getString(2));
               var9.setFechaPedido(var8.getString(3));
               var9.setCodigoProducto(var8.getString(4));
               var9.setCodigoLineaProduccion(var8.getString(5));
               var9.setCantidadProgramada(var8.getString(6));
               var9.setCantidadFabricada(var8.getString(7));
               var9.setSaldoPorFabricar(var8.getString(8));
               var9.setEstadoOrdenFabricacion(var8.getString(9));
               var5.add(var9);
            }

            var6.close();
            var4.close();
         }
      } catch (Exception var10) {
         System.out.println(var10);
      }

      return var5;
   }
}
