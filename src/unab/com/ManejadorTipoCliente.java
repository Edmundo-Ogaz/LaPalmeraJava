package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorTipoCliente {
   private String codigoTipoCliente = "";
   private String nombreTipoCliente = "";

   public void setCodigoTipoCliente(String var1) {
      this.codigoTipoCliente = var1;
   }

   public void setNombreTipoCliente(String var1) {
      this.nombreTipoCliente = var1;
   }

   public String getCodigoTipoCliente() {
      return this.codigoTipoCliente;
   }

   public String getNombreTipoCliente() {
      return this.nombreTipoCliente;
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
            String var7 = "select * from TipoCliente where 1 = 1 ";
            if (!this.codigoTipoCliente.equals("")) {
               var7 = var7 + "     and codigoTipoCliente = '" + this.codigoTipoCliente + "'";
            }

            if (!this.nombreTipoCliente.equals("")) {
               var7 = var7 + "     and nombreTipoCliente = '" + this.nombreTipoCliente + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               TipoCliente var9 = new TipoCliente();
               var9.setCodigoTipoCliente(var8.getString(1));
               var9.setNombreTipoCliente(var8.getString(2));
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
