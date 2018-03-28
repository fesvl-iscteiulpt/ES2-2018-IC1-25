package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLManager {

	private static final XMLManager INSTANCE = new XMLManager();
	private static final String CONFIG_FNAME = "src\\main\\resources\\XML Files\\config.xml";

	private XMLManager() {
	}

	public static XMLManager getInstance() {
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

	public void saveProblem(String filePath) throws ParserConfigurationException, SAXException, IOException,
			TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();

		Element root = doc.createElement("PROBLEM");
		doc.appendChild(root);

		// Saves problem description
		Element newElement1 = doc.createElement("Description");
		newElement1.setAttribute("Name", "Joaquim");
		newElement1.setAttribute("Description", "joaquim@iscte-iul.pt");
		newElement1.setAttribute("MaxDuration", "60");
		newElement1.setAttribute("RulesName", "ul.pt");
		newElement1.setAttribute("Rows", "30");
		root.appendChild(newElement1);

		// Saves variables
		Element variablesElement = doc.createElement("Variables");
		root.appendChild(variablesElement);

		Element variableElement = doc.createElement("Variable");
		variableElement.setAttribute("Name", "VariableName");
		variableElement.setAttribute("MinInterval", "Min");
		variableElement.setAttribute("MaxInterval", "Max");
		variableElement.setAttribute("Type", "Boolean");
		variablesElement.appendChild(variableElement);

		Element variableElement2 = doc.createElement("Variable");
		variableElement2.setAttribute("Name", "VariableName2");
		variableElement2.setAttribute("MinInterval", "Min2");
		variableElement2.setAttribute("MaxInterval", "Max2");
		variableElement2.setAttribute("Type", "Boolean2");
		variablesElement.appendChild(variableElement2);

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		StreamResult result = new StreamResult(new FileOutputStream(filePath));
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
	}

	public static String getConfigFile() {
		return CONFIG_FNAME;
	}

}
