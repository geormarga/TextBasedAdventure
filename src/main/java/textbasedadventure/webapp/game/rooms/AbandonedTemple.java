package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component("abandoned temple")
public class AbandonedTemple extends Room {

    @Autowired
    public AbandonedTemple(Map map) {
        name = "abandoned temple";
        description = "This is the temple of sunlight. Many pilgrims through the years came"
                + " by to witness this enchanted old ruin.";
        hint = "In sight are: A statue and an altar.";
        roomContainer = new RoomContainer(map.getRoomItems(name));

    }
}
