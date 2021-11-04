package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorDespachoPedido {
   private String numeroPedido = "";
   private String direccionDespacho = "";
   private String fechaEntregaDespacho = "";
   private String horaEntregaDespacho = "";

   public void setNumeroPedido(String var1) {
      this.numeroPedido = var1;
   }

   public void setDireccionDespacho(String var1) {
      this.direccionDespacho = var1;
   }

   public void setFechaEntregaDespacho(String var1) {
      this.fechaEntregaDespacho = var1;
   }

   public void setHoraEntregaDespacho(String var1) {
      this.horaEntregaDespacho = var1;
   }

   public String getNumeroPedido() {
      return this.numeroPedido;
   }

   public String getDireccionDespacho() {
      return this.direccionDespacho;
   }

   public String getFechaEntregaDespacho() {
      return this.fechaEntregaDespacho;
   }

   public String getHoraEntregaDespacho() {
      return this.horaEntregaDespacho;
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
            String var7 = "select * from DespachoPedido where 1 = 1 ";
            if (!this.numeroPedido.equals("")) {
               var7 = var7 + "     and numeroPedido = " + this.numeroPedido;
            }

            if (!this.direccionDespacho.equals("")) {
               var7 = var7 + "     and direccionDespacho = '" + this.direccionDespacho + "'";
            }

            if (!this.fechaEntregaDespacho.equals("")) {
               var7 = var7 + "     and fechaEntregaDespacho = " + this.fechaEntregaDespacho;
            }

            if (!this.horaEntregaDespacho.equals("")) {
               var7 = var7 + "     and horaEntregaDespacho = " + this.horaEntregaDespacho;
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               DespachoPedido var9 = new DespachoPedido();
               var9.setNumeroPedido(var8.getString(1));
               var9.setDireccionDespacho(var8.getString(2));
               var9.setFechaEntregaDespacho(var8.getString(3));
               var9.setHoraEntregaDespacho(var8.getString(4));
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
