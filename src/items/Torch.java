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
public class Torch extends Item implements Pickable {

    public Torch() {
        name = "torch";
        description = "A wooden torch that can be used to see in the dark";
    }

    @Override
    public void pickup(Inventory inventory, HashMapOfElements<Item> roomItems) {
        inventory.addElement(this.name, this);
        roomItems.removeElement(this.name, this);
        System.out.println("You picked up a torch.");
    }
    /*
     public void use(String attr, State state) {
     setLit(true);
     setDescription("It is lit so that you can see in the dark.");
     System.out.println(this.getDescription());
     }*/

}
