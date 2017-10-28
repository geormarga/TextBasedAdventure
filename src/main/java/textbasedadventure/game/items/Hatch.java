/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.game.items;

import textbasedadventure.game.features.FeatureFactory;
import textbasedadventure.game.features.Openable;
import textbasedadventure.game.Inventory;
import textbasedadventure.game.State;

/**
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

    public Hatch(FeatureFactory featureFactory) {
        name = "hatch";
        description = "The area below the hatch is flooded. I need to get rid of the water so that I can go down there.";
        featureFactory.registerFeature(this.name, this);
    }

    void updateDescription() {
        this.setDescription("Water's gone. You can proceed.");
    }

    public String open(String attr, State state) {

        WoodenWheel wheel = (WoodenWheel) state.getFeatureFactory().createFeature("wooden wheel");
        if (!wheel.isTurned()) {
            return "You need to get rid of the water first.";
        } else {
            setDescription("The hatch is now open.");
            return "The hatch is now open.";
        }
    }

    @Override
    public String open(Inventory inventory) {
        //if wheel is turned open hatch
        return "Not implemented method";
    }
}
