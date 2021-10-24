package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ingrediente {
   private String codigoProducto = "";
   private String codigoInsumo = "";
   private String carga = "";
   private String cantidadInsumo = "";
   private String codigoUnidadMedida = "";

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoInsumo(String var1) {
      this.codigoInsumo = var1;
   }

   public void setCarga(String var1) {
      this.carga = var1;
   }

   public void setCantidadInsumo(String var1) {
      this.cantidadInsumo = var1;
   }

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoInsumo() {
      return this.codigoInsumo;
   }

   public String getCarga() {
      return this.carga;
   }

   public String getCantidadInsumo() {
      return this.cantidadInsumo;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
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
            String var6 = "insert into Ingrediente values (";
            var6 = var6 + "'" + this.codigoProducto + "',";
            var6 = var6 + "'" + this.codigoInsumo + "',";
            var6 = var6 + this.carga + ",";
            var6 = var6 + this.cantidadInsumo + ",";
            var6 = var6 + "'" + this.codigoUnidadMedida + "')";
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
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "update Ingrediente set ";
            var6 = var6 + "codigoproducto = " + "'" + this.codigoProducto + "', ";
            var6 = var6 + "codigoinsumo = " + "'" + this.codigoInsumo + "', ";
            var6 = var6 + "carga = " + this.carga + ", ";
            var6 = var6 + "cantidadinsumo = " + this.cantidadInsumo + ", ";
            var6 = var6 + "codigounidadmedida = " + "'" + this.codigoUnidadMedida + "'";
            var6 = var6 + " where codigoproducto = '" + this.codigoProducto + "'";
            var6 = var6 + " and codigoinsumo = '" + this.codigoInsumo + "'";
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
            String var6 = "delete from Ingrediente where ";
            var6 = var6 + "codigoproducto = '" + this.codigoProducto + "'";
            var6 = var6 + " and codigoinsumo = '" + this.codigoInsumo + "'";
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
            String var7 = "select * from ingrediente where ";
            var7 = var7 + " codigoproducto = '" + this.codigoProducto + "'";
            var7 = var7 + " and codigoinsumo = '" + this.codigoInsumo + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoProducto = var8.getString(1);
               this.codigoInsumo = var8.getString(2);
               this.carga = var8.getString(3);
               this.cantidadInsumo = var8.getString(4);
               this.codigoUnidadMedida = var8.getString(5);
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
