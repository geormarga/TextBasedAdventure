/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.containers;

import items.Item;
import items.Torch;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class Hole extends Item {

    public Hole() {
        this.setName("hole");
        setDescription("There's a hole on the ground, and what looks to be a torch in it.");
    }

    private void createItem(State state) {
        if (description.equals("There's a hole on the ground, and what looks to be a torch in it.")) {
            Item torch = new Torch();
            state.getCurrentRoom().getRoomItems().getElements().put("torch", torch);
        }
    }

    public void update() {
        if (!getContainerItems().getItems().containsKey("torch")) {
            this.setDescription("Just an empty hole...");
        }
    }

     //torch 
    //"");
}
