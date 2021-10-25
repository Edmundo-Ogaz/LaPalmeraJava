package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorConfirmacionPedido {
   private String numeroPedido = "";
   private String nombreCliente = "";
   private String apellidoCliente = "";
   private String DireccionCliente = "";
   private String telefonoCliente = "";

   public void setNumeroPedido(String var1) {
      this.numeroPedido = var1;
   }

   public void setNombreCliente(String var1) {
      this.nombreCliente = var1;
   }

   public void setApellidoCliente(String var1) {
      this.apellidoCliente = var1;
   }

   public void setDireccionCliente(String var1) {
      this.DireccionCliente = var1;
   }

   public void setTelefonoCliente(String var1) {
      this.telefonoCliente = var1;
   }

   public String getNumeroPedido() {
      return this.numeroPedido;
   }

   public String getNombreCliente() {
      return this.nombreCliente;
   }

   public String getApellidoCliente() {
      return this.apellidoCliente;
   }

   public String getDireccionCliente() {
      return this.DireccionCliente;
   }

   public String getTelefonoCliente() {
      return this.telefonoCliente;
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
            String var7 = "select * from ConfirmacionPedido where 1 = 1 ";
            if (!this.numeroPedido.equals("")) {
               var7 = var7 + "     and numeroPedido = " + this.numeroPedido;
            }

            if (!this.nombreCliente.equals("")) {
               var7 = var7 + "     and nombreCliente = '" + this.nombreCliente + "'";
            }

            if (!this.apellidoCliente.equals("")) {
               var7 = var7 + "     and apellidoCliente = '" + this.apellidoCliente + "'";
            }

            if (!this.DireccionCliente.equals("")) {
               var7 = var7 + "     and DireccionCliente = '" + this.DireccionCliente + "'";
            }

            if (!this.telefonoCliente.equals("")) {
               var7 = var7 + "     and telefonoCliente = " + this.telefonoCliente;
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               ConfirmacionPedido var9 = new ConfirmacionPedido();
               var9.setNumeroPedido(var8.getString(1));
               var9.setNombreCliente(var8.getString(2));
               var9.setApellidoCliente(var8.getString(3));
               var9.setDireccionCliente(var8.getString(4));
               var9.setTelefonoCliente(var8.getString(5));
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
