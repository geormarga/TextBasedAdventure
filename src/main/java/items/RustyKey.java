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
 *
 * @author Aenaos
 */
public class RustyKey extends Item implements Pickable {

    public RustyKey(FeatureFactory featureFactory) {
        name = "rusty key";
        description = "This key can unlock common chests.";
        featureFactory.registerFeature(this.name,this);
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a rusty key.");
    }
}
