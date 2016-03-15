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
public class Forest extends Room implements Observer {

    HashMapOfElements<Item> container;

    public Forest() {
        description = "You are in the forest. West of you there's a castle, and in the east there's a keep ";
        hint = "One tree looks different from the others, it's sticking out. In front of you lies a rusty key";
        containerType = new DoesContain();
        container = new HashMapOfElements<>();
        roomItems.register(this);
    }

    @Override
    public void update() {
        if (!roomItems.getElements().containsKey("key")) {
            setHint("One tree looks different from the others, it's sticking out.");
        }
        if (!container.getElements().containsKey("sundial")) {
            this.setDescription("Nothing to see here, just a tree.");
        }
    }
}
