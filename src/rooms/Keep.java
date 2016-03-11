/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.Containable;
import items.Item;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Keep extends Room implements Observer {

    HashMapOfElements<Item> container;

    public Keep() {
        setDescription("You are in the keep. Unfortunately there's no visible path from which you can enter.");
        setHint("You see something shining in a mudpit. A silver chest lies on the ground.");
        containerType = (Containable) new DoesContain();
        container = new HashMapOfElements<>();
    }

    @Override
    public void update() {
        if (!roomItems.getElements().containsKey("key")) {
            setHint("A mudpit formed on the floor of the keep. A chest lies on the ground as well.");
            //
        }
    }
}
