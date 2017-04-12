/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.FeatureFactory;
import features.Pickable;
import rooms.Room;
import textbasedadventure.Inventory;

/**
 * @author Aenaos
 */
public class GoldenKey extends Item implements Pickable {

    public GoldenKey(FeatureFactory featureFactory) {
        name = "golden key";
        description = "With this key you can unlock golden chests";
        featureFactory.registerFeature(this.name, this);
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a golden key.");
    }

}
