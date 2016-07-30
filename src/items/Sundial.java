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
public class Sundial extends Item implements Pickable {

    public Sundial() {
        name = "sundial";
        description = "It's a sundial.You look closer only to find a line, marking the dial: Ten to two .";
    }

    @Override
    public void pickup(Inventory inventory, Room room) {
        inventory.registerItem(this.name);
        room.unregisterItem(this.name);
        System.out.println("You picked up a sundial.");
    }

}
