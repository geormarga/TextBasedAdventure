package textbasedadventure.webapp.game.items;

import textbasedadventure.webapp.game.features.Openable;
import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.State;

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

    void updateDescription() {
        this.setDescription("Water's gone. You can proceed.");
    }

    public String open(String attr, State state) {

        WoodenWheel wheel = (WoodenWheel) state.getFeatureFactory().getFeature("wooden wheel");
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
