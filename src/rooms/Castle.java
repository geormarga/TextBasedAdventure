/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

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
        name= "castle";
        description = "You are in the castle yard. You are free to go in, but there is also a cave to the west...";
        hint = "You found a chest on the ground.";
        containerType = new DoesContain();
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
            CircularArtifact artifact = new CircularArtifact();
            
            roomItems.addElement("artifact", artifact);
            container.addElement("artifact", artifact);
            
            System.out.println("Items in chest:");
            for (String key : container.getElements().keySet()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}
