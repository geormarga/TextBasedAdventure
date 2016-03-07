/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Pickable;
import textbasedadventure.Inventory;
import textbasedadventure.RoomItems;

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
    public void pickup(Inventory inventory, RoomItems roomItems) {
        inventory.addItemToInventory(this);
        roomItems.removeItemFromRoom(this);
        System.out.println("You picked up a sundial.");
    }

}
