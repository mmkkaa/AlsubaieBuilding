

import java.io.UnsupportedEncodingException;
import java.util.*;  
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;  



public class SendEmail  {  
	
	static public void sendEmail () { 
      String to = MainWindow.getEmail(); 
      final String from = "buildingalsubaie@gmail.com"; 
     
     //Get the session object  
      Properties props = System.getProperties();  
      props.setProperty("mail.smtp.host", "smtp.gmail.com");
      props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.setProperty("mail.smtp.socketFactory.fallback", "false");
      props.setProperty("mail.smtp.port", "465");
      props.setProperty("mail.smtp.socketFactory.port", "465");
      props.put("mail.smtp.auth", "true");
      props.put("mail.debug", "true");
      props.put("mail.store.protocol", "pop3");
      props.put("mail.transport.protocol", "smtp"); 
      
      Session  session = Session.getDefaultInstance(props, 
              new Authenticator(){
          protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(from,"Khadim1234");
          }});
      
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress( from, "Alsubaie Building" ));  
         message.setRecipients(Message.RecipientType.TO, 
                 InternetAddress.parse(to,false)); 
         message.setSubject("Username/Password Recovery");  
         message.setText("Dear " + MainWindow.getAdminName() +"," +
        		 "\r\n" +
                 "\r\n"+
                 "\r\n"+
                 
               
         "\r\n" + "    Your Username is: " + MainWindow.getUsername() + 
         "\r\n" + "    Your Password is: " + MainWindow.getPassword() +
         "\r\n" +
         "\r\n" +
         "\r\n"+
         "\r\n"+
         
         "\r\n" + "Kind Regards, " +
         
         "\r\n" + "Alsubaie Building Team" ); 
         
         message.setSentDate(new Date());
  
         // Send message  
         Transport.send(message);  
         System.out.println("message sent successfully....");  
  
      }catch (MessagingException mex) {mex.printStackTrace();} catch (UnsupportedEncodingException e) {
	
		e.printStackTrace();
	}  
	}
}  
