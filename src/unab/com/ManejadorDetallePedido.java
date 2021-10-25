package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorDetallePedido {
   private String numeroPedido = "";
   private String codigoProducto = "";
   private String precioProducto = "";
   private String cantidadProducto = "";

   public void setNumeroPedido(String var1) {
      this.numeroPedido = var1;
   }

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setPrecioProducto(String var1) {
      this.precioProducto = var1;
   }

   public void setCantidadProducto(String var1) {
      this.cantidadProducto = var1;
   }

   public String getNumeroPedido() {
      return this.numeroPedido;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getPrecioProducto() {
      return this.precioProducto;
   }

   public String getCantidadProducto() {
      return this.cantidadProducto;
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
            String var7 = "select * from DetallePedido where 1 = 1 ";
            if (!this.numeroPedido.equals("")) {
               var7 = var7 + "     and numeroPedido = " + this.numeroPedido;
            }

            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = " + this.codigoProducto;
            }

            if (!this.precioProducto.equals("")) {
               var7 = var7 + "     and precioProducto = " + this.precioProducto;
            }

            if (!this.cantidadProducto.equals("")) {
               var7 = var7 + "     and cantidadProducto = " + this.cantidadProducto;
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               DetallePedido var9 = new DetallePedido();
               var9.setNumeroPedido(var8.getString(1));
               var9.setCodigoProducto(var8.getString(2));
               var9.setPrecioProducto(var8.getString(3));
               var9.setCantidadProducto(var8.getString(4));
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
