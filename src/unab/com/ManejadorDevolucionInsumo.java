package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorDevolucionInsumo {
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
            String var7 = "select * from DevolucionInsumo where 1 = 1 ";
            if (!this.correlativoDevolucionInsumo.equals("")) {
               var7 = var7 + "     and correlativoDevolucionInsumo = " + this.correlativoDevolucionInsumo;
            }

            if (!this.codigoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and codigoOrdenFabricacion = '" + this.codigoOrdenFabricacion + "'";
            }

            if (!this.fechaDevolucionInsumo.equals("")) {
               var7 = var7 + "     and fechaDevolucionInsumo = '" + this.fechaDevolucionInsumo + "'";
            }

            if (!this.horaDevolucionInsumo.equals("")) {
               var7 = var7 + "     and horaDevolucionInsumo = '" + this.horaDevolucionInsumo + "'";
            }

            if (!this.rutFuncionario.equals("")) {
               var7 = var7 + "     and rutFuncionario = '" + this.rutFuncionario + "'";
            }

            if (!this.observacion.equals("")) {
               var7 = var7 + "     and observacion = '" + this.observacion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               DevolucionInsumo var9 = new DevolucionInsumo();
               var9.setCorrelativoDevolucionInsumo(var8.getString(1));
               var9.setCodigoOrdenFabricacion(var8.getString(2));
               var9.setFechaDevolucionInsumo(var8.getString(3));
               var9.setHoraDevolucionInsumo(var8.getString(4));
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
