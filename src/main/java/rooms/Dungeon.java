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
 * @author Aenaos
 */
public class Dungeon extends Room implements Observer {

    public Dungeon(FeatureFactory featureFactory, ReadXMLFile readXMLFile) {
        name = "dungeon";
        description = "This must be a dungeon, by the looks of it many people drew their final breath here...";
        hint = "There's a musty corpse on the ground";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(readXMLFile.getNearbyRooms(this.name));
        this.setRoomItems(readXMLFile.getRoomItems(this.name));
    }

    @Override
    public void update(State state) {
        //
    }

    @Override
    public void getMovementMessage() {
        // if ("down".equals(attr)
        String as = "The staircase collapsed, and you died!\n\nGame Over\n";
        //action.act(, state);
    }
}
