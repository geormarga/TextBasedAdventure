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
public class CircularArtifact extends Item implements Pickable, Usable {

    public CircularArtifact() {
        name = "circular artifact";
        description = "One of the three sun artifacts. It has the shape of a circle.";
    }

    @Override
    public void pickup(Inventory inventory, HashMapOfElements<Item> roomItems) {
        inventory.addElement(this.name,this);
        roomItems.removeElement(this.name,this);
        System.out.println("You picked up a circular artifact.");
    }

    @Override
    public void use(Inventory inventory, HashMapOfElements<Item> roomItems) {
        roomItems.addElement("circularArtifact", this);
        inventory.removeElement(this.name ,this);
        //altar you already set the object
    }
}
