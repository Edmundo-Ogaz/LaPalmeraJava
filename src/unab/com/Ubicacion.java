package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ubicacion {
   private String codigoProducto = "";
   private String codigoBodega = "";
   private String fechaVencimiento = "";
   private String tipoProducto = "";
   private String fechaIngreso = "";
   private String horaIngreso = "";
   private String cantidad = "";
   private String codigoUnidadMedida = "";
   private String observacion = "";

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

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public void setObservacion(String var1) {
      this.observacion = var1;
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

   public void grabar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "insert into Ubicacion values (";
            var6 = var6 + "'" + this.codigoProducto + "',";
            var6 = var6 + "'" + this.codigoBodega + "',";
            var6 = var6 + "'" + this.fechaIngreso + "',";
            var6 = var6 + "'" + this.horaIngreso + "',";
            var6 = var6 + "'" + this.fechaVencimiento + "',";
            var6 = var6 + "'" + this.tipoProducto + "',";
            var6 = var6 + this.cantidad + ",";
            var6 = var6 + "'" + this.codigoUnidadMedida + "',";
            var6 = var6 + "'" + this.observacion + "')";
            System.out.println(var6);
            int var7 = var5.executeUpdate(var6);
            if (var7 == 1) {
               System.out.println("OK");
            }

            var5.close();
            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }

   public void modificar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "update Ubicacion set ";
            var6 = var6 + "codigoproducto = '" + this.codigoProducto + "', ";
            var6 = var6 + "codigobodega = '" + this.codigoBodega + "', ";
            var6 = var6 + "fechaingreso = " + "'" + this.fechaIngreso + "', ";
            var6 = var6 + "horaingreso = " + "'" + this.horaIngreso + "', ";
            var6 = var6 + "fechavencimiento = " + "'" + this.fechaVencimiento + "', ";
            var6 = var6 + "tipoProducto= " + "'" + this.tipoProducto + "', ";
            var6 = var6 + "cantidad = " + this.cantidad + ", ";
            var6 = var6 + "codigoUnidadMedida = " + "'" + this.codigoUnidadMedida + "', ";
            var6 = var6 + "observacionubicacion = " + "'" + this.observacion + "' ";
            var6 = var6 + "where codigoproducto = '" + this.codigoProducto + "'";
            var6 = var6 + " and codigobodega = '" + this.codigoBodega + "'";
            var6 = var6 + " and fechaingreso ='" + this.fechaIngreso + "'";
            var6 = var6 + " and horaingreso ='" + this.horaIngreso + "'";
            var6 = var6 + " and fechavencimiento ='" + this.fechaVencimiento + "'";
            System.out.println(var6);
            int var7 = var5.executeUpdate(var6);
            if (var7 == 1) {
               System.out.println("OK");
            }

            var5.close();
            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }

   public void eliminar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "delete from ubicacion where ";
            var6 = var6 + "codigoproducto = '" + this.codigoProducto + "'";
            var6 = var6 + "and codigobodega = '" + this.codigoBodega + "'";
            var6 = var6 + "and fechaIngreso = '" + this.fechaIngreso + "'";
            var6 = var6 + "and horaIngreso = '" + this.horaIngreso + "'";
            var6 = var6 + "and fechaVencimiento = '" + this.fechaVencimiento + "'";
            System.out.println(var6);
            int var7 = var5.executeUpdate(var6);
            if (var7 == 1) {
               System.out.println("OK");
            }

            var5.close();
            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }

   public boolean buscar() {
      boolean var1 = false;
      String var2 = "root";
      String var3 = "";
      String var4 = "jdbc:mysql://localhost/lapalmera2";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from ubicacion where ";
            var7 = var7 + "codigoproducto = '" + this.codigoProducto + "'";
            var7 = var7 + "and codigobodega = '" + this.codigoBodega + "'";
            var7 = var7 + "and fechaIngreso = '" + this.fechaIngreso + "'";
            var7 = var7 + "and horaIngreso = '" + this.horaIngreso + "'";
            var7 = var7 + "and fechavencimiento = '" + this.fechaVencimiento + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoProducto = var8.getString(1);
               this.codigoBodega = var8.getString(2);
               this.fechaIngreso = var8.getString(3);
               this.horaIngreso = var8.getString(4);
               this.fechaVencimiento = var8.getString(5);
               this.tipoProducto = var8.getString(6);
               this.cantidad = var8.getString(7);
               this.codigoUnidadMedida = var8.getString(8);
               this.observacion = var8.getString(9);
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
