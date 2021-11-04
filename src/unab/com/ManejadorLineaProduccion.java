package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorLineaProduccion {
   private String codigoLineaProduccion = "";
   private String nombreLineaProduccion = "";

   public void setCodigoLineaProduccion(String var1) {
      this.codigoLineaProduccion = var1;
   }

   public void setNombreLineaProduccion(String var1) {
      this.nombreLineaProduccion = var1;
   }

   public String getCodigoLineaProduccion() {
      return this.codigoLineaProduccion;
   }

   public String getNombreLineaProduccion() {
      return this.nombreLineaProduccion;
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
            String var7 = "select * from LineaProduccion where 1 = 1 ";
            if (!this.codigoLineaProduccion.equals("")) {
               var7 = var7 + "     and codigoLineaProduccion = '" + this.codigoLineaProduccion + "'";
            }

            if (!this.nombreLineaProduccion.equals("")) {
               var7 = var7 + "     and nombreLineaProduccion = '" + this.nombreLineaProduccion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               LineaProduccion var9 = new LineaProduccion();
               var9.setCodigoLineaProduccion(var8.getString(1));
               var9.setNombreLineaProduccion(var8.getString(2));
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
