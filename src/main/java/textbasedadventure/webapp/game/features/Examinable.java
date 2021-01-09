package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.items.containers.Inventory;

public interface Examinable extends Feature {

    String examine(Inventory inventory);
}
