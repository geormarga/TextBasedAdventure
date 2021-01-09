package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component("living room")
public class LivingRoom extends Room {

    @Autowired
    public LivingRoom(Map map) {
        name = "living room";
        description = "This is the main Dining Room. The plates on the table indicated that this castle has long been abandoned.";
        hint = "This room is a mess... something happened here!";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }
}
