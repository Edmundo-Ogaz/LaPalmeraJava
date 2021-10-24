package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorFichaTecnica {
   private String codigoProducto = "";
   private String codigoConceptoTecnico = "";
   private String descripcionFichaTecnica = "";

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoConceptoTecnico(String var1) {
      this.codigoConceptoTecnico = var1;
   }

   public void setDescripcionFichaTecnica(String var1) {
      this.descripcionFichaTecnica = var1;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoConceptoTecnico() {
      return this.codigoConceptoTecnico;
   }

   public String getDescripcionFichaTecnica() {
      return this.descripcionFichaTecnica;
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
            String var7 = "select * from FichaTecnica where 1 = 1 ";
            if (!this.codigoProducto.equals("")) {
               var7 = var7 + "     and codigoProducto = '" + this.codigoProducto + "'";
            }

            if (!this.codigoConceptoTecnico.equals("")) {
               var7 = var7 + "     and codigoConceptoTecnico = '" + this.codigoConceptoTecnico + "'";
            }

            if (!this.descripcionFichaTecnica.equals("")) {
               var7 = var7 + "     and descripcionFichaTecnica = '" + this.descripcionFichaTecnica + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               FichaTecnica var9 = new FichaTecnica();
               var9.setCodigoProducto(var8.getString(1));
               var9.setCodigoConceptoTecnico(var8.getString(2));
               var9.setDescripcionFichaTecnica(var8.getString(3));
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
