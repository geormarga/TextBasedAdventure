package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;
import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.items.containers.Inventory;

@Component("silver key")
public class SilverKey extends Item implements Pickable {

    public SilverKey() {
        name = "silver key";
        description = "This key can unlock silver chests.";
    }

    @Override
    public String pickup(Inventory inventory, Container container) {
        inventory.registerItem(this.name);
        container.unregisterItem(this.name);
        return "You picked up a silver key.";
    }
}
