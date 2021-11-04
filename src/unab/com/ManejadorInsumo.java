package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorInsumo {
   private String codigoInsumo = "";
   private String nombreInsumo = "";
   private String codigoUnidadMedida = "";
   private String stockCriticoInsumo = "";
   private String pesoInsumo = "";
   private String observacionInsumo = "";

   public void setCodigoInsumo(String var1) {
      this.codigoInsumo = var1;
   }

   public void setNombreInsumo(String var1) {
      this.nombreInsumo = var1;
   }

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public void setStockCriticoInsumo(String var1) {
      this.stockCriticoInsumo = var1;
   }

   public void setpesoInsumo(String var1) {
      this.pesoInsumo = var1;
   }

   public void setObservacionInsumo(String var1) {
      this.observacionInsumo = var1;
   }

   public String getCodigoInsumo() {
      return this.codigoInsumo;
   }

   public String getNombreInsumo() {
      return this.nombreInsumo;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
   }

   public String getStockCriticoInsumo() {
      return this.stockCriticoInsumo;
   }

   public String getpesoInsumo() {
      return this.pesoInsumo;
   }

   public String getObservacionInsumo() {
      return this.observacionInsumo;
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
            String var7 = "select * from Insumo where 1 = 1 ";
            if (!this.codigoInsumo.equals("")) {
               var7 = var7 + "     and codigoInsumo = '" + this.codigoInsumo + "'";
            }

            if (!this.nombreInsumo.equals("")) {
               var7 = var7 + "     and nombreInsumo = '" + this.nombreInsumo + "'";
            }

            if (!this.codigoUnidadMedida.equals("")) {
               var7 = var7 + "     and codigoUnidadMedida = '" + this.codigoUnidadMedida + "'";
            }

            if (!this.stockCriticoInsumo.equals("")) {
               var7 = var7 + "     and stockCriticoInsumo = " + this.stockCriticoInsumo;
            }

            if (!this.pesoInsumo.equals("")) {
               var7 = var7 + "     and pesoInsumo = " + this.pesoInsumo;
            }

            if (!this.observacionInsumo.equals("")) {
               var7 = var7 + "     and observacionInsumo = '" + this.observacionInsumo + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Insumo var9 = new Insumo();
               var9.setCodigoInsumo(var8.getString(1));
               var9.setNombreInsumo(var8.getString(2));
               var9.setCodigoUnidadMedida(var8.getString(3));
               var9.setStockCriticoInsumo(var8.getString(4));
               var9.setPesoInsumo(var8.getString(5));
               var9.setObservacionInsumo(var8.getString(10));
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
