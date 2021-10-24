package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DetalleEntregaInsumo {
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
            String var6 = "insert into DetalleEntregaInsumo values (";
            var6 = var6 + this.correlativoEntregaInsumo + ",";
            var6 = var6 + "'" + this.codigoInsumo + "',";
            var6 = var6 + this.cantidadEntregaInsumo + ",";
            var6 = var6 + "'" + this.codigoUnidadMedida + "')";
            System.out.println(var6);
            int var7 = var5.executeUpdate(var6);
            if (var7 == 1) {
               System.out.println("OK");
            }

            var5.close();
            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }
}
