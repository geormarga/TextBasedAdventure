package textbasedadventure.webapp.game.features;

import textbasedadventure.webapp.game.rooms.Room;
import textbasedadventure.webapp.game.items.containers.Inventory;

public interface Usable extends Feature {

    String use(Inventory inventory, Room room);
}
