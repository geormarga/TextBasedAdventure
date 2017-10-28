/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.rooms;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.Map;

/**
 * @author Aenaos
 */
public class LivingRoom extends Room {

    public LivingRoom(FeatureFactory featureFactory, Map map) {
        name = "living room";
        description = "This is the main Dining Room. The plates on the table indicated that this castle has long been abandonded.";
        hint = "This room is a mess... something happened here!";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(map.getNearbyRooms(this.name));
        this.setRoomItems(map.getRoomItems(this.name));
    }
}
