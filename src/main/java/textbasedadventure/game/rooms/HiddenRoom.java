/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.rooms;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.items.Stand;
import textbasedadventure.game.Map;
import textbasedadventure.game.Observer;
import textbasedadventure.game.State;

/**
 * @author Aenaos
 */
public class HiddenRoom extends Room implements Observer {

    public HiddenRoom(FeatureFactory featureFactory, Map map) {
        name = "hidden room";
        description = "Wow. I didn't believe that it would work!";
        hint = "There is a stand in the center of the room.";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(map.getNearbyRooms(this.name));
        this.setRoomItems(map.getRoomItems(this.name));
    }

    @Override
    public void update(State state) {
        if (!state.getCurrentRoom().existsInRoom("triangular artifact")) {
            Stand stand = (Stand) state.getFeatureFactory().createFeature("stand");
            stand.setDescription("A stone stand.");
        }
    }
}
