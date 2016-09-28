/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import features.Turnable;
import textbasedadventure.State;

/**
 *
 * @author Aenaos
 */
public class WoodenWheel extends Item implements Turnable {

    boolean turned;

    public WoodenWheel() {
        name = "wooden wheel";
        description = "You can turn it, to open the floodgate.";
    }

    public boolean isTurned() {
        return turned;
    }

    public void setTurned(boolean turned) {
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
        }else{
            System.out.println(this.getDescription());
        }
    }

}
