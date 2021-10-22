package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usuario {
   String loginUsuario = "";
   String rutFuncionario = "";
   String codigoGrupo = "";
   String passwordUsuario = "";

   public void setUsuario(String var1) {
      this.loginUsuario = var1;
   }

   public void setRut(String var1) {
      this.rutFuncionario = var1;
   }

   public void setGrupo(String var1) {
      this.codigoGrupo = var1;
   }

   public void setPassword(String var1) {
      this.passwordUsuario = var1;
   }

   public String getUsuario() {
      return this.loginUsuario;
   }

   public String getRut() {
      return this.rutFuncionario;
   }

   public String getGrupo() {
      return this.codigoGrupo;
   }

   public String getPassword() {
      return this.passwordUsuario;
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
            String var6 = "insert into usuario values (";
            var6 = var6 + "'" + this.loginUsuario + "',";
            var6 = var6 + "'" + this.rutFuncionario + "',";
            var6 = var6 + "'" + this.codigoGrupo + "',";
            var6 = var6 + "'" + this.passwordUsuario + "',";
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
            String var7 = "select * from usuario where loginusuario = " + this.loginUsuario + "";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.loginUsuario = var8.getString(1);
               this.rutFuncionario = var8.getString(2);
               this.codigoGrupo = var8.getString(3);
               this.passwordUsuario = var8.getString(4);
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

   public boolean buscar(String var1) {
      boolean var2 = false;
      String var3 = "root";
      String var4 = "";
      String var5 = "jdbc:mysql://localhost/lapalmera2";
      Connection var6 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var6 = DriverManager.getConnection(var5, var3, var4);
         if (var6 != null) {
            Statement var7 = var6.createStatement();
            String var8 = "select * from usuario where loginusuario = '" + this.loginUsuario + "'";
            ResultSet var9 = var7.executeQuery(var8);
            if (var9.next()) {
               this.loginUsuario = var9.getString(1);
               this.rutFuncionario = var9.getString(2);
               this.codigoGrupo = var9.getString(3);
               this.passwordUsuario = var9.getString(4);
               var2 = true;
            }

            var9.close();
            var7.close();
            var6.close();
         }
      } catch (Exception var10) {
         System.out.println(var10);
      }

      return var2;
   }

   public boolean validaUsuario() {
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
            String var7 = "select * from usuario where loginusuario = '" + this.loginUsuario + "' and passwordUsuario = '" + this.passwordUsuario + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               this.loginUsuario = var8.getString(1);
               this.rutFuncionario = var8.getString(2);
               this.codigoGrupo = var8.getString(3);
               this.passwordUsuario = var8.getString(4);
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
