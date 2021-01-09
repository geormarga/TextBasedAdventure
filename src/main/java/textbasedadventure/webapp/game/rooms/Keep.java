package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component("keep")
public class Keep extends Room {

    @Autowired
    public Keep(Map map) {
        name = "keep";
        description = "You are in the keep. Unfortunately there's no visible path from which you can enter.";
        hint = "You see something shining in a mudpit. A silver chest lies on the ground.";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }
}
