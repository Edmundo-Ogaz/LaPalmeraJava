package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorFamilia {
   private String codigoFamilia = "";
   private String nombreFamilia = "";

   public void setCodigoFamilia(String var1) {
      this.codigoFamilia = var1;
   }

   public void setNombreFamilia(String var1) {
      this.nombreFamilia = var1;
   }

   public String getCodigoFamilia() {
      return this.codigoFamilia;
   }

   public String getNombreFamilia() {
      return this.nombreFamilia;
   }

   public ArrayList consultar() {
      ArrayList var1 = new ArrayList();
      String var2 = "root";
      String var3 = "";
      String var4 = "jdbc:mysql://localhost/lapalmera2";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from familia where 1 = 1 ";
            if (!this.codigoFamilia.equals("")) {
               var7 = var7 + "     and codigofamilia = '" + this.codigoFamilia + "'";
            }

            if (!this.nombreFamilia.equals("")) {
               var7 = var7 + "     and nombrefamilia = '" + this.nombreFamilia + "'";
            }

            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Familia var9 = new Familia();
               var9.setCodigoFamilia(var8.getString(1));
               var9.setNombreFamilia(var8.getString(2));
               var1.add(var9);
            }
         }
      } catch (Exception var10) {
         System.out.println(var10);
      }

      return var1;
   }
}
