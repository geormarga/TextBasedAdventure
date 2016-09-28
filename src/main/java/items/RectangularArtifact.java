/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Pickable;
import features.Usable;
import rooms.Room;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public class RectangularArtifact extends Item implements Pickable, Usable {

    public RectangularArtifact() {
        name = "rectangular artifact";
        description = "One of the three sun artifacts. It has the shape of a rectangle.";
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a rectangular artifact.");
    }

    @Override
    public void use(Inventory inventory,Room room) {
        room.registerItem(this.name);
        inventory.unregisterItem(this.name);
        //altar you already set the object
    }
}
