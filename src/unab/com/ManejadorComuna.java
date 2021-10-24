package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorComuna {
   private String codigoComuna = "";
   private String nombreComuna = "";
   private String codigoCiudad = "";

   public void setCodigoComuna(String var1) {
      this.codigoComuna = var1;
   }

   public void setNombreComuna(String var1) {
      this.nombreComuna = var1;
   }

   public void setCodigoCiudad(String var1) {
      this.codigoCiudad = var1;
   }

   public String getCodigoComuna() {
      return this.codigoComuna;
   }

   public String getNombreComuna() {
      return this.nombreComuna;
   }

   public String getCodigoCiudad() {
      return this.codigoCiudad;
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
            String var7 = "select * from Comuna where 1 = 1 ";
            if (!this.codigoComuna.equals("")) {
               var7 = var7 + "     and codigoComuna = '" + this.codigoComuna + "'";
            }

            if (!this.nombreComuna.equals("")) {
               var7 = var7 + "     and nombreComuna = '" + this.nombreComuna + "'";
            }

            if (!this.codigoCiudad.equals("")) {
               var7 = var7 + "     and codigoCiudad = '" + this.codigoCiudad + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Comuna var9 = new Comuna();
               var9.setCodigoComuna(var8.getString(1));
               var9.setNombreComuna(var8.getString(2));
               var9.setCodigoCiudad(var8.getString(3));
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
