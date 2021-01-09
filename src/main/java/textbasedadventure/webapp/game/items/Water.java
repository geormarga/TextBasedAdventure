package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

@Component("water")
public class Water extends Item {

    public Water() {
        name = "water";
        description = "A lot of water.";
    }

}
