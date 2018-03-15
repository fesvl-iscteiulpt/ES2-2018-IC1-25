package util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {

	private static final Email INSTANCE = new Email();

	private String userMail = "ritapiriquitas@gmail.com";
	private String userPw = "easypremium";
	private String adminMail = "ritapiriquitas@gmail.com";

	private Email() {
	}

	public static Email getInstance() {
		return INSTANCE;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public String getAdminMail() {
		return adminMail;
	}

	public void sendEmailToAdmin(String body) {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// Get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userMail, userPw);
			}
		});

		// Compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(adminMail));
			message.setSubject("Help request from user");
			message.setText(body);
			// Send message
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public boolean isAccountSetup() {
		return userPw != null;
	}

}
