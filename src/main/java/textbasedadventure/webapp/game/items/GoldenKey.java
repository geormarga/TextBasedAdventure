package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.items.containers.Inventory;

@Component("golden key")
public class GoldenKey extends Item implements Pickable {

    public GoldenKey() {
        name = "golden key";
        description = "With this key you can unlock golden chests";
    }

    @Override
    public String pickup(Inventory inventory, Container container) {
        inventory.registerItem(this.name);
        container.unregisterItem(this.name);
        return "You picked up a golden key.";
    }

}
