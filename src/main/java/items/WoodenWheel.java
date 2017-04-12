/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.FeatureFactory;
import features.Turnable;
import textbasedadventure.State;

/**
 * @author Aenaos
 */
public class WoodenWheel extends Item implements Turnable {

    private boolean turned = false;

    public WoodenWheel(FeatureFactory featureFactory) {
        name = "wooden wheel";
        description = "You can turn it, to open the floodgate.";
        featureFactory.registerFeature(this.name, this);
    }

    public boolean isTurned() {
        return turned;
    }

    private void setTurned(boolean turned) {
        this.turned = turned;
    }

    @Override
    public void turn(State state) {

        if (!isTurned()) {
            this.setTurned(true);
            this.setDescription("Already turned.");
            System.out.println("The floodgate is open.");
            Hatch hatch = (Hatch) state.getFeatureFactory().createFeature("hatch");
            hatch.setOpen(true);
            hatch.updateDescription();
        } else {
            System.out.println(this.getDescription());
        }
    }

}
