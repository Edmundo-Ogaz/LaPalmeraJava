<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*, javax.mail.*, javax.mail.internet.*" %>
<html>
<head>
<title>prueba envio mail con JSP pu</title>
</head>
<body bgcolor="#C0C0C0" text="#CC0000" >
<%
if(request.getMethod().equals("POST") )
{
boolean status = true;
// enter here the smtp mail server address
// ask your ISP to get the proper name
String mailServer = request.getParameter("smtp");
String toEmail = request.getParameter("to");
String fromEmail = request.getParameter("from");
String messageEnter = request.getParameter("message");
if(toEmail.equals("") )
toEmail = "unknown";
try
{
Properties props = new Properties();
            //props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.host", mailServer);
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "e.jeshua@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

//preparamos la sesion
Session sesion = Session.getDefaultInstance(props);
//contruimos el mensaje
MimeMessage message = new MimeMessage(sesion);
            //message.setFrom(new InternetAddress("yo@yo.com"));
			message.setFrom(new InternetAddress(toEmail));
            //message.addRecipient(Message.RecipientType.TO,new InternetAddress("e.jeshua@gmail.com"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(fromEmail));
            message.setSubject("Hola");
            //message.setText("Stock Critico ");
			message.setText(messageEnter);
//lo enviamos
Transport t = sesion.getTransport("smtp");
            t.connect("e.jeshua@gmail.com", "jochua");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
}
catch(NullPointerException n)
{
System.out.println(n.getMessage() );
out.println("ERROR, deve ingresar un mensaje, maldito irisworker!!!");
status = false;
}
catch (Exception e)
{
System.out.println(e.getMessage() );
out.println("ERROR, El mensaje para " + toEmail + " Fallo Cua Cuaaa, la razon es: " + e);
status = false;
}
if (status == true)
{
out.println("Su Mensaje para " + toEmail + " se envio correctamente bla bla HAGGG!");
}
}
else
{
%>
<h1><font color="#000099">Prueba de envio de mail con JSP</font></h1>
<form method="post" name="mail" action="test2.jsp">
<table BORDER="0">
<tr>
<td><font color="#000099">Smtp :</font></td>
<td><input type="text" name="smtp" size=24></td>
</tr>
<p>
<tr>
<td><font color="#000099">De :</font></td>
<td><input type="text" name="to" size=24></td>
</tr>
<p>
<tr>
<td><font color="#000099">Para :</font></td>
<td><input type="text" name="from" size=24></td>
</tr>
<p>
<tr>
<td><font color="#000099">Mensaje</font> :</td>
<td><TEXTAREA name="message" ROWS = "5" COLS="65"></TEXTAREA></td>
</tr>
</table>
<p>
<font face="Helvetica">
<input type="submit"
value="Enviar" name="Command">
</font>
</form>
<%
}
%>
</body>
</html>
