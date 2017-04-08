/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.FeatureFactory;
import items.containers.SilverChest;
import textbasedadventure.Observer;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class Keep extends Room implements Observer {

    public Keep(FeatureFactory featureFactory) {
        name = "keep";
        description = "You are in the keep. Unfortunately there's no visible path from which you can enter.";
        hint = "You see something shining in a mudpit. A silver chest lies on the ground.";
        featureFactory.registerFeature(this.name,this);
    }

    @Override
    public void update(State state) {
        if (this.existsInRoom("key")) {
            setHint("A mudpit formed on the floor of the keep. A chest lies on the ground as well.");

        }

        SilverChest chest = (SilverChest) state.getFeatureFactory().createFeature("silver chest");
        if (chest.isOpen()) {

            this.registerItem("circular artifact");
            this.registerItem("torn note");
            chest.getContainerItems().add("circular artifact");
            chest.getContainerItems().add("torn note");

            System.out.println("Items in chest:");
            for (String key : chest.getContainerItems()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}
