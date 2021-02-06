package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component("castle")
public class Castle extends Room {

    @Autowired
    public Castle(Map map) {
        name = "castle";
        description = "You are in the castle yard. You are free to go in, but there is also a cave to the west...";
        hint = "You found a chest on the ground.";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }
}
