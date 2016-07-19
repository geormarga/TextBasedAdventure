/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import items.Hatch;
import items.Item;
import items.Torch;
import items.WoodenWheel;
import textbasedadventure.Observer;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class DeadEnd extends Room implements Observer {

    public DeadEnd() {
        name = "dead end";
        description = "This is the end of the road. There is a switchlike wheel, and a hatch in the room.";
        hint = "While looking arround you stumble upon a hole in the ground.";
        containerType = new DoesNotContain();
    }
    /*
     System.out.println("You must open the hatch first.");
     */

    @Override
    public void update() {
        if (!roomItems.existsInHashMap("torch")) {
            //hole desc = setDescription("Just an empty hole...");
        }

        WoodenWheel wheel = (WoodenWheel) roomItems.getElements().get("wheel");
        if (wheel.isTurned()) {
            Hatch hatch = (Hatch) roomItems.getElements().get("hatch");
            hatch.setOpen(true);
        }
    }

    private void createItem(State state) {
        if (description.equals("There's a hole on the ground, and what looks to be a torch in it.")) {
            Item torch = new Torch();
            state.getCurrentRoom().getRoomItems().getElements().put("torch", torch);
        }
    }
}
