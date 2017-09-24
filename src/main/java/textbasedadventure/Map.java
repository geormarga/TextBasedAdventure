package textbasedadventure;

import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private Persistence persistence = new Persistence();

    /**
     * Method that maps the user given attributes to game contextual objects depending on the current room
     *
     * @param currentRoom The room currently at
     * @param attributes  The command attributes that have been parsed
     */
    void getRoomInDirection(String currentRoom, List<String> attributes) {

        List<Element> elementList = new ArrayList<>();
        List<Element> parentList = XMLParser.toElementList(persistence.getRooms());
        for (Element parent : parentList) {
            List<Element> childList = XMLParser.toElementList(parent.getChildNodes());
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
     * Method that gets the adjacent rooms as defined in the xml file
     *
     * @param roomName The name of the room
     * @return The adjacent rooms for the specified roomName
     */
    public List<String> getNearbyRooms(String roomName) {
        return XMLParser.getElements(roomName, persistence.getRooms());
    }

    /**
     * Method that gets a room's items as defined in the xml file
     *
     * @param roomName The name of the room
     * @return The contained items for the specified roomName
     */
    public List<String> getRoomItems(String roomName) {
        return XMLParser.getElements(roomName, persistence.getItems());
    }



}
