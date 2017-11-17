package textbasedadventure.webapp.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

import javax.annotation.PostConstruct;

@Component
public class Persistence {

    private NodeList items;
    private NodeList rooms;

    Persistence() {
    }

    @PostConstruct
    public void init(){
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
