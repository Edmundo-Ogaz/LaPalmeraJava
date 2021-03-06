package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EspecificarProduccion {
   private String codigoOrdenFabricacion = "";
   private String rutFuncionario = "";
   private String codigoProducto = "";
   private String codigoLineaProduccion = "";
   private String fechaEspecificarProduccion = "";
   private String horaEspecificarProduccion = "";

   public void setCodigoOrdenFabricacion(String var1) {
      this.codigoOrdenFabricacion = var1;
   }

   public void setRutFuncionario(String var1) {
      this.rutFuncionario = var1;
   }

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoLineaProduccion(String var1) {
      this.codigoLineaProduccion = var1;
   }

   public void setFechaEspecificarProduccion(String var1) {
      this.fechaEspecificarProduccion = var1;
   }

   public void setHoraEspecificarProduccion(String var1) {
      this.horaEspecificarProduccion = var1;
   }

   public String getCodigoOrdenFabricacion() {
      return this.codigoOrdenFabricacion;
   }

   public String getRutFuncionario() {
      return this.rutFuncionario;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoLineaProduccion() {
      return this.codigoLineaProduccion;
   }

   public String getFechaEspecificarProduccion() {
      return this.fechaEspecificarProduccion;
   }

   public String getHoraEspecificarProduccion() {
      return this.horaEspecificarProduccion;
   }

   public void grabar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/palmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "insert into EspecificarProduccion values (";
            var6 = var6 + this.codigoOrdenFabricacion + ",";
            var6 = var6 + "'" + this.rutFuncionario + "',";
            var6 = var6 + "'" + this.codigoProducto + "',";
            var6 = var6 + "'" + this.codigoLineaProduccion + "',";
            var6 = var6 + "'" + this.fechaEspecificarProduccion + "',";
            var6 = var6 + "'" + this.horaEspecificarProduccion + "')";
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
      String var3 = "";
      String var4 = "jdbc:mysql://localhost/palmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from especificarproduccion where codigoordenfabricacion = " + this.codigoOrdenFabricacion + "";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoOrdenFabricacion = var8.getString(1);
               this.rutFuncionario = var8.getString(2);
               this.codigoProducto = var8.getString(3);
               this.codigoLineaProduccion = var8.getString(4);
               this.fechaEspecificarProduccion = var8.getString(5);
               this.horaEspecificarProduccion = var8.getString(6);
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
}
