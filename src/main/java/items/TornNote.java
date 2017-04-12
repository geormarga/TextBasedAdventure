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
public class TornNote extends Item implements Pickable {

    public TornNote(FeatureFactory featureFactory) {
        name = "torn note";
        description = "To succeed in the quest of thee, you must find artifacts three ...";
        featureFactory.registerFeature(this.name, this);
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a torn note.");
    }
}
