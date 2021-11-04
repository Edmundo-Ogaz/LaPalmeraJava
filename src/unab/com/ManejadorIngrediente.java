package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorIngrediente {
   private String codigoProducto = "";
   private String codigoInsumo = "";
   private String carga = "";
   private String cantidadInsumo = "";
   private String codigoUnidadMedida = "";

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoInsumo(String var1) {
      this.codigoInsumo = var1;
   }

   public void setCarga(String var1) {
      this.carga = var1;
   }

   public void setCantidadInsumo(String var1) {
      this.cantidadInsumo = var1;
   }

   public void setCodigoUnidadMedida(String var1) {
      this.codigoUnidadMedida = var1;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoInsumo() {
      return this.codigoInsumo;
   }

   public String getCarga() {
      return this.carga;
   }

   public String getCantidadInsumo() {
      return this.cantidadInsumo;
   }

   public String getCodigoUnidadMedida() {
      return this.codigoUnidadMedida;
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
            String var7 = "select * from Ingrediente where 1 = 1 ";
            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = " + "'" + this.codigoProducto + "'";
            }

            if (!this.codigoInsumo.equals("")) {
               var7 = var7 + "     and codigoInsumo = " + "'" + this.codigoInsumo + "'";
            }

            if (!this.carga.equals("")) {
               var7 = var7 + "     and carga = " + this.carga;
            }

            if (!this.cantidadInsumo.equals("")) {
               var7 = var7 + "     and cantidadInsumo = " + this.cantidadInsumo;
            }

            if (!this.cantidadInsumo.equals("")) {
               var7 = var7 + "     and codigounidadmedida = " + "'" + this.codigoUnidadMedida + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Ingrediente var9 = new Ingrediente();
               var9.setCodigoProducto(var8.getString(1));
               var9.setCodigoInsumo(var8.getString(2));
               var9.setCarga(var8.getString(3));
               var9.setCantidadInsumo(var8.getString(4));
               var9.setCodigoUnidadMedida(var8.getString(5));
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
