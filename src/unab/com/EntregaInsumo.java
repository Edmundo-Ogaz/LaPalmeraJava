package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EntregaInsumo {
   private String correlativoEntregaInsumo = "";
   private String codigoOrdenFabricacion = "";
   private String fechaEntregaInsumo = "";
   private String horaEntregaInsumo = "";
   private String rutFuncionario = "";
   private String observacion = "";

   public void setCorrelativoEntregaInsumo(String var1) {
      this.correlativoEntregaInsumo = var1;
   }

   public void setCodigoOrdenFabricacion(String var1) {
      this.codigoOrdenFabricacion = var1;
   }

   public void setFechaEntregaInsumo(String var1) {
      this.fechaEntregaInsumo = var1;
   }

   public void setHoraEntregaInsumo(String var1) {
      this.horaEntregaInsumo = var1;
   }

   public void setRutFuncionario(String var1) {
      this.rutFuncionario = var1;
   }

   public void setObservacion(String var1) {
      this.observacion = var1;
   }

   public String getCorrelativoEntregaInsumo() {
      return this.correlativoEntregaInsumo;
   }

   public String getCodigoOrdenFabricacion() {
      return this.codigoOrdenFabricacion;
   }

   public String getFechaEntregaInsumo() {
      return this.fechaEntregaInsumo;
   }

   public String getHoraEntregaInsumo() {
      return this.horaEntregaInsumo;
   }

   public String getRutFuncionario() {
      return this.rutFuncionario;
   }

   public String getObservacion() {
      return this.observacion;
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
            String var6 = "insert into EntregaInsumo(codigoOrdenFabricacion,fechaEntregaInsumo,horaEntregaInsumo,rutFuncionario,observacion) values (";
            var6 = var6 + "'" + this.codigoOrdenFabricacion + "',";
            var6 = var6 + "'" + this.fechaEntregaInsumo + "',";
            var6 = var6 + "'" + this.horaEntregaInsumo + "',";
            var6 = var6 + "'" + this.rutFuncionario + "',";
            var6 = var6 + "'" + this.observacion + "')";
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

   public boolean buscar() {
      boolean var1 = false;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from EntregaInsumo where codigoOrdenFabricacion = '" + this.codigoOrdenFabricacion + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.correlativoEntregaInsumo = var8.getString(1);
               this.codigoOrdenFabricacion = var8.getString(2);
               this.fechaEntregaInsumo = var8.getString(3);
               this.horaEntregaInsumo = var8.getString(4);
               this.rutFuncionario = var8.getString(5);
               this.observacion = var8.getString(6);
               var1 = true;
            }

            var8.close();
            var6.close();
            var5.close();
         }
      } catch (Exception var9) {
         System.out.println(var9);
      }

      return var1;
   }

   public String buscarUltimo() {
      String var1 = "root";
      String var2 = "jochua";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "select * from EntregaInsumo";
            System.out.println(var6);
            ResultSet var7 = var5.executeQuery(var6);

            while(var7.next()) {
               System.out.println("Lo encontro");
               this.correlativoEntregaInsumo = var7.getString(1);
               System.out.println(this.correlativoEntregaInsumo);
            }

            var7.close();
            var5.close();
            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

      return this.correlativoEntregaInsumo;
   }
}
