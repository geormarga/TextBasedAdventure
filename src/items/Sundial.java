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
public class Sundial extends Item implements Pickable {

    public Sundial() {
        this.setName("sundial");
        setDescription("It's a sundial.You look closer only to find a line, marking the dial: Ten to two .");
    }

    @Override
    public void pickup(Inventory inventory, HashMapOfElements<Item> roomItems) {
        inventory.addElement(this.name, this);
        roomItems.removeElement(this.name, this);
        System.out.println("You picked up a sundial.");
    }

}
