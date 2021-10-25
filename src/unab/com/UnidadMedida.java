package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UnidadMedida {
   private String codigoUnidadMedida = "";
   private String nombreUnidadMedida = "";

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public void setNombreUnidadMedida(String var1) {
      this.nombreUnidadMedida = var1;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
   }

   public String getNombreUnidadMedida() {
      return this.nombreUnidadMedida;
   }

   public void grabar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "insert into unidadmedida values (";
            var6 = var6 + "'" + this.codigoUnidadMedida + "',";
            var6 = var6 + "'" + this.nombreUnidadMedida + "')";
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
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "update UnidadMedida set ";
            var6 = var6 + "codigounidadmedida = '" + this.codigoUnidadMedida + "', ";
            var6 = var6 + "nombreunidadmedida = " + "'" + this.nombreUnidadMedida + "' where codigounidadmedida = '" + this.codigoUnidadMedida + "'";
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
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "delete from unidadmedida where ";
            var6 = var6 + "codigounidadmedida = '" + this.codigoUnidadMedida + "'";
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
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from unidadmedida where codigounidadmedida = '" + this.codigoUnidadMedida + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoUnidadMedida = var8.getString(1);
               this.nombreUnidadMedida = var8.getString(2);
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
