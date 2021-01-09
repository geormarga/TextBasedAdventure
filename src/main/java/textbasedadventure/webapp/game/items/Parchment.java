package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.items.containers.Inventory;

@Component("parchment")
public class Parchment extends Item implements Pickable {

    public Parchment() {

        name = "parchment";
        description = "It's all smudged. After all, moisture isn't papers' best friend...";
    }

    @Override
    public String pickup(Inventory inventory, Container container) {
        inventory.registerItem(this.name);
        container.unregisterItem(this.name);
        return "You picked up a plain note.";
    }
}
