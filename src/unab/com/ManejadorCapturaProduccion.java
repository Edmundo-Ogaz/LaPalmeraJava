package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorCapturaProduccion {
   private String correlativoProduccion = "";
   private String codigoOrdenFabricacion = "";
   private String fechaCapturaProduccion = "";
   private String horaCapturaProduccion = "";
   private String codigoProducto = "";
   private String cantidadProducto = "";
   private String observacion = "";

   public void setCorrelativoProduccion(String var1) {
      this.correlativoProduccion = var1;
   }

   public void setCodigoOrdenFabricacion(String var1) {
      this.codigoOrdenFabricacion = var1;
   }

   public void setFechaCapturaProduccion(String var1) {
      this.fechaCapturaProduccion = var1;
   }

   public void setHoraCapturaProduccion(String var1) {
      this.horaCapturaProduccion = var1;
   }

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCantidadProducto(String var1) {
      this.cantidadProducto = var1;
   }

   public void setObservacion(String var1) {
      this.observacion = var1;
   }

   public String getCorrelativoProduccion() {
      return this.correlativoProduccion;
   }

   public String getCodigoOrdenFabricacion() {
      return this.codigoOrdenFabricacion;
   }

   public String getFechaCapturaProduccion() {
      return this.fechaCapturaProduccion;
   }

   public String getHoraCapturaProduccion() {
      return this.horaCapturaProduccion;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCantidadProducto() {
      return this.cantidadProducto;
   }

   public String getObservacion() {
      return this.observacion;
   }

   public ArrayList consultar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "select * from CapturaProduccion where 1 = 1 ";
            if (!this.correlativoProduccion.equals("")) {
               var7 = var7 + "     and correlativoProduccion = " + this.correlativoProduccion;
            }

            if (!this.codigoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and codigoOrdenFabricacion = '" + this.codigoOrdenFabricacion + "'";
            }

            if (!this.fechaCapturaProduccion.equals("")) {
               var7 = var7 + "     and fechaCapturaProduccion = '" + this.fechaCapturaProduccion + "'";
            }

            if (!this.horaCapturaProduccion.equals("")) {
               var7 = var7 + "     and horaCapturaProduccion = '" + this.horaCapturaProduccion + "'";
            }

            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.cantidadProducto.equals("")) {
               var7 = var7 + "     and cantidadProducto = '" + this.cantidadProducto + "'";
            }

            if (!this.observacion.equals("")) {
               var7 = var7 + "     and observacion = '" + this.observacion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               CapturaProduccion var9 = new CapturaProduccion();
               var9.setCorrelativoProduccion(var8.getString(1));
               var9.setCodigoOrdenFabricacion(var8.getString(2));
               var9.setFechaCapturaProduccion(var8.getString(3));
               var9.setHoraCapturaProduccion(var8.getString(4));
               var9.setCodigoProducto(var8.getString(5));
               var9.setCantidadProducto(var8.getString(6));
               var9.setObservacion(var8.getString(7));
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
