package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import util.ConfigManager;
import util.Email;

class EmailTest {

	@Test
	void testSendEmailToAdmins()
			throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		ConfigManager.getInstance().loadConfig("src/test/resources/config_test.xml");
		Email.getInstance().sendEmailToAdmins("JUnit test email");
	}

}
