package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorCliente {
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
            String var7 = "select * from Cliente where 1 = 1 ";
            if (!this.rutCliente.equals("")) {
               var7 = var7 + "     and rutCliente = '" + this.rutCliente + "'";
            }

            if (!this.nombreCliente.equals("")) {
               var7 = var7 + "     and nombreCliente = '" + this.nombreCliente + "'";
            }

            if (!this.direccionCliente.equals("")) {
               var7 = var7 + "     and direccionCliente = '" + this.direccionCliente + "'";
            }

            if (!this.codigoComuna.equals("")) {
               var7 = var7 + "     and codigoComuna = '" + this.codigoComuna + "'";
            }

            if (!this.fechaNacimientoCliente.equals("")) {
               var7 = var7 + "     and fechaNacimientoCliente = " + this.fechaNacimientoCliente;
            }

            if (!this.telefonoCliente.equals("")) {
               var7 = var7 + "     and telefonoCliente = " + this.telefonoCliente;
            }

            if (!this.emailCliente.equals("")) {
               var7 = var7 + "     and emailCliente = '" + this.emailCliente + "'";
            }

            if (!this.paginaWebCliente.equals("")) {
               var7 = var7 + "     and paginaWebCliente = '" + this.paginaWebCliente + "'";
            }

            if (!this.codigoTipoCliente.equals("")) {
               var7 = var7 + "     and codigoTipoCliente = '" + this.codigoTipoCliente + "'";
            }

            if (!this.observacionCliente.equals("")) {
               var7 = var7 + "     and observacionCliente = '" + this.observacionCliente + "'";
            }

            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Cliente var9 = new Cliente();
               var9.setRutCliente(var8.getString(1));
               var9.setNombreCliente(var8.getString(2));
               var9.setDireccionCliente(var8.getString(3));
               var9.setCodigoComuna(var8.getString(4));
               var9.setFechaNacimientoCliente(var8.getString(5));
               var9.setTelefonoCliente(var8.getString(6));
               var9.setEmailCliente(var8.getString(7));
               var9.setPaginaWebCliente(var8.getString(8));
               var9.setCodigoTipoCliente(var8.getString(9));
               var9.setObservacionCliente(var8.getString(10));
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
