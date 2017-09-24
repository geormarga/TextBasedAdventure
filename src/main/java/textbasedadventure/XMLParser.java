package textbasedadventure;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class XMLParser {
    /**
     * Method that manipulates the xml structure to create a NodeList of the existing xml nodes
     *
     * @param pathName XmlFile path
     * @return NodeList from xml file
     */
    static NodeList toNodeList(String pathName) {
        try {
            File fXmlFile = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            return doc.getDocumentElement().getChildNodes();
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Method that takes a NodeList and keeps only the nodes of type ELEMENT
     *
     * @param nodeList the NodeList given
     * @return Cleared out element list
     */
    static List<Element> toElementList(NodeList nodeList) {
        List<Element> elementList = new ArrayList<>();
        for (int index = 0; index < nodeList.getLength(); index++) {
            if (nodeList.item(index).getNodeType() == Node.ELEMENT_NODE) {
                elementList.add((Element) nodeList.item(index));
            }
        }
        return elementList;
    }

    /**
     * Method that gets the child nodes' string values for a parent node given
     *
     * @param parentName The attribute name of the parent node
     * @param nodelist   NodeList to get the child nodes from
     * @return The list of elements as strings
     */
    static List<String> getElements(String parentName, NodeList nodelist) {
        List<Element> elementList = new ArrayList<>();
        List<Element> parentList = toElementList(nodelist);
        for (Element parent : parentList) {
            List<Element> childList = toElementList(parent.getChildNodes());
            elementList.addAll(childList);
        }

        List<String> roomElements = new ArrayList<>();
        for (Element element : elementList) {
            Element parent = (Element) element.getParentNode();
            if (parent.getAttribute("name").equals(parentName)) {
                roomElements.add(element.getFirstChild().getTextContent());
            }
        }
        return roomElements;
    }
}
