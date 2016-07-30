/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Pickable;
import rooms.Room;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public class SilverKey extends Item implements Pickable {

    public SilverKey() {
        name = "silver key";
        description = "This key can unlock silver chests.";
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a silver key.");
    }
}
