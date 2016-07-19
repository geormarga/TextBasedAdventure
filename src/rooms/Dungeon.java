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
public class Dungeon extends Room implements Observer {

    HashMapOfElements<Item> container;

    public Dungeon() {
        name = "dungeon";
        description = "This must be a dungeon, by the looks of it many people drew their final breath here...";
        hint = "There's a musty corpse on the ground";
        containerType =  new DoesContain();
        container = new HashMapOfElements<>();

    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getMovementMessage() {
        // if ("down".equals(attr)
        String as = "The staircase collapsed, and you died!\n\nGame Over\n";
        //action.act("newGame.sav", state);
    }
}
