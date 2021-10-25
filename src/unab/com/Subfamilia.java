package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Subfamilia {
   private String codigoSubfamilia = "";
   private String nombreSubfamilia = "";
   private String codigoFamilia = "";

   public void setCodigoSubfamilia(String var1) {
      this.codigoSubfamilia = var1;
   }

   public void setNombreSubfamilia(String var1) {
      this.nombreSubfamilia = var1;
   }

   public void setCodigoFamilia(String var1) {
      this.codigoFamilia = var1;
   }

   public String getCodigoSubfamilia() {
      return this.codigoSubfamilia;
   }

   public String getNombreSubfamilia() {
      return this.nombreSubfamilia;
   }

   public String getCodigoFamilia() {
      return this.codigoFamilia;
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
            String var6 = "insert into subfamilia values (";
            var6 = var6 + "'" + this.codigoSubfamilia + "',";
            var6 = var6 + "'" + this.nombreSubfamilia + "',";
            var6 = var6 + "'" + this.codigoFamilia + "')";
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
            String var6 = "update subfamilia set ";
            var6 = var6 + "codigosubfamilia = " + "'" + this.codigoSubfamilia + "', ";
            var6 = var6 + "nombresubfamilia = " + "'" + this.nombreSubfamilia + "', ";
            var6 = var6 + "codigofamilia = " + "'" + this.codigoFamilia + "' where codigosubfamilia = '" + this.codigoSubfamilia + "'";
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
            String var6 = "delete from subfamilia where ";
            var6 = var6 + "codigosubfamilia = '" + this.codigoSubfamilia + "'";
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
            String var7 = "select * from subfamilia where codigosubfamilia = '" + this.codigoSubfamilia + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoSubfamilia = var8.getString(1);
               this.nombreSubfamilia = var8.getString(2);
               this.codigoFamilia = var8.getString(3);
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
