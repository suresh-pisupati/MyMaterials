package com.suresh.paletteconfig.component;

import org.springframework.stereotype.Component;

@Component
public class Scheduler {

   /*
    * @Scheduled(fixedRate = 1000) public void displayDate() { SimpleDateFormat sdf = new
    * SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" ); Date now = new Date(); String strDate =
    * sdf.format( now ); System.out.println( "Java cron job expression:: " + strDate ); }
    */
   // private void sendMail() throws MessagingException, IOException {
   //
   // // Recipient's email ID needs to be mentioned.
   // String to = "suresh.pisupati1981@gmail.com";
   //
   // // Sender's email ID needs to be mentioned
   // String from = "sureshkumarsharma547@gmail.com";
   //
   // String host = "smtp.gmail.com";
   //
   // String port = "587";
   //
   // // Get system properties
   // Properties properties = System.getProperties();
   //
   // // Setup mail server
   // properties.put( "mail.transport.protocol", "smtp" );
   // properties.put( "mail.smtp.port", port );
   // properties.put( "mail.smtp.host", host );
   //
   // // Setup the port
   // // properties.put( "mail.smtp.port", port );
   //
   // // Get the default Session object.
   // // create the Session object
   // Session session = Session.getDefaultInstance( properties );
   //
   // try {
   // // Create a default MimeMessage object.
   // MimeMessage message = new MimeMessage( session );
   //
   // // Set From: header field of the header.
   // message.setFrom( new InternetAddress( from ) );
   //
   // // Set To: header field of the header.
   // message.addRecipient( Message.RecipientType.TO, new InternetAddress( to ) );
   //
   // // Set Subject: header field
   // message.setSubject( "This is the Subject Line!" );
   //
   // // Now set the actual message
   // message.setText( "This is actual message" );
   //
   // // Send message
   // Transport.send( message );
   // System.out.println( "Sent message successfully...." );
   // }
   // catch( MessagingException mex ) {
   // mex.printStackTrace();
   // }
   // }

   // public void
}
