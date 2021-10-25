package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorStock {
   private String codigoProducto = "";
   private String stockDisponible = "";
   private String stockComprometido = "";
   private String codigoUnidadMedida = "";

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setStockDisponible(String var1) {
      this.stockDisponible = var1;
   }

   public void setStockComprometido(String var1) {
      this.stockComprometido = var1;
   }

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getStockDisponible() {
      return this.stockDisponible;
   }

   public String getStockComprometido() {
      return this.stockComprometido;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
   }

   public ArrayList consultar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "select * from Stock where 1 = 1 ";
            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.stockDisponible.equals("")) {
               var7 = var7 + "     and stockdisponible = " + this.stockDisponible;
            }

            if (!this.stockComprometido.equals("")) {
               var7 = var7 + "     and stockComprometido = " + this.stockComprometido;
            }

            if (!this.codigoUnidadMedida.equals("")) {
               var7 = var7 + "     and codigoUnidadMedida = '" + this.codigoUnidadMedida + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Stock var9 = new Stock();
               var9.setCodigoProducto(var8.getString(1));
               var9.setStockDisponible(var8.getString(2));
               var9.setStockComprometido(var8.getString(3));
               var9.setCodigoUnidadMedida(var8.getString(4));
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
