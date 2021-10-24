package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insumo {
   private String codigoInsumo = "";
   private String nombreInsumo = "";
   private String codigoUnidadMedida = "";
   private String stockCriticoInsumo = "";
   private String pesoInsumo = "";
   private String observacionInsumo = "";

   public void setCodigoInsumo(String var1) {
      this.codigoInsumo = var1;
   }

   public void setNombreInsumo(String var1) {
      this.nombreInsumo = var1;
   }

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public void setStockCriticoInsumo(String var1) {
      this.stockCriticoInsumo = var1;
   }

   public void setPesoInsumo(String var1) {
      this.pesoInsumo = var1;
   }

   public void setObservacionInsumo(String var1) {
      this.observacionInsumo = var1;
   }

   public String getCodigoInsumo() {
      return this.codigoInsumo;
   }

   public String getNombreInsumo() {
      return this.nombreInsumo;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
   }

   public String getStockCriticoInsumo() {
      return this.stockCriticoInsumo;
   }

   public String getPesoInsumo() {
      return this.pesoInsumo;
   }

   public String getObservacionInsumo() {
      return this.observacionInsumo;
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
            String var6 = "insert into Insumo values (";
            var6 = var6 + "'" + this.codigoInsumo + "',";
            var6 = var6 + "'" + this.nombreInsumo + "',";
            var6 = var6 + "'" + this.codigoUnidadMedida + "',";
            var6 = var6 + this.stockCriticoInsumo + ",";
            var6 = var6 + this.pesoInsumo + ",";
            var6 = var6 + " null" + ",";
            var6 = var6 + " null" + ",";
            var6 = var6 + " null" + ",";
            var6 = var6 + " null" + ",";
            var6 = var6 + " null" + ",";
            var6 = var6 + "'" + this.observacionInsumo + "')";
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

   public void modificar() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "update insumo set ";
            var6 = var6 + "codigoinsumo = " + "'" + this.codigoInsumo + "', ";
            var6 = var6 + "nombreinsumo = " + "'" + this.nombreInsumo + "', ";
            var6 = var6 + "codigounidadmedida = " + "'" + this.codigoUnidadMedida + "', ";
            var6 = var6 + "stockcriticoinsumo = " + this.stockCriticoInsumo + ", ";
            var6 = var6 + "pesoinsumo = " + this.pesoInsumo + ", ";
            var6 = var6 + "observacion = " + "'" + this.observacionInsumo + "' where codigoinsumo = '" + this.codigoInsumo + "'";
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
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "delete from insumo where ";
            var6 = var6 + "codigoinsumo = " + "'" + this.codigoInsumo + "'";
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
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from insumo where codigoinsumo = '" + this.codigoInsumo + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoInsumo = var8.getString(1);
               this.nombreInsumo = var8.getString(2);
               this.codigoUnidadMedida = var8.getString(3);
               this.stockCriticoInsumo = var8.getString(4);
               this.pesoInsumo = var8.getString(5);
               this.observacionInsumo = var8.getString(11);
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
