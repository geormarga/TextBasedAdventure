package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.items.Item;

@Component("mud pit")
public class Mudpit extends Item {

    public Mudpit() {
        name = "mud pit";
        description = "There's a key in the mudpit.";
    }
}
