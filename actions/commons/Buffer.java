package FrameWork;

import java.io.File;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Buffer {
	static String sBufferPath = Constant.sProjectPath + "\\src\\FrameWork\\Buffer.xml";
	static File f = new File(sBufferPath);

	public static String Get(String sKeyName) throws Exception {
		if (!f.exists()) {
			sBufferPath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\classes\\FrameWork\\Buffer.xml";
		}
		String sReturn = "";
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(sBufferPath);

			// Find the collection of KWs has name equals KW name
			XPath xPath = XPathFactory.newInstance().newXPath();
			String sKeyXpath = "//Key[@Name='" + sKeyName + "']";
			NodeList nodeList = (NodeList) (xPath).compile(sKeyXpath).evaluate(doc, XPathConstants.NODESET);

			if (nodeList.getLength() > 0) {
				Node nKeyNode = nodeList.item(0);
				sReturn = nKeyNode.getTextContent();
			} else {
				Log.Fail("Get Variable from Buffer File", "Not found key [" + sKeyName + "], check your input");
			}
		} catch (Exception ex) {
			Log.Fail("Get Variable from Buffer File - Unknown Error", ex.toString());
		}
		return sReturn;
	}

	public static String Add(String sKeyName, String sValue) throws Exception {
		if (!f.exists()) {
			sBufferPath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\classes\\FrameWork\\Buffer.xml";
		}
		String sReturn = "Not found key in buffer";
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(sBufferPath);

			// Find the collection of KWs has name equals KW name
			XPath xPath = XPathFactory.newInstance().newXPath();
			String sKeyXpath = "//Key[@Name='" + sKeyName + "']";
			NodeList nodeList = (NodeList) (xPath).compile(sKeyXpath).evaluate(doc, XPathConstants.NODESET);
			if (nodeList.getLength() > 0) {
				Node nKeyNode = nodeList.item(0);
				nKeyNode.setTextContent(sValue);
			} else {
				org.w3c.dom.Element eNewKey = doc.createElement("Key");
				eNewKey.setAttribute("Name", sKeyName);
				eNewKey.appendChild(doc.createTextNode(sValue));
				doc.getDocumentElement().appendChild((Node) eNewKey);
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(sBufferPath));
			transformer.transform(source, result);
		} catch (Exception ex) {
			Log.Fail("Add Variable to Buffer File - Unknown Error", ex.toString());
		}
		return sReturn;
	}

	public static String Remove(String sKeyName) throws Exception {
		if (!f.exists()) {
			sBufferPath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\classes\\FrameWork\\Buffer.xml";
		}
		String sReturn = "Not found key in buffer";
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(sBufferPath);

			// Find the collection of KWs has name equals KW name
			XPath xPath = XPathFactory.newInstance().newXPath();
			String sKeyXpath = "//Key[@Name='" + sKeyName + "']";
			NodeList nodeList = (NodeList) (xPath).compile(sKeyXpath).evaluate(doc, XPathConstants.NODESET);

			if (nodeList.getLength() > 0) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					nodeList.item(i).getParentNode().removeChild(nodeList.item(i));
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(sBufferPath));
			transformer.transform(source, result);
		} catch (Exception ex) {
			Log.Fail("Remove Variable from Buffer File - Unknown Error", ex.toString());
		}
		return sReturn;
	}
}
