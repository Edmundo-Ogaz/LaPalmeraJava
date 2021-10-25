package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorCabezaPedido {
   private String numeroPedido = "";
   private String nombreCliente = "";
   private String fechaPedido = "";
   private String horaPedido = "";
   private String precioTotalPedido = "";
   private String confirmacionPedido = "";
   private String dedicatoriaPedido = "";
   private String observacionPedido = "";
   private String fechaInicio = "";
   private String fechaTermino = "";

   public void setNumeroPedido(String var1) {
      this.numeroPedido = var1;
   }

   public void setNombreCliente(String var1) {
      this.nombreCliente = var1;
   }

   public void setFechaPedido(String var1) {
      this.fechaPedido = var1;
   }

   public void setHoraPedido(String var1) {
      this.horaPedido = var1;
   }

   public void setPrecioTotalPedido(String var1) {
      this.precioTotalPedido = var1;
   }

   public void setConfirmacionPedido(String var1) {
      this.confirmacionPedido = var1;
   }

   public void setDedicatoriaPedido(String var1) {
      this.dedicatoriaPedido = var1;
   }

   public void setObservacionPedido(String var1) {
      this.observacionPedido = var1;
   }

   public void setFechaInicio(String var1) {
      this.fechaInicio = var1;
   }

   public void setFechaTermino(String var1) {
      this.fechaTermino = var1;
   }

   public String getNumeroPedido() {
      return this.numeroPedido;
   }

   public String getNombreCliente() {
      return this.nombreCliente;
   }

   public String getFechaPedido() {
      return this.fechaPedido;
   }

   public String getHoraPedido() {
      return this.horaPedido;
   }

   public String getPrecioTotalPedido() {
      return this.precioTotalPedido;
   }

   public String getConfirmacionPedido() {
      return this.confirmacionPedido;
   }

   public String getDedicatoriaPedido() {
      return this.dedicatoriaPedido;
   }

   public String getObservacionPedido() {
      return this.observacionPedido;
   }

   public String getFechaInicio() {
      return this.fechaInicio;
   }

   public String getFchaTermino() {
      return this.fechaTermino;
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
            String var7 = "select * from CabezaPedido where 1 = 1 ";
            if (!this.numeroPedido.equals("")) {
               var7 = var7 + "     and numeroPedido = " + this.numeroPedido;
            }

            if (!this.nombreCliente.equals("")) {
               var7 = var7 + "     and nombreCliente = '" + this.nombreCliente + "'";
            }

            if (!this.fechaPedido.equals("")) {
               var7 = var7 + "     and fechaPedido = " + this.fechaPedido;
            }

            if (!this.horaPedido.equals("")) {
               var7 = var7 + "     and horaPedido = " + this.horaPedido;
            }

            if (!this.precioTotalPedido.equals("")) {
               var7 = var7 + "     and precioTotalPedido = " + this.precioTotalPedido;
            }

            if (!this.confirmacionPedido.equals("")) {
               var7 = var7 + "     and confirmacionPedido = '" + this.confirmacionPedido + "'";
            }

            if (!this.observacionPedido.equals("")) {
               var7 = var7 + "     and observacionPedido = '" + this.observacionPedido + "'";
            }

            if (!this.observacionPedido.equals("")) {
               var7 = var7 + "     and observacionPedido = '" + this.observacionPedido + "'";
            }

            if (!this.fechaInicio.equals("") || !this.fechaTermino.equals("")) {
               var7 = var7 + "     and fechaPedido >= '" + this.fechaInicio + "' and fechaPedido <= '" + this.fechaTermino + "'";
            }

            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               CabezaPedido var9 = new CabezaPedido();
               var9.setNumeroPedido(var8.getString(1));
               var9.setNombreCliente(var8.getString(2));
               var9.setFechaPedido(var8.getString(3));
               var9.setHoraPedido(var8.getString(4));
               var9.setPrecioTotalPedido(var8.getString(5));
               var9.setConfirmacionPedido(var8.getString(6));
               var9.setDedicatoriaPedido(var8.getString(7));
               var9.setObservacionPedido(var8.getString(8));
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
