/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

/**
 * @author Aenaos
 */
@Component("forest")
public class Forest extends Room implements Observer {

    @Autowired
    public Forest(Map map) {
        name = "forest";
        description = "You are in the forest. West of you there's a castle, and in the east there's a keep ";
        hint = "One tree looks different from the others, it's sticking out. In front of you lies a rusty key";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }

    @Override
    public void update(State state) {
        if (!this.existsInRoom("rusty key")) {
            setHint("One tree looks different from the others, it's sticking out.");
        }
        if (!this.existsInRoom("sundial")) {
            this.setDescription("Nothing to see here, just a tree.");
        }
    }

    @Override
    public String move(State state) {
        if (state.getPreviousRoom().getName().equals("starting room")) {
            state.setPreviousRoom(this);
        }
        state.setCurrentRoom(this);
        return this.getMovementMessage();
    }
}
