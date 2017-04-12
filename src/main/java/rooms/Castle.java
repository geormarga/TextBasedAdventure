/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.FeatureFactory;
import items.containers.CommonChest;
import textbasedadventure.Observer;
import textbasedadventure.ReadXMLFile;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class Castle extends Room implements Observer {

    public Castle(FeatureFactory featureFactory, ReadXMLFile readXMLFile) {
        name = "castle";
        description = "You are in the castle yard. You are free to go in, but there is also a cave to the west...";
        hint = "You found a chest on the ground.";
        featureFactory.registerFeature(this.name,this);
        this.setNearbyRooms(readXMLFile.getNearbyRooms(this.name));
        this.setRoomItems(readXMLFile.getRoomItems(this.name));
    }

    @Override
    public void update(State state) {
        CommonChest chest = (CommonChest) state.getFeatureFactory().createFeature("common chest");
        if (chest.isOpen()) {
            this.registerItem("circular artifact");
            //register in container
            System.out.println("Items in chest:");
            for (String key : chest.getContainerItems()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}
