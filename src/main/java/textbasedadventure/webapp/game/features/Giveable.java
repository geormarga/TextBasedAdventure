package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.items.Item;

public interface Giveable extends Feature {

    String give(Inventory inventory, Item item);
}
