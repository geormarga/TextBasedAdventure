package textbasedadventure.webapp.game.items;

import org.springframework.stereotype.Component;

import textbasedadventure.webapp.game.features.Pickable;
import textbasedadventure.webapp.game.items.containers.Container;
import textbasedadventure.webapp.game.items.containers.Inventory;

@Component("torn note")
public class TornNote extends Item implements Pickable {

    public TornNote() {
        name = "torn note";
        description = "To succeed in the quest of thee, you must find artifacts three ...";
    }

    @Override
    public String pickup(Inventory inventory, Container container) {
        inventory.registerItem(this.name);
        container.unregisterItem(this.name);
        return "You picked up a torn note.";
    }
}
