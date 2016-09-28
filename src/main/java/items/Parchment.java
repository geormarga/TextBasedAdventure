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
public class Parchment extends Item implements Pickable {

    public Parchment() {

        name = "parchment";
        description = "It's all smudged. After all, moisture isn't papers' best friend...";
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a plain note.");
    }
}
