package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorDetalleEntregaInsumo {
   private String correlativoEntregaInsumo = "";
   private String codigoInsumo = "";
   private String cantidadEntregaInsumo = "";
   private String codigoUnidadMedida = "";

   public void setCorrelativoEntregaInsumo(String var1) {
      this.correlativoEntregaInsumo = var1;
   }

   public void setCodigoInsumo(String var1) {
      this.codigoInsumo = var1;
   }

   public void setCantidadEntregaInsumo(String var1) {
      this.cantidadEntregaInsumo = var1;
   }

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public String getCorrelativoEntregaInsumo() {
      return this.correlativoEntregaInsumo;
   }

   public String getCodigoInsumo() {
      return this.codigoInsumo;
   }

   public String getCantidadEntregaInsumo() {
      return this.cantidadEntregaInsumo;
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
            String var7 = "select * from DetalleEntregaInsumo where 1 = 1 ";
            if (!this.correlativoEntregaInsumo.equals("")) {
               var7 = var7 + "     and correlativoEntregaInsumo = " + this.correlativoEntregaInsumo;
            }

            if (!this.codigoInsumo.equals("")) {
               var7 = var7 + "     and codigoInsumo = '" + this.codigoInsumo + "'";
            }

            if (!this.cantidadEntregaInsumo.equals("")) {
               var7 = var7 + "     and cantidadEntregaInsumo = " + this.cantidadEntregaInsumo;
            }

            if (!this.codigoUnidadMedida.equals("")) {
               var7 = var7 + "     and codigoUnidadMedida = '" + this.codigoUnidadMedida + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               DetalleEntregaInsumo var9 = new DetalleEntregaInsumo();
               var9.setCorrelativoEntregaInsumo(var8.getString(1));
               var9.setCodigoInsumo(var8.getString(2));
               var9.setCantidadEntregaInsumo(var8.getString(3));
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
