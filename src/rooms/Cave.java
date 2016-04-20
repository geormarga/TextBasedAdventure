/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import items.CircularArtifact;
import items.Item;
import items.TornNote;
import items.containers.GoldenChest;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Cave extends Room implements Observer {

    HashMapOfElements<Item> container;

    public Cave() {
        setDescription("You are in a cave.");
        setHint("Its kinda dark and you can't see well in here, but you can hear someone screaming!");
        containerType = new DoesContain();
        container = new HashMapOfElements<>();
    }

    @Override
    public void update() {
        GoldenChest chest = (GoldenChest) roomItems.getElements().get("chest");
        if (chest.isOpen()) {
            CircularArtifact artifact = new CircularArtifact();
            TornNote note = new TornNote();
            
            roomItems.addElement("artifact", artifact);
            container.addElement("artifact", artifact);
            roomItems.addElement("artifact", note);
            container.addElement("artifact", note);
            
            System.out.println("Items in chest:");
            for (String key : container.getElements().keySet()) {
                System.out.println(key + ",");
            }
            System.out.println(".");
        }
    }
}

