package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

import javax.annotation.PostConstruct;

@Component("starting room")
public class StartingRoom extends Room {

    @Autowired
    public StartingRoom(Map map) {
        name = "starting room";
        description = "Welcome, this is the starting room!\n"
                + "The goal of the game is to collect all artifacts\n"
                + "and find the Escape Room to escape.\n"
                + "By typing exit game, you can exit anytime. Type start game to begin...";
        hint = "This is the starting room. What did you expect to see?";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }

    @Override
    public String move(State state) {
        state.setPreviousRoom(this);
        state.setCurrentRoom(this);
        return this.getMovementMessage();
    }
}
