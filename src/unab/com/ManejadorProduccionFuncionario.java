package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorProduccionFuncionario {
   private String correlativoProduccion = "";
   private String rutFuncionario = "";

   public void setCorrelativoProduccion(String var1) {
      this.correlativoProduccion = var1;
   }

   public void setRutFuncionario(String var1) {
      this.rutFuncionario = var1;
   }

   public String getCorrelativoProduccion() {
      return this.correlativoProduccion;
   }

   public String getRutFuncionario() {
      return this.rutFuncionario;
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
            String var7 = "select * from ProduccionFuncionario where 1 = 1 ";
            if (!this.correlativoProduccion.equals("")) {
               var7 = var7 + "     and correlativoProduccion = " + this.correlativoProduccion;
            }

            if (!this.rutFuncionario.equals("")) {
               var7 = var7 + "     and rutFuncionario = '" + this.rutFuncionario + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               ProduccionFuncionario var9 = new ProduccionFuncionario();
               var9.setCorrelativoProduccion(var8.getString(1));
               var9.setRutFuncionario(var8.getString(2));
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
