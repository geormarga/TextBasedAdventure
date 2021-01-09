package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.items.containers.Container;

public interface Pickable extends Examinable {

    String pickup(Inventory inventory, Container container);
}
