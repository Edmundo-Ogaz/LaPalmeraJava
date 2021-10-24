package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CapturaProduccion {
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

   public void grabar() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "insert into CapturaProduccion(codigoOrdenFabricacion,fechaCapturaProduccion,horaCapturaProduccion,codigoProducto,cantidadProducto,observacion) values (";
            var6 = var6 + "'" + this.codigoOrdenFabricacion + "',";
            var6 = var6 + "'" + this.fechaCapturaProduccion + "',";
            var6 = var6 + "'" + this.horaCapturaProduccion + "',";
            var6 = var6 + "'" + this.codigoProducto + "',";
            var6 = var6 + "'" + this.cantidadProducto + "',";
            var6 = var6 + "'" + this.observacion + "')";
            int var7 = var5.executeUpdate(var6);
            if (var7 == 1) {
               var5.close();
            }

            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }

   public boolean buscar() {
      boolean var1 = false;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from CapturaProduccion where correlativoProduccion = " + this.correlativoProduccion + "";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.correlativoProduccion = var8.getString(1);
               this.codigoOrdenFabricacion = var8.getString(2);
               this.fechaCapturaProduccion = var8.getString(3);
               this.horaCapturaProduccion = var8.getString(4);
               this.codigoProducto = var8.getString(5);
               this.cantidadProducto = var8.getString(6);
               this.observacion = var8.getString(7);
               var1 = true;
            }

            var8.close();
            var6.close();
            var5.close();
         }
      } catch (Exception var9) {
         System.out.println(var9);
      }

      return var1;
   }

   public String buscarUltimo() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "select * from capturaproduccion";
            System.out.println(var6);
            ResultSet var7 = var5.executeQuery(var6);

            while(var7.next()) {
               System.out.println("Lo encontro");
               this.correlativoProduccion = var7.getString(1);
               System.out.println(this.correlativoProduccion);
            }

            var7.close();
            var5.close();
            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

      return this.correlativoProduccion;
   }
}
