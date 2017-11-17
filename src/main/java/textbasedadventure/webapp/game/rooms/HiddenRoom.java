/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.rooms;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.items.Stand;
import textbasedadventure.webapp.game.Observer;
import textbasedadventure.webapp.game.State;

import javax.annotation.PostConstruct;

/**
 * @author Aenaos
 */
@Component
public class HiddenRoom extends Room implements Observer {

    public HiddenRoom() {
        name = "hidden room";
        description = "Wow. I didn't believe that it would work!";
        hint = "There is a stand in the center of the room.";
    }
    @PostConstruct
    private void init(){
        //featureFactory.registerFeature(name, this);
        this.setNearbyRooms(map.getNearbyRooms(name));
        this.setRoomItems(map.getRoomItems(name));
    }

    @Override
    public void update(State state) {
        if (!state.getCurrentRoom().existsInRoom("triangular artifact")) {
            Stand stand = (Stand) state.getFeatureFactory().createFeature("stand");
            stand.setDescription("A stone stand.");
        }
    }
}
