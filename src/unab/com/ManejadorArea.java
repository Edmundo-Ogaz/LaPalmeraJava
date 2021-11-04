package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorArea {
   private String codigoArea = "";
   private String nombreArea = "";

   public void setCodigoArea(String var1) {
      this.codigoArea = var1;
   }

   public void setNombreArea(String var1) {
      this.nombreArea = var1;
   }

   public String getCodigoArea() {
      return this.codigoArea;
   }

   public String getNombreArea() {
      return this.nombreArea;
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
            String var7 = "select * from Area where 1 = 1 ";
            if (!this.codigoArea.equals("")) {
               var7 = var7 + "     and codigoArea = '" + this.codigoArea + "'";
            }

            if (!this.nombreArea.equals("")) {
               var7 = var7 + "     and nombreArea = '" + this.nombreArea + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Area var9 = new Area();
               var9.setCodigoArea(var8.getString(1));
               var9.setNombreArea(var8.getString(2));
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
