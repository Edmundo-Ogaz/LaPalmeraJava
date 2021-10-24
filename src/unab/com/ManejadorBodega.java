package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorBodega {
   private String codigoBodega = "";
   private String nombreBodega = "";

   public void setCodigoBodega(String var1) {
      this.codigoBodega = var1;
   }

   public void setNombreBodega(String var1) {
      this.nombreBodega = var1;
   }

   public String getCodigoBodega() {
      return this.codigoBodega;
   }

   public String getNombreBodega() {
      return this.nombreBodega;
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
            String var7 = "select * from Bodega where 1 = 1 ";
            if (!this.codigoBodega.equals("")) {
               var7 = var7 + "     and codigoBodega = '" + this.codigoBodega + "'";
            }

            if (!this.nombreBodega.equals("")) {
               var7 = var7 + "     and nombreBodega = '" + this.nombreBodega + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Bodega var9 = new Bodega();
               var9.setCodigoBodega(var8.getString(1));
               var9.setNombreBodega(var8.getString(2));
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
