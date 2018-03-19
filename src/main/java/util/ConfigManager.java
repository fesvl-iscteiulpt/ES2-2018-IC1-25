package util;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigManager {

	private static final ConfigManager INSTANCE = new ConfigManager();
	private static final String CONFIG_FNAME = "src\\main\\resources\\XML Files\\config.xml";

	private ConfigManager() {
	}

	public static ConfigManager getInstance() {
		return INSTANCE;
	}

	public void loadConfig(String filePath)
			throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(filePath);
		doc.getDocumentElement().normalize();

		// Read administrators
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr = xpath.compile("/XML/Administrators/Administrator/@*");
		NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		for (int i = 0; i < nl.getLength(); i++) {
			if (nl.item(i).getNodeName().equalsIgnoreCase("email")) {
				Email.getInstance().addAdminMail(nl.item(i).getFirstChild().getNodeValue());
			}
		}

	}

	public static String getConfigFile() {
		return CONFIG_FNAME;
	}

}
