package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.rooms.Room;

@Component("rock")
public class Rock extends Item {

    public Rock() {
        name = "rock";
        description = "Lifting the rock revealed a hidden place. There is a golden chest";
    }

    private void createItem(Room room) {
        room.registerItem("elixir");
        room.registerItem("golden chest");
    }
}
