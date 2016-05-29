package com.softserve.edu.listener;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.softserve.edu.atqc.loggers.LoggerUtils;
 
public class SendEmail {
	private static final String MES_PROBLEM_WITH_ADDRESS = "Some problem with address";
	private static final String MES_PROBLEM_WITH_CONNECT_TO_SMTP = "Some problem with connect to smtp";
	private static final String SUBJECT = "Result of tests running";
	private static final String RECIPIENT_TO = "test@gmail.com";
	private static final String RECIPIENT_CC = "test@gmail.com";
	private static final String USER_ID = "test@gmail.com";
	private static final String USER_PASSWORD = "testPass";
	private static final String PROTOCOL_NAME = "smtp";
	private static final String FILE_PATH = "./test-output/TestLogs.log";
	
	public static void sendDefaultEmail() {
		setupPropertiesToServerSMTP();
		connectionUsingTransportProtocol(getSession(), setupMailDetails());
	}
	
	public static Properties setupPropertiesToServerSMTP() {
		Properties serverProperties = System.getProperties();
		serverProperties.put("mail.smtp.auth", "true");
		serverProperties.put("mail.smtp.starttls.enable", "true");
		serverProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		serverProperties.put("mail.smtp.host", "smtp.gmail.com");
		serverProperties.put("mail.smtp.port", "587");
		return serverProperties;
	}
	
	public static MimeMessage setupMailDetails() {
		MimeMessage mailMessage = new MimeMessage(getSession());
		try {
			mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(RECIPIENT_TO));
			mailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(RECIPIENT_CC));
			mailMessage.setSubject(SUBJECT);
			mailMessage.setContent(attachmentFile());
		} catch (AddressException e) {
			LoggerUtils.get().errorLog(MES_PROBLEM_WITH_ADDRESS + e);
		} catch (MessagingException e) {
			LoggerUtils.get().errorLog(MES_PROBLEM_WITH_CONNECT_TO_SMTP + e);
		}
		return mailMessage;
	}

	public static Session getSession() {
		return Session.getDefaultInstance(setupPropertiesToServerSMTP(), null);
	}
	
	public static void connectionUsingTransportProtocol(Session session, MimeMessage mailMessage) {
		try {
			Transport transport = session.getTransport(PROTOCOL_NAME);
			transport.connect(USER_ID, USER_PASSWORD);
			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
			transport.close();
		} catch (MessagingException e ) {
			LoggerUtils.get().errorLog(MES_PROBLEM_WITH_CONNECT_TO_SMTP + e);
		} 
	}
	
	public static Multipart attachmentFile() throws MessagingException {
		// Create the message part 
        BodyPart messageBodyPart = new MimeBodyPart();
        // Fill the message
        messageBodyPart.setText("Result of tests running is below");
        // Create a multipar message
        Multipart multipart = new MimeMultipart();
        // Set text message part
        multipart.addBodyPart(messageBodyPart);
        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        String filename = FILE_PATH;
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        return multipart;
	}
}