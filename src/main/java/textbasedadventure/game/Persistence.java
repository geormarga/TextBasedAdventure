package textbasedadventure.game;

import org.w3c.dom.NodeList;

public class Persistence {
    private NodeList items;
    private NodeList rooms;

    Persistence() {
        rooms = XMLParser.toNodeList("Rooms.xml");
        items = XMLParser.toNodeList("Items.xml");
    }

    public NodeList getRooms() {
        return rooms;
    }

    public void setRooms(NodeList rooms) {
        this.rooms = rooms;
    }

    public NodeList getItems() {
        return items;
    }

    public void setItems(NodeList items) {
        this.items = items;
    }
}
