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
import items.containers.SilverChest;
import textbasedadventure.HashMapOfElements;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Keep extends Room implements Observer {

    HashMapOfElements<Item> container;

    public Keep() {
        description = "You are in the keep. Unfortunately there's no visible path from which you can enter.";
        hint = "You see something shining in a mudpit. A silver chest lies on the ground.";
        containerType =  new DoesContain();
        container = new HashMapOfElements<>();
    }

    @Override
    public void update() {
        if (!roomItems.getElements().containsKey("key")) {
            setHint("A mudpit formed on the floor of the keep. A chest lies on the ground as well.");
            
        }
        
        SilverChest chest = (SilverChest) roomItems.getElements().get("chest");
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
