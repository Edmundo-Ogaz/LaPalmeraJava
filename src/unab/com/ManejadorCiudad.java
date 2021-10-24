package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorCiudad {
   private String codigoCiudad = "";
   private String nombreCiudad = "";
   private String codigoRegion = "";

   public void setCodigoCiudad(String var1) {
      this.codigoCiudad = var1;
   }

   public void setNombreCiudad(String var1) {
      this.nombreCiudad = var1;
   }

   public void setCodigoRegion(String var1) {
      this.codigoRegion = var1;
   }

   public String getCodigoCiudad() {
      return this.codigoCiudad;
   }

   public String getNombreCiudad() {
      return this.nombreCiudad;
   }

   public String getCodigoRegion() {
      return this.codigoRegion;
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
            String var7 = "select * from Ciudad where 1 = 1 ";
            if (!this.codigoCiudad.equals("")) {
               var7 = var7 + "     and codigoCiudad = '" + this.codigoCiudad + "'";
            }

            if (!this.nombreCiudad.equals("")) {
               var7 = var7 + "     and nombreCiudad = '" + this.nombreCiudad + "'";
            }

            if (!this.codigoRegion.equals("")) {
               var7 = var7 + "     and codigoRegion = '" + this.codigoRegion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Ciudad var9 = new Ciudad();
               var9.setCodigoCiudad(var8.getString(1));
               var9.setNombreCiudad(var8.getString(2));
               var9.setCodigoRegion(var8.getString(3));
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
