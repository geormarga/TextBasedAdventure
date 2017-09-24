/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.FeatureFactory;
import textbasedadventure.Map;

/**
 * @author Aenaos
 */
public class Hall extends Room {

    public Hall(FeatureFactory featureFactory, Map map) {
        name = "hall";
        description = "You went inside the Castle. It's vast halls seem haunted";
        hint = "You can see some rooms left and right ... and stairs heading down.";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(map.getNearbyRooms(this.name));
        this.setRoomItems(map.getRoomItems(this.name));
    }
}
