package util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {

	private static final Email INSTANCE = new Email();
	private List<String> administrators = new ArrayList<String>();

	private String userMail;

	private String systemMail = "es2018g25system@gmail.com";
	private String systemPw = "ES2018G25PASS";

	private Email() {
	}

	public static Email getInstance() {
		return INSTANCE;
	}

	// public void setUserMail(String userMail) {
	// this.userMail = userMail;
	// }

	// public void setUserPw(String userPw) {
	// this.userPw = userPw;
	// }

	public void addAdminMail(String adminMail) {
		administrators.add(adminMail);
	}

	public void sendEmailToAdmins(String body) {
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
				return new PasswordAuthentication(systemMail, systemPw);
			}
		});

		// Compose message
		for (String adminAdress : administrators)
			try {
				MimeMessage message = new MimeMessage(session);
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(adminAdress));
				message.setSubject("Help request from user " + userMail);
				message.setText(body);
				// Send message
				Transport.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	}

	public List<String> getAdministrators() {
		return administrators;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public boolean isAccountSetup() {
		return !(userMail == null);
	}

}
