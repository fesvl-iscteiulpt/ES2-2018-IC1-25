package util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ConfigManager {

	private static final String CONFIG_FNAME = "config/config.xml";

	public void loadConfig() throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new File(CONFIG_FNAME));

		// Read the administrator email
		Email.getInstance()
				.setAdminMail(doc.getElementsByTagName("administratorEmail").item(0).getTextContent().trim());
	}
}
