package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DetalleDevolucionInsumo {
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

   public void grabar() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "insert into DetalleDevolucionInsumo values (";
            var6 = var6 + this.correlativoDevolucionInsumo + ",";
            var6 = var6 + "'" + this.codigoInsumo + "',";
            var6 = var6 + this.cantidadDevolucionInsumo + ",";
            var6 = var6 + "'" + this.codigoUnidadMedida + "')";
            int var7 = var5.executeUpdate(var6);
            if (var7 == 1) {
               var5.close();
            }

            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }
}
