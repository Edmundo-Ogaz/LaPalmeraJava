package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorEntregaInsumo {
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
            String var7 = "select * from EntregaInsumo where 1 = 1 ";
            if (!this.correlativoEntregaInsumo.equals("")) {
               var7 = var7 + "     and correlativoEntregaInsumo = '" + this.correlativoEntregaInsumo + "'";
            }

            if (!this.codigoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and codigoOrdenFabricacion = '" + this.codigoOrdenFabricacion + "'";
            }

            if (!this.fechaEntregaInsumo.equals("")) {
               var7 = var7 + "     and fechaEntregaInsumo = '" + this.fechaEntregaInsumo + "'";
            }

            if (!this.horaEntregaInsumo.equals("")) {
               var7 = var7 + "     and horaEntregaInsumo = '" + this.horaEntregaInsumo + "'";
            }

            if (!this.rutFuncionario.equals("")) {
               var7 = var7 + "     and rutFuncionario = '" + this.rutFuncionario + "'";
            }

            if (!this.observacion.equals("")) {
               var7 = var7 + "     and observacion = '" + this.observacion + "'";
            }

            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               EntregaInsumo var9 = new EntregaInsumo();
               var9.setCorrelativoEntregaInsumo(var8.getString(1));
               var9.setCodigoOrdenFabricacion(var8.getString(2));
               var9.setFechaEntregaInsumo(var8.getString(3));
               var9.setHoraEntregaInsumo(var8.getString(4));
               var9.setRutFuncionario(var8.getString(5));
               var9.setObservacion(var8.getString(6));
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
