package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FichaTecnica {
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

   public void grabar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "insert into FichaTecnica values (";
            var6 = var6 + "'" + this.codigoProducto + "',";
            var6 = var6 + "'" + this.codigoConceptoTecnico + "',";
            var6 = var6 + "'" + this.descripcionFichaTecnica + "')";
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

   public void modificar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "update fichatecnica set ";
            var6 = var6 + "codigoproducto = " + "'" + this.codigoProducto + "', ";
            var6 = var6 + "codigoconceptotecnico = " + "'" + this.codigoConceptoTecnico + "', ";
            var6 = var6 + "descripcion = " + "'" + this.descripcionFichaTecnica + "'";
            var6 = var6 + " where codigoproducto = '" + this.codigoProducto + "'";
            var6 = var6 + "and codigoconceptotecnico = '" + this.codigoConceptoTecnico + "'";
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

   public void eliminar() {
      String var1 = "root";
      String var2 = "";
      String var3 = "jdbc:mysql://localhost/lapalmera2";
      Connection var4 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var4 = DriverManager.getConnection(var3, var1, var2);
         if (var4 != null) {
            Statement var5 = var4.createStatement();
            String var6 = "delete from fichatecnica where ";
            var6 = var6 + "codigoproducto = '" + this.codigoProducto + "'";
            var6 = var6 + "and codigoconceptotecnico = '" + this.codigoConceptoTecnico + "'";
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
      String var4 = "jdbc:mysql://localhost/lapalmera2";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from fichatecnica where";
            var7 = var7 + " codigoproducto = '" + this.codigoProducto + "'";
            var7 = var7 + " and codigoconceptotecnico = '" + this.codigoConceptoTecnico + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoProducto = var8.getString(1);
               this.codigoConceptoTecnico = var8.getString(2);
               this.descripcionFichaTecnica = var8.getString(3);
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
