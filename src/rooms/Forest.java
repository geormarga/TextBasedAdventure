/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class Forest extends Room implements Observer {

    public Forest() {

        setDescription("You are in the forest. West of you there's a castle, and in the east there's a keep ");
        setHint("One tree looks different from the others, it's sticking out. In front of you lies a rusty key");
        roomItems.register(this);
    }

    @Override
    public void update() {
        if (!roomItems.getItems().containsKey("key")) {
            setHint("One tree looks different from the others, it's sticking out.");
        }
        if (!roomItems.getItems().containsKey("sundial")) {
            roomItems.getItems().get("tree").setDescription("Nothing to see here, just a tree.");
        }
        
    }
}
