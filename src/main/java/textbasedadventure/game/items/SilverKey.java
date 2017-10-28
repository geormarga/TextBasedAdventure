/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.items;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.features.Pickable;
import textbasedadventure.game.rooms.Room;
import textbasedadventure.game.Inventory;

/**
 * @author Aenaos
 */
public class SilverKey extends Item implements Pickable {

    public SilverKey(FeatureFactory featureFactory) {
        name = "silver key";
        description = "This key can unlock silver chests.";
        featureFactory.registerFeature(this.name, this);
    }

    @Override
    public String pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        return "You picked up a silver key.";
    }
}
