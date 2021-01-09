package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

@Component
public class Dungeon extends Room implements Observer {

    @Autowired
    public Dungeon(Map map) {
        name = "dungeon";
        description = "This must be a dungeon, by the looks of it many people drew their final breath here...";
        hint = "There's a musty corpse on the ground";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }

    @Override
    public void update(State state) {}

    @Override
    public String getMovementMessage() {
        // if ("down".equals(attr)
        return "The staircase collapsed, and you died!\n\nGame Over\n";
        //action.act(, state);
    }
}
