package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorConceptoTecnico {
   private String codigoConceptoTecnico = "";
   private String nombreConceptoTecnico = "";

   public void setCodigoConceptoTecnico(String var1) {
      this.codigoConceptoTecnico = var1;
   }

   public void setNombreConceptoTecnico(String var1) {
      this.nombreConceptoTecnico = var1;
   }

   public String getCodigoConceptoTecnico() {
      return this.codigoConceptoTecnico;
   }

   public String getNombreConceptoTecnico() {
      return this.nombreConceptoTecnico;
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
            String var7 = "select * from ConceptoTecnico where 1 = 1 ";
            if (!this.codigoConceptoTecnico.equals("")) {
               var7 = var7 + "     and codigoConceptoTecnico = " + this.codigoConceptoTecnico;
            }

            if (!this.nombreConceptoTecnico.equals("")) {
               var7 = var7 + "     and nombreConceptoTecnico = '" + this.nombreConceptoTecnico + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               ConceptoTecnico var9 = new ConceptoTecnico();
               var9.setCodigoConceptoTecnico(var8.getString(1));
               var9.setNombreConceptoTecnico(var8.getString(2));
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
