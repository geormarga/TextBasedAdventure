package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

@Component("corpse")
public class Corpse extends Item {

    public Corpse() {
        name = "corpse";
        description = "Must have been dead for years, can't even tell if it's human or not."
                + " There's a piece of parchment on the corpse.";
    }

}
