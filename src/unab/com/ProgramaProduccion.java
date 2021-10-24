package unab.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProgramaProduccion {
   private String codigoOrdenFabricacion = "";
   private String fechaProgramaProduccion = "";
   private String horaProgramaProduccion = "";
   private String codigoProducto = "";
   private String codigoLineaProduccion = "";
   private String cantidadProgramada = "";
   private String cantidadFabricada = "";
   private String saldoPorFabricar = "";
   private String estadoOrdenFabricacion = "";
   private String numeroPedido = "";
   private String fechaPedido = "";

   public void setCodigoOrdenFabricacion(String var1) {
      this.codigoOrdenFabricacion = var1;
   }

   public void setFechaProgramaProduccion(String var1) {
      this.fechaProgramaProduccion = var1;
   }

   public void setHoraProgramaProduccion(String var1) {
      this.horaProgramaProduccion = var1;
   }

   public void setCodigoProducto(String var1) {
      this.codigoProducto = var1;
   }

   public void setCodigoLineaProduccion(String var1) {
      this.codigoLineaProduccion = var1;
   }

   public void setCantidadProgramada(String var1) {
      this.cantidadProgramada = var1;
   }

   public void setCantidadFabricada(String var1) {
      this.cantidadFabricada = var1;
   }

   public void setSaldoPorFabricar(String var1) {
      this.saldoPorFabricar = var1;
   }

   public void setEstadoOrdenFabricacion(String var1) {
      this.estadoOrdenFabricacion = var1;
   }

   public void setNumeroPedido(String var1) {
      this.numeroPedido = var1;
   }

   public void setFechaPedido(String var1) {
      this.fechaPedido = var1;
   }

   public String getCodigoOrdenFabricacion() {
      return this.codigoOrdenFabricacion;
   }

   public String getFechaProgramaProduccion() {
      return this.fechaProgramaProduccion;
   }

   public String getHoraProgramaProduccion() {
      return this.horaProgramaProduccion;
   }

   public String getCodigoProducto() {
      return this.codigoProducto;
   }

   public String getCodigoLineaProduccion() {
      return this.codigoLineaProduccion;
   }

   public String getCantidadProgramada() {
      return this.cantidadProgramada;
   }

   public String getCantidadFabricada() {
      return this.cantidadFabricada;
   }

   public String getSaldoPorFabricar() {
      return this.saldoPorFabricar;
   }

   public String getEstadoOrdenFabricacion() {
      return this.estadoOrdenFabricacion;
   }

   public String getNumeroPedido() {
      return this.numeroPedido;
   }

   public String getFechaPedido() {
      return this.fechaPedido;
   }

   public int grabar() {
      int var1 = 0;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "insert into ProgramaProduccion values (";
            var7 = var7 + "'" + this.codigoOrdenFabricacion + "',";
            var7 = var7 + "'" + this.fechaProgramaProduccion + "',";
            var7 = var7 + "'" + this.horaProgramaProduccion + "',";
            var7 = var7 + "'" + this.codigoProducto + "',";
            var7 = var7 + "'" + this.codigoLineaProduccion + "',";
            var7 = var7 + this.cantidadProgramada + ",";
            var7 = var7 + this.cantidadFabricada + ",";
            var7 = var7 + this.saldoPorFabricar + ",";
            var7 = var7 + "'" + this.estadoOrdenFabricacion + "')";
            System.out.println(var7);
            var1 = var6.executeUpdate(var7);
            if (var1 == 1) {
               System.out.println("OK");
            }

            var6.close();
            var5.close();
         }

         return var1;
      } catch (Exception var8) {
         System.out.println(var8);
         return var1;
      }
   }

   public int modificar() {
      int var1 = 0;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "update programaproduccion set ";
            var7 = var7 + "codigoordenfabricacion = " + "'" + this.codigoOrdenFabricacion + "', ";
            var7 = var7 + "fechaprogramaproduccion = " + "'" + this.fechaProgramaProduccion + "', ";
            var7 = var7 + "horaprogramaproduccion = " + "'" + this.horaProgramaProduccion + "', ";
            var7 = var7 + "codigoproducto = " + "'" + this.codigoProducto + "', ";
            var7 = var7 + "codigolineaproduccion = " + "'" + this.codigoLineaProduccion + "', ";
            var7 = var7 + "cantidadprogramada = " + "" + this.cantidadProgramada + ", ";
            var7 = var7 + "cantidadfabricada = " + "" + this.cantidadFabricada + ", ";
            var7 = var7 + "saldoporfabricar = " + "" + this.saldoPorFabricar + ", ";
            var7 = var7 + "estadoordenfabricacion = " + "'" + this.estadoOrdenFabricacion + "' ";
            var7 = var7 + " where codigoordenfabricacion = '" + this.codigoOrdenFabricacion + "'";
            System.out.println(var7);
            var1 = var6.executeUpdate(var7);
            if (var1 == 1) {
               System.out.println("OK");
            }

            var6.close();
            var5.close();
         }

         return var1;
      } catch (Exception var8) {
         System.out.println(var8);
         return var1;
      }
   }

   public int eliminar() {
      int var1 = 0;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "delete from programaproduccion where ";
            var7 = var7 + "codigoordenfabricacion = '" + this.codigoOrdenFabricacion + "'";
            System.out.println(var7);
            var1 = var6.executeUpdate(var7);
            if (var1 == 1) {
               System.out.println("OK");
            }

            var6.close();
            var5.close();
         }

         return var1;
      } catch (Exception var8) {
         System.out.println(var8);
         return var1;
      }
   }

   public boolean buscar() {
      boolean var1 = false;
      String var2 = "root";
      String var3 = "jochua";
      String var4 = "jdbc:mysql://localhost/lapalmera";
      Connection var5 = null;

      try {
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         var5 = DriverManager.getConnection(var4, var2, var3);
         if (var5 != null) {
            Statement var6 = var5.createStatement();
            String var7 = "select * from programaproduccion where codigoordenfabricacion = '" + this.codigoOrdenFabricacion + "'";
            System.out.println(var7);
            ResultSet var8 = var6.executeQuery(var7);
            if (var8.next()) {
               System.out.println("Lo encontro");
               this.codigoOrdenFabricacion = var8.getString(1);
               this.fechaProgramaProduccion = var8.getString(2);
               this.horaProgramaProduccion = var8.getString(3);
               this.codigoProducto = var8.getString(4);
               this.codigoLineaProduccion = var8.getString(5);
               this.cantidadProgramada = var8.getString(6);
               this.cantidadFabricada = var8.getString(7);
               this.saldoPorFabricar = var8.getString(8);
               this.estadoOrdenFabricacion = var8.getString(9);
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
