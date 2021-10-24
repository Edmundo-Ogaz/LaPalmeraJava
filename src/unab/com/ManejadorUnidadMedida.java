package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorUnidadMedida {
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

   public ArrayList consultar() {
      ArrayList var1 = new ArrayList();
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from UnidadMedida where 1 = 1 ";
            if (!this.codigoUnidadMedida.equals("")) {
               var7 = var7 + "     and codigoUnidadMedida = '" + this.codigoUnidadMedida + "'";
            }

            if (!this.nombreUnidadMedida.equals("")) {
               var7 = var7 + "     and nombreUnidadMedida = " + "'" + this.nombreUnidadMedida + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               UnidadMedida var9 = new UnidadMedida();
               var9.setCodigoUnidadMedida(var8.getString(1));
               var9.setNombreUnidadMedida(var8.getString(2));
               var1.add(var9);
            }
         }
      } catch (Exception var10) {
         System.out.println(var10);
      }

      return var1;
   }
}
