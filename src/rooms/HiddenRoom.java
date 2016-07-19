/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import items.Item;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class HiddenRoom extends Room implements Observer {

    HashMapOfElements<Item> container;
    
    public HiddenRoom() {
        name = "hidden room";
        description = "Wow. I didn't believe that it would work!";
        hint = "There is a stand in the center of the room.";
        containerType =  new DoesContain();
        container = new HashMapOfElements<>();
    }

    @Override
    public void update() {
        if (!roomItems.getElements().containsKey("artifact")) {
            roomItems.getElements().get("stand").setDescription("A stone stand.");
        }
    }
}
