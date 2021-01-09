package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.items.containers.Inventory;

public interface Openable extends Feature {

    String open(Inventory inventory);
}
