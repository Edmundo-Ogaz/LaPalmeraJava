package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorDetalleDevolucionInsumo {
   private String correlativoDevolucionInsumo = "";
   private String codigoInsumo = "";
   private String cantidadDevolucionInsumo = "";
   private String codigoUnidadMedida = "";

   public void setCorrelativoDevolucionInsumo(String var1) {
      this.correlativoDevolucionInsumo = var1;
   }

   public void setCodigoInsumo(String var1) {
      this.codigoInsumo = var1;
   }

   public void setCantidadDevolucionInsumo(String var1) {
      this.cantidadDevolucionInsumo = var1;
   }

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public String getCorrelativoDevolucionInsumo() {
      return this.correlativoDevolucionInsumo;
   }

   public String getCodigoInsumo() {
      return this.codigoInsumo;
   }

   public String getCantidadDevolucionInsumo() {
      return this.cantidadDevolucionInsumo;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
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
            String var7 = "select * from DetalleDevolucionInsumo where 1 = 1 ";
            if (!this.correlativoDevolucionInsumo.equals("")) {
               var7 = var7 + "     and correlativoDevolucionInsumo = " + this.correlativoDevolucionInsumo;
            }

            if (!this.codigoInsumo.equals("")) {
               var7 = var7 + "     and codigoInsumo = '" + this.codigoInsumo + "'";
            }

            if (!this.cantidadDevolucionInsumo.equals("")) {
               var7 = var7 + "     and cantidadDevolucionInsumo = " + this.cantidadDevolucionInsumo;
            }

            if (!this.codigoUnidadMedida.equals("")) {
               var7 = var7 + "     and codigoUnidadMedida = '" + this.codigoUnidadMedida + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               DetalleDevolucionInsumo var9 = new DetalleDevolucionInsumo();
               var9.setCorrelativoDevolucionInsumo(var8.getString(1));
               var9.setCodigoInsumo(var8.getString(2));
               var9.setCantidadDevolucionInsumo(var8.getString(3));
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
