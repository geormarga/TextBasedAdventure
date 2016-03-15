/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Pickable;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public class PlainNote extends Item implements Pickable {

    public PlainNote() {
        
        name = "plain note";
        description = "I do not know if anyone is reading this."
                + "When you will arrive in the hall of Castle , don't go down the stairs. "
                + "For your own safety!";
    }

    @Override
    public void pickup(Inventory inventory, HashMapOfElements<Item> roomItems) {
        inventory.addElement(this.name, this);
        roomItems.removeElement(this.name, this);
        System.out.println("You picked up a plain note.");
    }
}
