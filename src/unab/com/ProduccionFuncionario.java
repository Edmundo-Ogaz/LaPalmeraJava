package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProduccionFuncionario {
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

   public void grabar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "insert into ProduccionFuncionario values (";
            var6 = var6 + this.correlativoProduccion + ",";
            var6 = var6 + "'" + this.rutFuncionario + "')";
            int var7 = var5.executeUpdate(var6);
            if (var7 == 1) {
               var5.close();
            }

            var4.close();
         }
      } catch (Exception var8) {
         System.out.println(var8);
      }

   }
}
