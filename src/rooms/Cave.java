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
public class Cave extends Room implements Observer {

    HashMapOfElements<Item> container;

    public Cave() {
        setDescription("You are in a cave.");
        setHint("Its kinda dark and you can't see well in here, but you can hear someone screaming!");
        containerType = (Containable) new DoesContain();
        container = new HashMapOfElements<>();
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
