package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorRegion {
   private String codigoRegion = "";
   private String nombreRegion = "";

   public void setCodigoRegion(String var1) {
      this.codigoRegion = var1;
   }

   public void setNombreRegion(String var1) {
      this.nombreRegion = var1;
   }

   public String getCodigoRegion() {
      return this.codigoRegion;
   }

   public String getNombreRegion() {
      return this.nombreRegion;
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
            String var7 = "select * from Region where 1 = 1 ";
            if (!this.codigoRegion.equals("")) {
               var7 = var7 + "     and codigoRegion = " + "'" + this.codigoRegion + "'";
            }

            if (!this.nombreRegion.equals("")) {
               var7 = var7 + "     and nombreRegion = '" + this.nombreRegion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Region var9 = new Region();
               var9.setCodigoRegion(var8.getString(1));
               var9.setNombreRegion(var8.getString(2));
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
