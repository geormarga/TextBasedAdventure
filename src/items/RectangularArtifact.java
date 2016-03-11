/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Pickable;
import features.Usable;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.Inventory;

/**
 *
 * @author Aenaos
 */
public class RectangularArtifact extends Item implements Pickable, Usable {

    public RectangularArtifact() {
        this.setName("rectangular artifact");
        setDescription("One of the three sun artifacts. It has the shape of a rectangle.");
    }

    @Override
    public void pickup(Inventory inventory, HashMapOfElements<Item> roomItems) {
        inventory.addElement(this.name, this);
        roomItems.removeElement(this.name, this);
        System.out.println("You picked up a rectangular artifact.");
    }

    @Override
    public void use(Inventory inventory, HashMapOfElements<Item> roomItems) {
        roomItems.addElement("rectangularArtifact", this);
        inventory.removeElement(this.name, this);
        //altar you already set the object
    }
}
