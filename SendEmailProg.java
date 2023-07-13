

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailProg {

    public static void main(String[] args) {
    	

        final String username = "roygari@gmail.com";
    	//final String username = "epharmacy";
        final String password = "ikaobsiwxglyxsgz";
    	//final String password = "abcd123456$";
        String to = "garima.roy139@gmail.com";
        String from ="roygari@gmail.com";
        //String from ="epharmacy@manipalhospitals.com";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        //prop.put("mail.smtp.host", "mail.manipalhospitals.com");
        //prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("roygari@gmail.com"));
            //message.setFrom(new InternetAddress("epharmacy@manipalhospitals.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("garima.roy139@gmail.com")
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}