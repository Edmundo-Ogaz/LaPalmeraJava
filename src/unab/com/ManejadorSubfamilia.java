package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorSubfamilia {
   private String codigoSubfamilia = "";
   private String nombreSubfamilia = "";
   private String codigoFamilia = "";

   public void setCodigoSubfamilia(String var1) {
      this.codigoSubfamilia = var1;
   }

   public void setNombreSubfamilia(String var1) {
      this.nombreSubfamilia = var1;
   }

   public void setCodigoFamilia(String var1) {
      this.codigoFamilia = var1;
   }

   public String getCodigoSubfamilia() {
      return this.codigoSubfamilia;
   }

   public String getNombreSubfamilia() {
      return this.nombreSubfamilia;
   }

   public String getCodigoFamilia() {
      return this.codigoFamilia;
   }

   public ArrayList consultar() {
      ArrayList var1 = new ArrayList();
      String var2 = "root";
      String var3 = "";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from Subfamilia where 1 = 1 ";
            if (!this.codigoSubfamilia.equals("")) {
               var7 = var7 + "     and codigoSubfamilia = '" + this.codigoSubfamilia + "'";
            }

            if (!this.nombreSubfamilia.equals("")) {
               var7 = var7 + "     and nombreSubfamilia = '" + this.nombreSubfamilia + "'";
            }

            if (!this.codigoFamilia.equals("")) {
               var7 = var7 + "     and codigoFamilia = '" + this.codigoFamilia + "'";
            }

            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Subfamilia var9 = new Subfamilia();
               var9.setCodigoSubfamilia(var8.getString(1));
               var9.setNombreSubfamilia(var8.getString(2));
               var9.setCodigoFamilia(var8.getString(3));
               var1.add(var9);
            }
         }
      } catch (Exception var10) {
         System.out.println(var10);
      }

      return var1;
   }
}
