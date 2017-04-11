package textbasedadventure;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

import java.io.File;
import java.util.List;


class ReadXMLFile {
    private File fXmlFile;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;


    /**
     * Method that maps the user given attributes to game contextual objects depending on the state
     * @param state The state object of the game
     * @param attributes The command attributes that have been parsed
     */
    void translate(State state, List<String> attributes) {
        try {

            fXmlFile = new File("Map.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            String roomName = state.getCurrentRoom().getName();
            NodeList nList = doc.getDocumentElement().getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    if (element.getAttribute("name").equals(roomName)) {
                        NodeList roomsList = element.getChildNodes();
                        for (int roomsIndex = 0; roomsIndex < roomsList.getLength(); roomsIndex++) {
                            Node roomNode = roomsList.item(roomsIndex);
                            if (roomNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element roomElement = (Element) roomNode;
                                for (String attr : attributes) {
                                    if (roomElement.getAttribute("name").equals(attr)) {
                                        attributes.set(attributes.indexOf(attr), roomElement.getFirstChild().getTextContent());
                                    }
                                }
                            }
                        }
                    }

                }
            }
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }
    }
}
