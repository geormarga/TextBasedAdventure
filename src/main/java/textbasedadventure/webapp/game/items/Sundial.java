package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.items.containers.Inventory;

@Component("sundial")
public class Sundial extends Item implements Pickable {

    public Sundial() {
        name = "sundial";
        description = "It's a sundial.You look closer only to find a line, marking the dial: Ten to two .";
    }

    @Override
    public String pickup(Inventory inventory, Container container) {
        inventory.registerItem(this.name);
        container.unregisterItem(this.name);
        return "You picked up a sundial.";
    }

}
