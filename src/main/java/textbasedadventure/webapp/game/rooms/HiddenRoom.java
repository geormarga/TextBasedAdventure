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
import textbasedadventure.webapp.game.items.Stand;
import textbasedadventure.webapp.game.items.containers.RoomContainer;

/**
 * @author Aenaos
 */
@Component
public class HiddenRoom extends Room implements Observer {

    @Autowired
    public HiddenRoom(Map map) {
        name = "hidden room";
        description = "Wow. I didn't believe that this would work!";
        hint = "There is a stand in the center of the room.";
        roomContainer = new RoomContainer(map.getRoomItems(name));
    }

    @Override
    public void update(State state) {
        if (!state.getCurrentRoom().existsInRoom("triangular artifact")) {
            Stand stand = (Stand) state.getFeatureFactory().getFeature("stand");
            stand.setDescription("A stone stand.");
        }
    }
}
