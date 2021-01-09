package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component("hall")
public class Hall extends Room {

    @Autowired
    public Hall(Map map) {
        name = "hall";
        description = "You went inside the Castle. It's vast halls seem haunted";
        hint = "You can see some rooms left and right ... and stairs heading down.";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }
}
