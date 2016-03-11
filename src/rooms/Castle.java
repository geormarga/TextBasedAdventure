/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.Containable;
import items.CircularArtifact;
import items.Item;
import items.containers.CommonChest;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Castle extends Room implements Observer {

    HashMapOfElements<Item> container;

    public Castle() {
        description = "You are in the castle yard. You are free to go in, but there is also a cave to the west...";
        hint = "You found a chest on the ground.";
        containerType = (Containable) new DoesContain();
        container = new HashMapOfElements<>();
    }

    public HashMapOfElements<Item> getContainer() {
        return container;
    }

    public void setContainer(HashMapOfElements<Item> container) {
        this.container = container;
    }

    @Override
    public void update() {
        CommonChest chest = (CommonChest) roomItems.getElements().get("chest");
        if (chest.isOpen()) {
            roomItems.addElement("artifact", new CircularArtifact());
            System.out.println("Items in chest:");
            for (String key : getContainerItems().getElements().keySet()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}
