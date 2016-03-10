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
public class RustyKey extends Item implements Pickable {

    public RustyKey() {
        this.setName("rusty key");
        setDescription("This key can unlock common chests.");
    }

    @Override
    public void pickup(Inventory inventory, HashMapOfElements<Item> roomItems) {
        inventory.addElement(this.name, this);
        roomItems.removeElement(this.name, this);
        System.out.println("You picked up a rusty key.");
    }
}
