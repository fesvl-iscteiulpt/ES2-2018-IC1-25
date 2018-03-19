package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import util.ConfigManager;
import util.Email;

class ConfigManagerTest {

	@Test
	void testLoadConfig() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		ConfigManager.getInstance().loadConfig("src/test/resources/config_test.xml");
		assertEquals("teste1@mail.com", Email.getInstance().getAdministrators().get(0));
		assertEquals("teste2@mail.com", Email.getInstance().getAdministrators().get(1));
	}
}
