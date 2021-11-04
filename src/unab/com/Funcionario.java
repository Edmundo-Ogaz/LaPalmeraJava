package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Funcionario {
   private String rutFuncionario = "";
   private String nombreFuncionario = "";
   private String apellidoPaternoFuncionario = "";
   private String apellidoMaternoFuncionario = "";
   private String codigoCargo = "";
   private String codigoArea = "";

   public void setRutFuncionario(String var1) {
      this.rutFuncionario = var1;
   }

   public void setNombreFuncionario(String var1) {
      this.nombreFuncionario = var1;
   }

   public void setApellidoPaternoFuncionario(String var1) {
      this.apellidoPaternoFuncionario = var1;
   }

   public void setApellidoMaternoFuncionario(String var1) {
      this.apellidoMaternoFuncionario = var1;
   }

   public void setCodigoCargo(String var1) {
      this.codigoCargo = var1;
   }

   public void setCodigoArea(String var1) {
      this.codigoArea = var1;
   }

   public String getRutFuncionario() {
      return this.rutFuncionario;
   }

   public String getNombreFuncionario() {
      return this.nombreFuncionario;
   }

   public String getApellidoPaternoFuncionario() {
      return this.apellidoPaternoFuncionario;
   }

   public String getApellidoMaternoFuncionario() {
      return this.apellidoMaternoFuncionario;
   }

   public String getCodigoCargo() {
      return this.codigoCargo;
   }

   public String getCodigoArea() {
      return this.codigoArea;
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
            String var6 = "insert into Funcionario values (";
            var6 = var6 + "'" + this.rutFuncionario + "',";
            var6 = var6 + "'" + this.nombreFuncionario + "',";
            var6 = var6 + "'" + this.apellidoPaternoFuncionario + "',";
            var6 = var6 + "'" + this.apellidoMaternoFuncionario + "',";
            var6 = var6 + "'" + this.codigoCargo + "',";
            var6 = var6 + "'" + this.codigoArea + "')";
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
            String var6 = "update funcionario set ";
            var6 = var6 + "rutfuncionario = " + "'" + this.rutFuncionario + "', ";
            var6 = var6 + "nombrefuncionario = " + "'" + this.nombreFuncionario + "', ";
            var6 = var6 + "apellidopaternofuncionario = " + "'" + this.apellidoPaternoFuncionario + "', ";
            var6 = var6 + "apellidomaternofuncionario = " + "'" + this.apellidoMaternoFuncionario + "', ";
            var6 = var6 + "codigoCargo = '" + this.codigoCargo + "', ";
            var6 = var6 + "codigoarea = '" + this.codigoArea + "' where rutfuncionario = '" + this.rutFuncionario + "'";
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
            String var6 = "delete from funcionario where ";
            var6 = var6 + "rutfuncionario = '" + this.rutFuncionario + "'";
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
            String var7 = "select * from funcionario where rutfuncionario = '" + this.rutFuncionario + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.rutFuncionario = var8.getString(1);
               this.nombreFuncionario = var8.getString(2);
               this.apellidoPaternoFuncionario = var8.getString(3);
               this.apellidoMaternoFuncionario = var8.getString(4);
               this.codigoCargo = var8.getString(5);
               this.codigoArea = var8.getString(6);
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
