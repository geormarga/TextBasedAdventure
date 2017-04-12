/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.FeatureFactory;
import textbasedadventure.Observer;
import textbasedadventure.ReadXMLFile;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class Forest extends Room implements Observer {

    public Forest(FeatureFactory featureFactory, ReadXMLFile readXMLFile) {
        name = "forest";
        description = "You are in the forest. West of you there's a castle, and in the east there's a keep ";
        hint = "One tree looks different from the others, it's sticking out. In front of you lies a rusty key";
        featureFactory.registerFeature(this.name,this);
        this.setNearbyRooms(readXMLFile.getNearbyRooms(this.name));
        this.setRoomItems(readXMLFile.getRoomItems(this.name));
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
    public void move(State state) {
        if (state.getPreviousRoom().getName().equals("starting room")) {
            state.setPreviousRoom(this);
        }
        state.setCurrentRoom(this);
        this.getMovementMessage();
    }
}
