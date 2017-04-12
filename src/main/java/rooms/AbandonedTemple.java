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
public class AbandonedTemple extends Room implements Observer{

    public AbandonedTemple(FeatureFactory featureFactory, ReadXMLFile readXMLFile) {
        name = "abandoned temple";
        description = "This is the temple of sunlight. Many pilgrims through the years came"
                + " by to witness this enchanted old ruin.";
        hint = "In sight are: A statue and an altar.";
        featureFactory.registerFeature(this.name,this);
        this.setNearbyRooms(readXMLFile.getNearbyRooms(this.name));
        this.setRoomItems(readXMLFile.getRoomItems(this.name));
    }

    @Override
    public void update(State state) {
        //each one is set and all together 4 cases
    }
}
