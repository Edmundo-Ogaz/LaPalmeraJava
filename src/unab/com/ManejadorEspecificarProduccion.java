package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorEspecificarProduccion {
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

   public ArrayList consultar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/palmera";
      Connection var4 = null;
      ArrayList var5 = new ArrayList();

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var6 = var4.createStatement();
            String var7 = "select * from EspecificarProduccion where 1 = 1 ";
            if (!this.codigoOrdenFabricacion.equals("")) {
               var7 = var7 + "     and codigoOrdenFabricacion = " + this.codigoOrdenFabricacion;
            }

            if (!this.rutFuncionario.equals("")) {
               var7 = var7 + "     and rutFuncionario = '" + this.rutFuncionario + "'";
            }

            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.codigoLineaProduccion.equals("")) {
               var7 = var7 + "     and codigoLineaProduccion = '" + this.codigoLineaProduccion + "'";
            }

            if (!this.fechaEspecificarProduccion.equals("")) {
               var7 = var7 + "     and fechaEspecificarProduccion = " + this.fechaEspecificarProduccion;
            }

            if (!this.horaEspecificarProduccion.equals("")) {
               var7 = var7 + "     and horaEspecificarProduccion = '" + this.horaEspecificarProduccion + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               EspecificarProduccion var9 = new EspecificarProduccion();
               var9.setCodigoOrdenFabricacion(var8.getString(1));
               var9.setRutFuncionario(var8.getString(2));
               var9.setCodigoProducto(var8.getString(3));
               var9.setCodigoLineaProduccion(var8.getString(4));
               var9.setFechaEspecificarProduccion(var8.getString(5));
               var9.setHoraEspecificarProduccion(var8.getString(6));
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
