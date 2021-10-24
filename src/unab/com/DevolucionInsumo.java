package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DevolucionInsumo {
   private String correlativoDevolucionInsumo = "";
   private String codigoOrdenFabricacion = "";
   private String fechaDevolucionInsumo = "";
   private String horaDevolucionInsumo = "";
   private String rutFuncionario = "";
   private String observacion = "";

   public void setCorrelativoDevolucionInsumo(String var1) {
      this.correlativoDevolucionInsumo = var1;
   }

   public void setCodigoOrdenFabricacion(String var1) {
      this.codigoOrdenFabricacion = var1;
   }

   public void setFechaDevolucionInsumo(String var1) {
      this.fechaDevolucionInsumo = var1;
   }

   public void setHoraDevolucionInsumo(String var1) {
      this.horaDevolucionInsumo = var1;
   }

   public void setRutFuncionario(String var1) {
      this.rutFuncionario = var1;
   }

   public void setObservacion(String var1) {
      this.observacion = var1;
   }

   public String getCorrelativoDevolucionInsumo() {
      return this.correlativoDevolucionInsumo;
   }

   public String getCodigoOrdenFabricacion() {
      return this.codigoOrdenFabricacion;
   }

   public String getFechaDevolucionInsumo() {
      return this.fechaDevolucionInsumo;
   }

   public String getHoraDevolucionInsumo() {
      return this.horaDevolucionInsumo;
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
            String var6 = "insert into DevolucionInsumo(codigoOrdenFabricacion,fechaDevolucionInsumo,horaDevolucionInsumo,rutFuncionario,observacion) values (";
            var6 = var6 + "'" + this.codigoOrdenFabricacion + "',";
            var6 = var6 + "'" + this.fechaDevolucionInsumo + "',";
            var6 = var6 + "'" + this.horaDevolucionInsumo + "',";
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
            String var6 = "select * from DevolucionInsumo";
            System.out.println(var6);
            ResultSet var7 = var5.executeQuery(var6);

            while(var7.next()) {
               System.out.println("Lo encontro");
               this.correlativoDevolucionInsumo = var7.getString(1);
               System.out.println(this.correlativoDevolucionInsumo);
            }

            var7.close();
            var5.close();
            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

      return this.correlativoDevolucionInsumo;
   }
}
