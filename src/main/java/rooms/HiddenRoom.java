/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.FeatureFactory;
import items.Stand;
import textbasedadventure.Observer;
import textbasedadventure.ReadXMLFile;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class HiddenRoom extends Room implements Observer {

    public HiddenRoom(FeatureFactory featureFactory, ReadXMLFile readXMLFile) {
        name = "hidden room";
        description = "Wow. I didn't believe that it would work!";
        hint = "There is a stand in the center of the room.";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(readXMLFile.getNearbyRooms(this.name));
        this.setRoomItems(readXMLFile.getRoomItems(this.name));
    }

    @Override
    public void update(State state) {
        if (!state.getCurrentRoom().existsInRoom("triangular artifact")) {
            Stand stand = (Stand) state.getFeatureFactory().createFeature("stand");
            stand.setDescription("A stone stand.");
        }
    }
}
