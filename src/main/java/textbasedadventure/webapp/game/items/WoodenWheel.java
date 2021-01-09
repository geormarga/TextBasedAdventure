/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Turnable;
import textbasedadventure.webapp.game.State;

/**
 * @author Aenaos
 */
@Component("wooden wheel")
public class WoodenWheel extends Item implements Turnable {

    private boolean turned = false;

    public WoodenWheel() {
        name = "wooden wheel";
        description = "You can turn it, to open the floodgate.";
        //featureFactory.registerFeature(this.name, this);
    }

    public boolean isTurned() {
        return turned;
    }

    private void setTurned(boolean turned) {
        this.turned = turned;
    }

    @Override
    public String turn(State state) {

        if (!isTurned()) {
            this.setTurned(true);
            this.setDescription("Already turned.");
            Hatch hatch = (Hatch) state.getFeatureFactory().getFeature("hatch");
            hatch.setOpen(true);
            hatch.updateDescription();
            return "The floodgate is open.";
        } else {
            return this.getDescription();
        }
    }
}
