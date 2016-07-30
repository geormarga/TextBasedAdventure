/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Openable;
import rooms.Room;
import textbasedadventure.Inventory;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class Hatch extends Item implements Openable {

    private boolean isOpen;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Hatch() {
        name = "hatch";
        description = "The area below the hatch is flooded. I need to get rid of the water so that I can go down there.";
    }

    public void updateDescription() {
        this.setDescription("Water's gone. You can proceed.");
    }

    public void open(String attr, State state) {

        WoodenWheel wheel= (WoodenWheel) state.getFeatureFactory().createFeature("wooden wheel");
        if (!wheel.isTurned()) {
            System.out.println("You need to get rid of the water first.");
        } else {
            System.out.println("The hatch is now open.");
            setDescription("The hatch is now open.");

        }
    }

    @Override
    public void open(Inventory inventory) {
        //if wheel is turned open hatch
    }
}
