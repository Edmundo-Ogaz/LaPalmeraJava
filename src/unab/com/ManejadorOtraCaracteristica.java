package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorOtraCaracteristica {
   private String codigoOtraCaracteristica = "";
   private String nombreOtraCaracteristica = "";

   public void setCodigoOtraCaracteristica(String var1) {
      this.codigoOtraCaracteristica = var1;
   }

   public void setNombreOtraCaracteristica(String var1) {
      this.nombreOtraCaracteristica = var1;
   }

   public String getCodigoOtraCaracteristica() {
      return this.codigoOtraCaracteristica;
   }

   public String getNombreOtraCaracteristica() {
      return this.nombreOtraCaracteristica;
   }

   public ArrayList consultar() {
      ArrayList var1 = new ArrayList();
      String var2 = "root";
      String var3 = "";
      String var4 = "jdbc:mysql://localhost/lapalmera2";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from OtraCaracteristica where 1 = 1 ";
            if (!this.codigoOtraCaracteristica.equals("")) {
               var7 = var7 + "     and codigoOtraCaracteristica = '" + this.codigoOtraCaracteristica + "'";
            }

            if (!this.nombreOtraCaracteristica.equals("")) {
               var7 = var7 + "     and nombreOtraCaracteristica = '" + this.nombreOtraCaracteristica + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               OtraCaracteristica var9 = new OtraCaracteristica();
               var9.setCodigoOtraCaracteristica(var8.getString(1));
               var9.setNombreOtraCaracteristica(var8.getString(2));
               var1.add(var9);
            }
         }
      } catch (Exception var10) {
         System.out.println(var10);
      }

      return var1;
   }
}
