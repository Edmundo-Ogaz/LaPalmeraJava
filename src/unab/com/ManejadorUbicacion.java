package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorUbicacion {
   private String codigoProducto = "";
   private String codigoBodega = "";
   private String fechaIngreso = "";
   private String horaIngreso = "";
   private String fechaVencimiento = "";
   private String tipoProducto = "";
   private String cantidad = "";
   private String codigoUnidadMedida = "";
   private String observacion = "";
   private String fechaIngresoInicio = "";
   private String fechaIngresoTermino = "";
   private String fechaVencimientoInicio = "";
   private String fechaVencimientoTermino = "";

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoBodega(String var1) {
      this.codigoBodega = var1;
   }

   public void setFechaVencimiento(String var1) {
      this.fechaVencimiento = var1;
   }

   public void setTipoProducto(String var1) {
      this.tipoProducto = var1;
   }

   public void setFechaIngreso(String var1) {
      this.fechaIngreso = var1;
   }

   public void setHoraIngreso(String var1) {
      this.horaIngreso = var1;
   }

   public void setCantidad(String var1) {
      this.cantidad = var1;
   }

   public void setcodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public void setObservacion(String var1) {
      this.observacion = var1;
   }

   public void setFechaIngresoInicio(String var1) {
      this.fechaIngresoInicio = var1;
   }

   public void setFechaIngresoTermino(String var1) {
      this.fechaIngresoTermino = var1;
   }

   public void setFechaVencimientoInicio(String var1) {
      this.fechaVencimientoInicio = var1;
   }

   public void setFechaVencimientoTermino(String var1) {
      this.fechaVencimientoTermino = var1;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoBodega() {
      return this.codigoBodega;
   }

   public String getFechaVencimiento() {
      return this.fechaVencimiento;
   }

   public String getTipoProducto() {
      return this.tipoProducto;
   }

   public String getFechaIngreso() {
      return this.fechaIngreso;
   }

   public String getHoraIngreso() {
      return this.horaIngreso;
   }

   public String getCantidad() {
      return this.cantidad;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
   }

   public String getObservacion() {
      return this.observacion;
   }

   public String getFechaIngresoInicio() {
      return this.fechaIngresoInicio;
   }

   public String getFechaIngresoTermino() {
      return this.fechaIngresoTermino;
   }

   public String getFechaVencimientoInicio() {
      return this.fechaVencimientoInicio;
   }

   public String getFechaVencimientoTermino() {
      return this.fechaVencimientoTermino;
   }

   public ArrayList consultar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "select * from Ubicacion where 1 = 1 ";
            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.codigoBodega.equals("")) {
               var7 = var7 + "     and codigoBodega = '" + this.codigoBodega + "'";
            }

            if (!this.fechaIngreso.equals("")) {
               var7 = var7 + "     and fechaIngreso = '" + this.fechaIngreso + "'";
            }

            if (!this.horaIngreso.equals("")) {
               var7 = var7 + "     and horaIngreso = '" + this.horaIngreso + "'";
            }

            if (!this.fechaVencimiento.equals("")) {
               var7 = var7 + "     and fechaVencimiento = '" + this.fechaVencimiento + "'";
            }

            if (!this.tipoProducto.equals("")) {
               var7 = var7 + "     and tipoProducto= '" + this.tipoProducto + "'";
            }

            if (!this.cantidad.equals("")) {
               var7 = var7 + "     and cantidad = " + this.cantidad + "'";
            }

            if (!this.codigoUnidadMedida.equals("")) {
               var7 = var7 + "     and codigounidadmedida = '" + this.codigoUnidadMedida + "'";
            }

            if (!this.observacion.equals("")) {
               var7 = var7 + "     and observacionubicacion = '" + this.observacion + "'";
            }

            if (!this.fechaIngresoInicio.equals("") || !this.fechaIngresoTermino.equals("")) {
               var7 = var7 + "     and fechaingreso >= '" + this.fechaIngresoInicio + "' ";
               var7 = var7 + "and fechaingreso <= '" + this.fechaIngresoTermino + "'";
            }

            if (!this.fechaVencimientoInicio.equals("") || !this.fechaVencimientoTermino.equals("")) {
               var7 = var7 + "and fechaVencimiento >= '" + this.fechaVencimientoInicio + "' ";
               var7 = var7 + "and fechaVencimiento <= '" + this.fechaVencimientoTermino + "'";
            }

            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Ubicacion var9 = new Ubicacion();
               var9.setCodigoProducto(var8.getString(1));
               var9.setCodigoBodega(var8.getString(2));
               var9.setFechaIngreso(var8.getString(3));
               var9.setHoraIngreso(var8.getString(4));
               var9.setFechaVencimiento(var8.getString(5));
               var9.setTipoProducto(var8.getString(6));
               var9.setCantidad(var8.getString(7));
               var9.setCodigoUnidadMedida(var8.getString(8));
               var9.setObservacion(var8.getString(9));
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

   public ArrayList consultarPorFechaVencimiento() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "select * from Ubicacion where 1 = 1 ";
            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.codigoBodega.equals("")) {
               var7 = var7 + "     and codigoBodega = '" + this.codigoBodega + "'";
            }

            if (!this.fechaIngreso.equals("")) {
               var7 = var7 + "     and fechaIngreso = '" + this.fechaIngreso + "'";
            }

            if (!this.fechaVencimiento.equals("")) {
               var7 = var7 + "     and fechaVencimiento = '" + this.fechaVencimiento + "'";
            }

            if (!this.tipoProducto.equals("")) {
               var7 = var7 + "     and tipoProducto= '" + this.tipoProducto + "'";
            }

            if (!this.cantidad.equals("")) {
               var7 = var7 + "     and cantidad = " + this.cantidad + "'";
            }

            if (!this.codigoUnidadMedida.equals("")) {
               var7 = var7 + "     and codigounidadmedida = '" + this.codigoUnidadMedida + "'";
            }

            if (!this.observacion.equals("")) {
               var7 = var7 + "     and observacionubicacion = '" + this.observacion + "'";
            }

            if (!this.fechaIngresoInicio.equals("") || !this.fechaIngresoTermino.equals("")) {
               var7 = var7 + "     and fechaingreso >= '" + this.fechaIngresoInicio + "' ";
               var7 = var7 + "and fechaingreso <= '" + this.fechaIngresoTermino + "'";
            }

            if (!this.fechaVencimientoInicio.equals("") || !this.fechaVencimientoTermino.equals("")) {
               var7 = var7 + "and fechaVencimiento >= '" + this.fechaVencimientoInicio + "' ";
               var7 = var7 + "and fechaVencimiento <= '" + this.fechaVencimientoTermino + "'";
            }

            var7 = var7 + "     order by fechaVencimiento";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Ubicacion var9 = new Ubicacion();
               var9.setCodigoProducto(var8.getString(1));
               var9.setCodigoBodega(var8.getString(2));
               var9.setFechaIngreso(var8.getString(3));
               var9.setHoraIngreso(var8.getString(4));
               var9.setFechaVencimiento(var8.getString(5));
               var9.setTipoProducto(var8.getString(6));
               var9.setCantidad(var8.getString(7));
               var9.setCodigoUnidadMedida(var8.getString(8));
               var9.setObservacion(var8.getString(9));
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
