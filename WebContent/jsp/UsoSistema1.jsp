<%String destino = request.getParameter("destino");%>
<%String titulo = request.getParameter("titulo");%>
<HTML>
<HEAD> 
<TITLE>Pastelería La Palmera.</TITLE> 
</HEAD> 
<BODY bgcolor="darkgray"> 
<table>
<tr>
<td>
<img src="logo pasteleria la palmera.png" width="740" height="174"/></td>
</tr>
<tr>
<TD align="center">
<font size="+3"><%=titulo%></font>
</td>
</tr>
</table>
<hr>
<table>
<TR bgcolor="darkgray"> 
  <td width = 50></td>
  <TD >
  <jsp:include page="<%=destino%>" flush="true"/>
  </TD> 
 </TR> 
</TABLE> 
</BODY> 
</HTML>
