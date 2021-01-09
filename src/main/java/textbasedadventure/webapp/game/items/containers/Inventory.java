package textbasedadventure.webapp.game.items.containers;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Showable;



/**
 * @author Aenaos
 */
@Component("inventory")
public class Inventory extends Container implements Showable {

    public Inventory() {
        name = "inventory";
    }

    public boolean isInInventory(String item) {
        return this.isInContainer(item);
    }
}
