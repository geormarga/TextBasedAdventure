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

    /**
     * Method that gets the adjacent rooms as defined in the xml file
     *
     * @param roomName The name of the room
     * @return The adjacent rooms for the specified roomName
     */
    public List<String> getNearbyRooms(String roomName) {
        return getElements(roomName, "Rooms.xml");
    }


    /**
     * Method that gets a room's items as defined in the xml file
     *
     * @param roomName The name of the room
     * @return The contained items for the specified roomName
     */
    public List<String> getRoomItems(String roomName) {
        return getElements(roomName, "Items.xml");
    }


    /**
     * Method that gets all the available commands to validate against
     *
     * @return A list of the available commands
     */
    List<String> getCommands() {
        List<String> commands = new ArrayList();
        NodeList nodelist = toNodeList("CommandList.xml");
        List<Element> elements = toElementList(nodelist);
        elements.forEach(element -> commands.add(element.getAttribute("name")));
        return commands;
    }

    /**
     * Method that gets a commands's attributes as defined in the xml file
     *
     * @param command The string representing a command name
     * @return The contained attributes for the specified command
     */
    List<String> getAttributes(String command) {
        return getElements(command, "CommandList.xml");
    }

    /**
     * Method that gets the child nodes' string values for a parent node given
     *
     * @param parentName The attribute name of the parent node
     * @param pathName   XmlFile path
     * @return The list of elements in string
     */
    private List<String> getElements(String parentName, String pathName) {
        List<Element> elementList = new ArrayList<>();
        List<Element> parentList = toElementList(toNodeList(pathName));
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

    /**
     * Method that manipulates the xml structure to create a NodeList of the existing xml nodes
     *
     * @param pathName XmlFile path
     * @return NodeList from xml file
     */
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
