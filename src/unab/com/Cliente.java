package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente {
   private String rutCliente = "";
   private String nombreCliente = "";
   private String direccionCliente = "";
   private String codigoComuna = "";
   private String fechaNacimientoCliente = "";
   private String telefonoCliente = "";
   private String emailCliente = "";
   private String paginaWebCliente = "";
   private String codigoTipoCliente = "";
   private String observacionCliente = "";

   public void setRutCliente(String var1) {
      this.rutCliente = var1;
   }

   public void setNombreCliente(String var1) {
      this.nombreCliente = var1;
   }

   public void setDireccionCliente(String var1) {
      this.direccionCliente = var1;
   }

   public void setCodigoComuna(String var1) {
      this.codigoComuna = var1;
   }

   public void setFechaNacimientoCliente(String var1) {
      this.fechaNacimientoCliente = var1;
   }

   public void setTelefonoCliente(String var1) {
      this.telefonoCliente = var1;
   }

   public void setEmailCliente(String var1) {
      this.emailCliente = var1;
   }

   public void setPaginaWebCliente(String var1) {
      this.paginaWebCliente = var1;
   }

   public void setCodigoTipoCliente(String var1) {
      this.codigoTipoCliente = var1;
   }

   public void setObservacionCliente(String var1) {
      this.observacionCliente = var1;
   }

   public String getRutCliente() {
      return this.rutCliente;
   }

   public String getNombreCliente() {
      return this.nombreCliente;
   }

   public String getDireccionCliente() {
      return this.direccionCliente;
   }

   public String getCodigoComuna() {
      return this.codigoComuna;
   }

   public String getFechaNacimientoCliente() {
      return this.fechaNacimientoCliente;
   }

   public String getTelefonoCliente() {
      return this.telefonoCliente;
   }

   public String getEmailCliente() {
      return this.emailCliente;
   }

   public String getPaginaWebCliente() {
      return this.paginaWebCliente;
   }

   public String getCodigoTipoCliente() {
      return this.codigoTipoCliente;
   }

   public String getObservacionCliente() {
      return this.observacionCliente;
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
            String var6 = "insert into Cliente values (";
            var6 = var6 + "'" + this.rutCliente + "',";
            var6 = var6 + "'" + this.nombreCliente + "',";
            var6 = var6 + "'" + this.direccionCliente + "',";
            var6 = var6 + "'" + this.codigoComuna + "',";
            var6 = var6 + "'" + this.fechaNacimientoCliente + "',";
            var6 = var6 + this.telefonoCliente + ",";
            var6 = var6 + "'" + this.emailCliente + "',";
            var6 = var6 + "'" + this.paginaWebCliente + "',";
            var6 = var6 + "'" + this.codigoTipoCliente + "',";
            var6 = var6 + "'" + this.observacionCliente + "')";
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
            String var6 = "update cliente set ";
            var6 = var6 + "rutcliente = " + "'" + this.rutCliente + "', ";
            var6 = var6 + "nombrecliente = " + "'" + this.nombreCliente + "', ";
            var6 = var6 + "direccioncliente = " + "'" + this.direccionCliente + "', ";
            var6 = var6 + "codigocomuna = " + "'" + this.codigoComuna + "', ";
            var6 = var6 + "fechanacimientocliente = " + "'" + this.fechaNacimientoCliente + "', ";
            var6 = var6 + "telefonocliente = " + this.telefonoCliente + ", ";
            var6 = var6 + "emailcliente = " + "'" + this.emailCliente + "', ";
            var6 = var6 + "paginawebcliente = " + "'" + this.paginaWebCliente + "', ";
            var6 = var6 + "codigotipocliente = " + "'" + this.codigoTipoCliente + "', ";
            var6 = var6 + "observacion = " + "'" + this.observacionCliente + "' where rutcliente = '" + this.rutCliente + "'";
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
            String var6 = "delete from cliente where ";
            var6 = var6 + "rutcliente = '" + this.rutCliente + "'";
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
            String var7 = "select * from cliente where rutcliente = '" + this.rutCliente + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.rutCliente = var8.getString(1);
               this.nombreCliente = var8.getString(2);
               this.direccionCliente = var8.getString(3);
               this.codigoComuna = var8.getString(4);
               this.fechaNacimientoCliente = var8.getString(5);
               this.telefonoCliente = var8.getString(6);
               this.emailCliente = var8.getString(7);
               this.paginaWebCliente = var8.getString(8);
               this.codigoTipoCliente = var8.getString(9);
               this.observacionCliente = var8.getString(10);
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
