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

public class ReadXMLFile {
    /**
     * Method that maps the user given attributes to game contextual objects depending on the current room
     *
     * @param currentRoom The room currently at
     * @param attributes  The command attributes that have been parsed
     */
    void getRoomInDirection(String currentRoom, List<String> attributes) {

        NodeList nodeList = toNodeList("Rooms.xml");
        List<Element> elementList = new ArrayList<>();
        List<Element> parentList = toElementList(nodeList);
        for (Element parent : parentList) {
            List<Element> childList = toElementList(parent.getChildNodes());
            elementList.addAll(childList);
        }

        for (Element element : elementList) {
            Element parent = (Element) element.getParentNode();
            if (parent.getAttribute("name").equals(currentRoom)) {
                for (String attr : attributes) {
                    if (element.getAttribute("name").equals(attr)) {
                        attributes.set(attributes.indexOf(attr), element.getFirstChild().getTextContent());
                    }
                }
            }
        }
    }

    /**
     * Method that takes a NodeList and keeps only the nodes of type ELEMENT
     *
     * @param nodeList the NodeList given
     * @return Cleared out element list
     */
    private List<Element> toElementList(NodeList nodeList) {
        List<Element> elementList = new ArrayList<>();
        for (int index = 0; index < nodeList.getLength(); index++) {
            if (nodeList.item(index).getNodeType() == Node.ELEMENT_NODE) {
                elementList.add((Element) nodeList.item(index));
            }
        }
        return elementList;
    }

    public List<String> getNearbyRooms(String roomName) {
        List<Element> elementList = new ArrayList<>();
        List<Element> parentList = toElementList(toNodeList("Rooms.xml"));
        for (Element parent : parentList) {
            List<Element> childList = toElementList(parent.getChildNodes());
            elementList.addAll(childList);
        }

        List<String> nearbyRooms = new ArrayList<>();
        for (Element element : elementList) {
            Element parent = (Element) element.getParentNode();
            if (parent.getAttribute("name").equals(roomName)) {
                nearbyRooms.add(element.getFirstChild().getTextContent());
            }
        }
        return nearbyRooms;
    }


    public List<String> getRoomItems(String roomName) {
        List<Element> elementList = new ArrayList<>();
        List<Element> parentList = toElementList(toNodeList("Items.xml"));
        for (Element parent : parentList) {
            List<Element> childList = toElementList(parent.getChildNodes());
            elementList.addAll(childList);
        }

        List<String> roomItems = new ArrayList<>();
        for (Element element : elementList) {
            Element parent = (Element) element.getParentNode();
            if (parent.getAttribute("name").equals(roomName)) {
                roomItems.add(element.getFirstChild().getTextContent());
            }
        }
        return roomItems;
    }


    private NodeList toNodeList(String pathName) {
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
}
