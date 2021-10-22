Datos de Cliente
<table>
<tr>
<td>
<p>Nombre: *1 </p>	  
</td>
<td>
<input name = "nombre" type="text" size="40" value="<%=nombre%>"/>      
</td>
</tr>
<tr>
<td>
<p>Apellido: *1 </p>	  
</td>
<td>
<input name = "apellido" type="text" size="40" value="<%=apellido%>"/>      
</td>
</tr>
<tr>
<td>
<p>Direcci&oacute;n: *1 </p>	  
</td>
<td>
<input name="direccion" type="text" size="40" value="<%=direccion%>"/>	  
</td>
</tr>
<tr>
<td>
<p>T&eacute;lefono:*1*2 </p>	  
</td>
<td> 
<input name="telefono" type="text" size="40" value="<%=telefono%>"/>	  
</td>
</tr>
<tr>
<td>
<p>Fecha de Nacimiento:</p>	  
</td>
<td>
<input type="text" name="fechanacimiento" id="campo_fecha" value="<%=fechanacimiento%>"/>
<input type="button" id="lanzador" value="...">
<!-- script que define y configura el calendario--> 
<script type="text/javascript">
Calendar.setup({
inputField     :    "campo_fecha",     // id del campo de texto
ifFormat     :     "%Y-%m-%d",     // formato de la fecha que se escriba en el campo de texto
button     :    "lanzador"     // el id del botón que lanzará el calendario
});
</script>
</td>
<!--td> 
<input name="fechanacimiento" type="text" size="40" value="<%--=fechanacimiento--%>"/>	  
</td-->
</tr>
<tr>
<td>
<p>E-mail: </p>	  
</td>
<td> 
<input name="email" type="text" size="40" value="<%=email%>"/>	  
</td>
</tr>
<tr>
<td colspan="2">
<p>*1 Datos Obligatorios</p>
</td>
</tr>
<tr>
<td colspan="2">
<p>*2 A este n&uacute;mero se confirmar&aacute; el pedido. Se llamar&aacute; de parte de "Pasteler&iacute;a La Palmera"</p>
</td>
</tr>
</table>

Datos para el Despacho

<table>
<tr>
<td>
<p>Direcci&oacute;n: *1 </p>					
</td>
<td>
<input name="direcciondespacho" type="text" size="40" value="<%=direcciondespacho%>"/>
</td>
</tr>
<tr>
<td>
<p>Fecha de Entrega: *1</p>					
</td>
<td>
<input type="text" name="fechaentrega" id="campo_fecha" value="<%=fechaentrega%>"/>
<input type="button" id="lanzador" value="..."/>
<!-- script que define y configura el calendario-->
<script type="text/javascript">
Calendar.setup({
inputField     :    "campo_fecha",     // id del campo de texto
ifFormat     :     "%Y-%m-%d",     // formato de la fecha que se escriba en el campo de texto
button     :    "lanzador"     // el id del botón que lanzará el calendario
});
</script>
</td>
</tr>
<tr>
<td>
<p>Hora de Entrega: *1 </p>					
</td>
<td><select name="horaentrega">
<option><%=horaentrega%>
<option>10:00-12:00
<option>12:00-14:00
<option>14:00-16:00
<option>16:00-18:00
<option>18:00-20:00
</select></td>
</tr>
<tr>
<td colspan="2">
<p>*1 Datos Obligatorios</p></td>
</tr>
</table>

Comentario
<table>
<tr>
<td>
<textarea name="comentario" rows="5" cols="55" ><%=comentario%></textarea>
</td>
</tr>
</table>

<table>
<tr>
<td>
Confirmar Pedido
</td>
</tr>
<tr>
<td>
Por Confirmar
</td>
<td>
<input type="radio" name="confirmacion" value="I"/> 
</td>
</tr>
<tr>
<td>
Confirmado
</td>
<td>
<input type="radio" name="confirmacion" value="C"/> 
</td>
<tr>
<td>
Rechazado
</td>
<td>
<input type="radio" name="confirmacion" value="R"/> 
</td>
</tr>
</table>