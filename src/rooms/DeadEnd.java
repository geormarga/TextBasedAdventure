/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import features.Containable;
import items.Hatch;
import items.WoodenWheel;
import textbasedadventure.Observer;

/**
 *
 * @author Aenaos
 */
public class DeadEnd extends Room implements Observer {

    public DeadEnd() {

        description = "This is the end of the road. There is a switchlike wheel, and a hatch in the room.";
        hint = "While looking arround you stumble upon a hole in the ground.";
        containerType = (Containable) new DoesNotContain();
    }
    /*
     System.out.println("You must open the hatch first.");
     */

    @Override
    public void update() {
        if (!roomItems.existsInHashMap("torch")) {
            //state.getCurrentRoom().getFeature("takis");
        }

        WoodenWheel wheel = (WoodenWheel) roomItems.getElements().get("wheel");
        if (wheel.isTurned()) {
            Hatch hatch = (Hatch) roomItems.getElements().get("hatch");
            hatch.setOpen(true);
        }
    }
}