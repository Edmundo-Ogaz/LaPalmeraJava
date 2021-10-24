package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorCargo {
   private String codigoCargo = "";
   private String nombreCargo = "";

   public void setCodigoCargo(String var1) {
      this.codigoCargo = var1;
   }

   public void setNombreCargo(String var1) {
      this.nombreCargo = var1;
   }

   public String getCodigoCargo() {
      return this.codigoCargo;
   }

   public String getNombreCargo() {
      return this.nombreCargo;
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
            String var7 = "select * from Cargo where 1 = 1 ";
            if (!this.codigoCargo.equals("")) {
               var7 = var7 + "     and codigoCargo = '" + this.codigoCargo + "'";
            }

            if (!this.nombreCargo.equals("")) {
               var7 = var7 + "     and nombreCargo = '" + this.nombreCargo + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Cargo var9 = new Cargo();
               var9.setCodigoCargo(var8.getString(1));
               var9.setNombreCargo(var8.getString(2));
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
