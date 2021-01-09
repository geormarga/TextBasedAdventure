package textbasedadventure.webapp.game;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.FeatureFactory;
import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.rooms.Room;

@Component
public class State {

    @Autowired
    @Qualifier("starting room")
    private Room currentRoom;
    @Autowired
    @Qualifier("starting room")
    private Room previousRoom;
    @Autowired
    private Inventory inventory;
    @Autowired
    private FeatureFactory featureFactory;
    @Autowired
    private Map map;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public FeatureFactory getFeatureFactory() {
        return featureFactory;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public State() {
    }

    @PostConstruct
    private void init(){
        System.out.println(this.currentRoom.getDescription());
    }
}
