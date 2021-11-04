package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejadorFuncionario {
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
            String var7 = "select * from funcionario where 1 = 1 ";
            if (!this.rutFuncionario.equals("")) {
               var7 = var7 + "     and rutFuncionario = '" + this.rutFuncionario + "'";
            }

            if (!this.nombreFuncionario.equals("")) {
               var7 = var7 + "     and nombreFuncionario = '" + this.nombreFuncionario + "'";
            }

            if (!this.apellidoPaternoFuncionario.equals("")) {
               var7 = var7 + "     and apellidoPaternoFuncionario = '" + this.apellidoPaternoFuncionario + "'";
            }

            if (!this.apellidoMaternoFuncionario.equals("")) {
               var7 = var7 + "     and apellidoMaternoFuncionario = '" + this.apellidoMaternoFuncionario + "'";
            }

            if (!this.codigoCargo.equals("")) {
               var7 = var7 + "     and codigoCargo = '" + this.codigoCargo + "'";
            }

            if (!this.codigoArea.equals("")) {
               var7 = var7 + "     and codigoArea = '" + this.codigoArea + "'";
            }

            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);

            while(var8.next()) {
               Funcionario var9 = new Funcionario();
               var9.setRutFuncionario(var8.getString(1));
               var9.setNombreFuncionario(var8.getString(2));
               var9.setApellidoPaternoFuncionario(var8.getString(3));
               var9.setApellidoMaternoFuncionario(var8.getString(4));
               var9.setCodigoCargo(var8.getString(5));
               var9.setCodigoArea(var8.getString(6));
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
