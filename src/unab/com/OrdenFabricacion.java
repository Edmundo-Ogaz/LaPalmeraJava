package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrdenFabricacion {
   private String codigoOrdenFabricacion = "";
   private String fechaIngresoOrdenFabricacion = "";
   private String horaIngresoOrdenFabricacion = "";
   private String numeroPedido = "";
   private String codigoProducto = "";
   private String cantidadProducto = "";

   public void setCodigoOrdenFabricacion(String var1) {
      this.codigoOrdenFabricacion = var1;
   }

   public void setFechaIngresoOrdenFabricacion(String var1) {
      this.fechaIngresoOrdenFabricacion = var1;
   }

   public void setHoraIngresoOrdenFabricacion(String var1) {
      this.horaIngresoOrdenFabricacion = var1;
   }

   public void setNumeroPedido(String var1) {
      this.numeroPedido = var1;
   }

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCantidadProducto(String var1) {
      this.cantidadProducto = var1;
   }

   public String getCodigoOrdenFabricacion() {
      return this.codigoOrdenFabricacion;
   }

   public String getFechaIngresoOrdenFabricacion() {
      return this.fechaIngresoOrdenFabricacion;
   }

   public String getHoraIngresoOrdenFabricacion() {
      return this.horaIngresoOrdenFabricacion;
   }

   public String getNumeroPedido() {
      return this.numeroPedido;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCantidadProducto() {
      return this.cantidadProducto;
   }

   public int grabar() {
      int var1 = 0;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "insert into OrdenFabricacion values (";
            var7 = var7 + "'" + this.codigoOrdenFabricacion + "',";
            var7 = var7 + "'" + this.fechaIngresoOrdenFabricacion + "',";
            var7 = var7 + "'" + this.horaIngresoOrdenFabricacion + "',";
            var7 = var7 + this.numeroPedido + ",";
            var7 = var7 + "'" + this.codigoProducto + "',";
            var7 = var7 + this.cantidadProducto + ")";
            System.out.println(var7);
            var1 = var6.executeUpdate(var7);
            if (var1 == 1) {
               System.out.println("OK");
            }

            var6.close();
            var5.close();
         }

         return var1;
      } catch (Exception var8) {
         System.out.println(var8);
         return var1;
      }
   }

   public int modificar() {
      int var1 = 0;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "update OrdenFabricacion set ";
            var7 = var7 + "codigoordenfabricacion = " + "'" + this.codigoOrdenFabricacion + "', ";
            var7 = var7 + "fechaIngresoOrdenFabricacion = " + "'" + this.fechaIngresoOrdenFabricacion + "', ";
            var7 = var7 + "horaIngresoOrdenFabricacion = " + "'" + this.horaIngresoOrdenFabricacion + "', ";
            var7 = var7 + "numeroPedido = " + "" + this.numeroPedido + ", ";
            var7 = var7 + "codigoProducto = " + "'" + this.codigoProducto + "', ";
            var7 = var7 + "cantidadProducto = " + "" + this.cantidadProducto + ", ";
            var7 = var7 + " where codigoordenfabricacion = '" + this.codigoOrdenFabricacion + "'";
            System.out.println(var7);
            var1 = var6.executeUpdate(var7);
            if (var1 == 1) {
               System.out.println("OK");
            }

            var6.close();
            var5.close();
         }

         return var1;
      } catch (Exception var8) {
         System.out.println(var8);
         return var1;
      }
   }

   public int eliminar() {
      int var1 = 0;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "delete from OrdenFabricacion where ";
            var7 = var7 + "codigoordenfabricacion = '" + this.codigoOrdenFabricacion + "'";
            System.out.println(var7);
            var1 = var6.executeUpdate(var7);
            if (var1 == 1) {
               System.out.println("OK");
            }

            var6.close();
            var5.close();
         }

         return var1;
      } catch (Exception var8) {
         System.out.println(var8);
         return var1;
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
            String var7 = "select * from ordenfabricacion where codigoordenfabricacion = '" + this.codigoOrdenFabricacion + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoOrdenFabricacion = var8.getString(1);
               this.fechaIngresoOrdenFabricacion = var8.getString(2);
               this.horaIngresoOrdenFabricacion = var8.getString(3);
               this.numeroPedido = var8.getString(4);
               this.codigoProducto = var8.getString(5);
               this.cantidadProducto = var8.getString(6);
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
}
