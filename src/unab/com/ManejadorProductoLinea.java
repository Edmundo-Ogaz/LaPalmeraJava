package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorProductoLinea {
   private String codigoProducto = "";
   private String codigoLineaProduccion = "";

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoLineaProduccion(String var1) {
      this.codigoLineaProduccion = var1;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoLineaProduccion() {
      return this.codigoLineaProduccion;
   }

   public ArrayList consultar() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "select * from ProductoLinea where 1 = 1 ";
            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.codigoLineaProduccion.equals("")) {
               var7 = var7 + "     and codigolineaProduccion = '" + this.codigoLineaProduccion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               ProductoLinea var9 = new ProductoLinea();
               var9.setCodigoProducto(var8.getString(1));
               var9.setCodigoLineaProduccion(var8.getString(2));
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
