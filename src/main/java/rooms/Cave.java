/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.FeatureFactory;
import items.containers.GoldenChest;
import textbasedadventure.Observer;
import textbasedadventure.Map;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class Cave extends Room implements Observer {


    public Cave(FeatureFactory featureFactory, Map map) {
        name = "cave";
        description = "You are in a cave.";
        hint = "Its kinda dark and you can't see well in here, but you can hear someone screaming!";
        featureFactory.registerFeature(this.name, this);
        this.setNearbyRooms(map.getNearbyRooms(this.name));
        this.setRoomItems(map.getRoomItems(this.name));

    }

    @Override
    public void update(State state) {
        GoldenChest chest = (GoldenChest) state.getFeatureFactory().createFeature("golden chest");
        if (chest.isOpen()) {

            this.registerItem("torn note");
            this.registerItem("circular artifact");
            chest.getContainerItems().add("torn note");
            chest.getContainerItems().add("circular artifact");

            System.out.println("Items in chest:");
            for (String key : chest.getContainerItems()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}

